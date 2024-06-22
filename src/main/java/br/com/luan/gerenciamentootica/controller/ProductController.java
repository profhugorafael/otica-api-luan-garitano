package br.com.luan.gerenciamentootica.controller;

import br.com.luan.gerenciamentootica.model.Product;
import br.com.luan.gerenciamentootica.repository.ProductRepository;
import br.com.luan.gerenciamentootica.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getAll();

        if (products.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(products); // Response.status().body();
    }

    @GetMapping("{id}") // /products/1
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(productService.getById(id));
        } catch (IllegalArgumentException err) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody Product productRequest) {
        try {
            productService.create(productRequest);
        } catch (IllegalArgumentException err) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}