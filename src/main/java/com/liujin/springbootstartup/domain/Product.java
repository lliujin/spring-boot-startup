package com.liujin.springbootstartup.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    private Long id;
    private String image;
    private String name;
    private Long price;
}
