package com.liujin.springbootstartup.dao;

import com.liujin.springbootstartup.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    void deleteById(Long id);

    void deleteInBatchById(List<Long> idList);

    List<Product> findTop6ByOrderByPriceAsc();

    Page<Product> findAll(Pageable pageable);

}
