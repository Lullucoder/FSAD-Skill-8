package com.example.product.repository;

import com.example.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByCategory(String category);

    List<Product> findByPriceBetween(double min, double max);

    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> getSortedProducts();

    @Query("SELECT p FROM Product p WHERE p.price > ?1")
    List<Product> getExpensiveProducts(double price);

    @Query("SELECT p FROM Product p WHERE p.category = ?1")
    List<Product> getByCategoryJPQL(String category);
}
