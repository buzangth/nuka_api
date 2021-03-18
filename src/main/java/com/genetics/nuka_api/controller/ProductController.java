package com.genetics.nuka_api.controller;

import com.genetics.nuka_api.model.Product;

import com.genetics.nuka_api.service.MapValidationServiceError;
import com.genetics.nuka_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    MapValidationServiceError mapValidationServiceError;

    @PostMapping
    public ResponseEntity<?> createNewProduct(@Valid @RequestBody Product product, BindingResult result, Principal principal){

        ResponseEntity<?> errorMap = mapValidationServiceError.MapValidationService(result);
        if(errorMap!= null) return errorMap;
        Product product1 = productService.createProduct(product,principal.getName());
        return new ResponseEntity<Product>(product1, HttpStatus.CREATED);
    }
}
