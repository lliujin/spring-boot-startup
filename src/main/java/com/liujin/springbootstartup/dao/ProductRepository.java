package com.liujin.springbootstartup.dao;

import com.liujin.springbootstartup.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Transactional
    void deleteByProductId(Long id);

    List<Product> findFirst5ByPrice();
}
