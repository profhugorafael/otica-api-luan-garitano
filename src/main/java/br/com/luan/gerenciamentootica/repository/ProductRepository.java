package br.com.luan.gerenciamentootica.repository;

import br.com.luan.gerenciamentootica.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}