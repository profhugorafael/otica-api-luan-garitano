package br.com.luan.gerenciamentootica.controller;

import br.com.luan.gerenciamentootica.model.Product;
import br.com.luan.gerenciamentootica.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    // http://www.google.com/search
    // http -> protocolo
    // "/search" -> recurso
    // http methods = GET, POST, PUT, DELETE, PATCH

    // requisicao = verbo + rota
    // GET + /products
    // POST + /products

    // resposta -> headers + body + statusCode

    // [privacidade] [keywords] [variavel/metodo]

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("{id}") // /products/1
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).get();
    }

    @PostMapping
    public void createProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

}