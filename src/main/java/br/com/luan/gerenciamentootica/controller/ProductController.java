package br.com.luan.gerenciamentootica.controller;

import br.com.luan.gerenciamentootica.model.Product;
import br.com.luan.gerenciamentootica.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productRepository.findAll();

        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(products); // Response.status().body();
    }


    @GetMapping("{id}") // /products/1
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> searchByProduct = productRepository.findById(id);

        if (searchByProduct.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Product product = searchByProduct.get();
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody Product product) {
        productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}