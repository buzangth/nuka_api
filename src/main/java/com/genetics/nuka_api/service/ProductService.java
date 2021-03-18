package com.genetics.nuka_api.service;

import com.genetics.nuka_api.exception.ProductException.ProductIdException;
import com.genetics.nuka_api.model.Product;
import com.genetics.nuka_api.model.User;
import com.genetics.nuka_api.repositiry.ProductRepository;
import com.genetics.nuka_api.repositiry.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    public Product createProduct(Product product,String username){

        try{

            User user = userRepository.findByUsername(username);

            product.setUser(user);
            product.setProductCreater(user.getUsername());
            return productRepository.save(product);
        }catch (Exception e){
            throw  new ProductIdException("Product Id'" + product.getName() + "'product name already exist");

        }
    }
}
