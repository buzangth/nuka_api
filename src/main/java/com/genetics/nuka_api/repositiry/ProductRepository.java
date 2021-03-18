package com.genetics.nuka_api.repositiry;

import com.genetics.nuka_api.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
   Product findByName(String name);

}
