package com.productservice.productservice.controllers;

import com.productservice.productservice.exception.ProductNotFoundException;
import com.productservice.productservice.services.ProductService;
import com.productservice.productservice.thirdPartyClients.fakestoreclient.FakeStoreClientAdapter;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTests {

    @Inject
    private ProductController productController;
    @Inject
    private ProductController FakeStoreClientAdapter;

    @MockBean
    private ProductService productService;
//    ProductControllerTests( FakeStoreClientAdapter fakeStoreClientAdapter) {
//        this.fakeStoreClientAdapter = fakeStoreClientAdapter;
//    }
//    ProductControllerTests(ProductController productController){
//        this.productController = productController;
//    }
    @Test
    @DisplayName("Testing 1+1 is 2")
    void testOnePlusIsTwoOrNot(){
//        assertEquals(2,1+1,"1+1 should be 2");
//        assertTrue(2==2);
//        assertNotNull();
        //Checks the expected value(2) vs o/p of the expression
        //If assert is True,test cases succceds,else Fail

    }
    @Test
    void testGetProductByIdNegativeTC(){
//        productController.getProductById(1000L);
          assertThrows(ProductNotFoundException.class,()->productController.getProductById(10000L));
//        assertNull(FakeStoreClientAdapter.getProductById(1000L));
    }

    @Test
    void testGetProductByIdMocking() throws ProductNotFoundException {
        when(productService.getProductById(100L)).thenReturn(null);

        assertNull(productController.getProductById(100L));
    }

}







