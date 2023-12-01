package com.productservice.productservice.thirdPartyClients;

import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exception.ProductNotFoundException;

import java.util.List;

public interface ThirdPartyInterface {
    GenericProductDto getProductById(Long id) throws ProductNotFoundException;
    List<GenericProductDto> getAllProducts();

    GenericProductDto deleteProductById(Long id);

    GenericProductDto createProduct(GenericProductDto genericProductDto);
    GenericProductDto updateProductById(Long id,GenericProductDto genericProductDto) throws ProductNotFoundException;
}


