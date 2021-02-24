package com.genetics.nuka_api.repositiry;

import com.genetics.nuka_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);

    User getById(Long id);

}