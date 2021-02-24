package com.genetics.nuka_api.service;

import com.genetics.nuka_api.exception.ProductException.ProductIdException;
import com.genetics.nuka_api.model.Product;
import com.genetics.nuka_api.repositiry.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product createProduct(Product product){

        try{
            return productRepository.save(product);
        }catch (Exception e){
            throw  new ProductIdException("Product Id'" + product.getName() + "'product name already exist");

        }
    }
}
