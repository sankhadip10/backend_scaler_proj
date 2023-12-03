package com.productservice.productservice.services;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exception.ProductNotFoundException;
import com.productservice.productservice.thirdPartyClients.fakestoreclient.FakeStoreClientAdapter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Primary
@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    private FakeStoreClientAdapter fakeStoreClientAdapter;
    FakeStoreProductService(FakeStoreClientAdapter fakeStoreClientAdapter){
        this.fakeStoreClientAdapter = fakeStoreClientAdapter;
    }
    private static GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto genericProductDto =new GenericProductDto();
//        FakeStoreProductDto fakeStoreProductDto =responseEntity.getBody();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
//        return responseEntity.getBody();
        return genericProductDto;

    }
    @Override
    public GenericProductDto getProductById(Long id) throws ProductNotFoundException {
        //Integrate the FakeStore API
        //RestTemplate
       return convertToGenericProductDto(fakeStoreClientAdapter.getProductById(id));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<FakeStoreProductDto> fakeStoreProductDtos=fakeStoreClientAdapter.getAllProducts();

        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto:fakeStoreProductDtos){
            genericProductDtos.add(convertToGenericProductDto(fakeStoreProductDto));
        }
        return genericProductDtos;

    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
       return convertToGenericProductDto(fakeStoreClientAdapter.deleteProductById(id));
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return convertToGenericProductDto(fakeStoreClientAdapter.createProduct(genericProductDto));
    }

    @Override
    public GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto) throws ProductNotFoundException {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//
//        // Create an HttpEntity that contains the request body and headers
//        HttpEntity<GenericProductDto> requestEntity = new HttpEntity<>(genericProductDto);
//
//        // Use the exchange method of RestTemplate
//        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.exchange(
//                specificProductUrl,
//                HttpMethod.PUT,
//                requestEntity,
//                FakeStoreProductDto.class,
//                id
//        );
//
//        // Check if response body is null
//        if (responseEntity.getBody() == null) {
//            // Handle the case where there is no response body, perhaps throw an exception
//            throw new ProductNotFoundException("Failed to update product with id: " + id);
//        }
//
//        // Convert and return the response body
//        return convertToGenericProductDto(responseEntity.getBody());
        return convertToGenericProductDto(fakeStoreClientAdapter.updateProductById(id,genericProductDto));
    }

}
