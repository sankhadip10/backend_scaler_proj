package com.productservice.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String title;
    private String description;
    private int price;
    private String image;
    //category is not a primitive attribute
    @ManyToOne
    private Category category;
}

/*
      1             1
    product ---->category
      m              1
 */
