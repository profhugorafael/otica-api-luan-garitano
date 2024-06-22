package br.com.luan.gerenciamentootica.service;

import br.com.luan.gerenciamentootica.model.Product;
import br.com.luan.gerenciamentootica.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(long id) {
        Optional<Product> searchByProduct = productRepository.findById(id);

        if (searchByProduct.isEmpty())
           throw new IllegalArgumentException();

        return searchByProduct.get();
    }

    public void create(Product newProduct) {
        var products = productRepository.findAll();

        var hasOtherProductWithSameTitle = products.stream()
                .anyMatch(product -> product.getTitle().equalsIgnoreCase(newProduct.getTitle()));

        if(newProduct.getQuantity() < 0) {
            throw new IllegalArgumentException("the quantity must be positive");
        }

        if(hasOtherProductWithSameTitle) {
            throw new IllegalArgumentException("already exists a product with same title");
        }

        productRepository.save(newProduct);
    }

}
