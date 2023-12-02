package com.productservice.productservice.thirdPartyClients.fakestoreclient;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exception.ProductNotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreClientAdapter {
    private RestTemplateBuilder restTemplateBuilder;
    private  String specificProductUrl ="https://fakestoreapi.com/products/{id}";
    private  String genericProductUrl ="https://fakestoreapi.com/products";

    FakeStoreClientAdapter(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }


    public FakeStoreProductDto getProductById(Long id) throws ProductNotFoundException {
        //Integrate the FakeStore API
        //RestTemplate
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class,id);

        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
        if (fakeStoreProductDto == null){
            //Throw an exception.
            throw new ProductNotFoundException("Product with id: "+id+" doesn't exist");
        }
        //convert FakeStoreProductDto to GenericProductDto before returning
        return fakeStoreProductDto;

    }

    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity =
                restTemplate.getForEntity(genericProductUrl,FakeStoreProductDto[].class);

        return List.of(responseEntity.getBody());
    }


    public FakeStoreProductDto deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity=
                restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);

        return responseEntity.getBody();
//        RequestCallback requestCallback = this.acceptHeaderRequestCallback(responseType);
//        ResponseExtractor<ResponseEntity<T>> responseExtractor = this.responseEntityExtractor(responseType);
//        return (ResponseEntity)nonNull((ResponseEntity)this.execute(url, HttpMethod.GET, requestCallback, responseExtractor, uriVariables));


    }

    public FakeStoreProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity=
                restTemplate.postForEntity(genericProductUrl,genericProductDto,FakeStoreProductDto.class);

        return responseEntity.getBody();
    }


    public FakeStoreProductDto updateProductById(Long id, GenericProductDto genericProductDto) throws ProductNotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();

        // Create an HttpEntity that contains the request body and headers
        HttpEntity<GenericProductDto> requestEntity = new HttpEntity<>(genericProductDto);

        // Use the exchange method of RestTemplate
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.exchange(
                specificProductUrl,
                HttpMethod.PUT,
                requestEntity,
                FakeStoreProductDto.class,
                id
        );

        // Check if response body is null
        if (responseEntity.getBody() == null) {
            // Handle the case where there is no response body, perhaps throw an exception
            throw new ProductNotFoundException("Failed to update product with id: " + id);
        }

        // Convert and return the response body
        return responseEntity.getBody();
    }

}
