package com.productservice.productservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseModel {
    private String title;
    private String description;
//    private int price;
    private String image;
    //category is not a primitive attribute
    @ManyToOne(optional = false)
//    @JoinColumn(nullable = false)
    private Category category;

//    @OneToOne(optional = false)
    @OneToOne(cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
//    @JoinColumn(nullable = false)
    private Price price;
}

/*
      1             1
    product ---->category
      m              1
 */
