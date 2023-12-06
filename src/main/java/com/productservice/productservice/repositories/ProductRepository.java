package com.productservice.productservice.repositories;

//import com.productservice.productservice.UUID;
import com.productservice.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
//    @Override
//    <S extends Product> S save(S entity);
}
