package com.genetics.nuka_api.repositiry;

import com.genetics.nuka_api.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    User findByUsername(String username);

    User getById(Long id);
}