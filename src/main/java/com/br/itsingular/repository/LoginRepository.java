package com.br.itsingular.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.br.itsingular.model.Login;

@Repository
public interface LoginRepository extends MongoRepository<Login, String>{
	
	Login findByUsernameAndPassword(String username, String password);

}
