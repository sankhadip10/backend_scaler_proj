package com.productservice.productservice.repositories;

//import com.productservice.productservice.UUID;
import com.productservice.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
//    @Override
//    <S extends Product> S save(S entity);


    @Override
    List<Product> findAll(); //Get all the products from the products table

    List<Product> findAllByTitle(String title);

    List<Product>  findByTitleAndDescription(String title,String desc);


    List<Product> findAllByPrice_ValueGreaterThan(Integer x);
}
