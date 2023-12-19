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
class Solution:
        def imageSmoother(self, img: List[List[int]]) -> List[List[int]]:
        self.r = len(img)
        self.c = len(img[0])
        return  [[self.smooth(i,j,img) for j in range(self.c)] for i in range(self.r)]
        def smooth(self,r,c,img):
        dr = [0, 0, 0,-1, 1,-1, 1,-1, 1]
        dc = [0, 1,-1, 0, 0,-1, 1, 1,-1]
        sums = count = 0
        for i in range(9):
        rr = r + dr[i]
        cc = c + dc[i]
        if rr<0 or cc<0 or rr>=self.r or cc>=self.c:
        continue
        sums += img[rr][cc]
        count +=1
        return sums//count

