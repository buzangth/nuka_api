package com.genetics.nuka_api.repositiry;

import com.genetics.nuka_api.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {
     Product findByproductName(String productName);

}
