package com.liujin.springbootstartup.dao;

import com.liujin.springbootstartup.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    void deleteByProductId(Long id);

    List<Product> findTop6ByOrderByPriceAsc();
}
