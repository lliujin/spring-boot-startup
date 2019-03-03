package com.liujin.springbootstartup.dao;

import com.liujin.springbootstartup.SpringBootStartupApplicationTests;
import com.liujin.springbootstartup.domain.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class ProductRepositoryTest extends SpringBootStartupApplicationTests {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void testInsert() {
        Product product = new Product(1L, "http://spring.io", "test", 2L);
        productRepository.save(product);

        Product productFromDB = productRepository.findById(1L).get();
        assertEquals(product, productFromDB);
    }

    @Test
    public void testUpdate() {
        Product product = new Product(1L, "http://spring.io", "tt", 2L);
        productRepository.save(product);

        Product productFromDB = productRepository.findById(1L).get();
        assertEquals(productFromDB.getName(), "tt");
    }
}