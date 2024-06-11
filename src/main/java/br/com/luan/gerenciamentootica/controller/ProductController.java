package br.com.luan.gerenciamentootica.controller;

import br.com.luan.gerenciamentootica.model.Product;
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

    private static List<Product> products = new ArrayList<>();

    @GetMapping
    public List<Product> getProducts() {
        return products;
    }

    @GetMapping("{id}") // /products/1
    public Product getProductById(@PathVariable Long id) {
        for (Product product : products) {
            if(product.getId() == id) {
                return product;
            }
        }

        return null;
    }

    @PostMapping
    public void createProduct(@RequestBody Product product) {
        products.add(product);
    }

}
