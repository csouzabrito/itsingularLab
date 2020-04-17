package com.br.itsingular.custom.repository;

import org.springframework.beans.factory.annotation.Value;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;

import java.util.Objects;

import com.mongodb.client.model.CreateCollectionOptions;
import com.mongodb.client.model.ValidationOptions;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MongoConnection {
	
	@Value("${spring.data.mongodb.host}")
	private String host;
	
	@Value("${spring.data.mongodb.port}")
	private String port;
	
	@Value("${spring.data.mongodb.database}")
	private String database;
	
	@Value("${collection}")
	private String collection;
	
	private static MongoConnection INSTANCE;
	
	
	private MongoConnection() {
		
	}
	
	public static MongoConnection getInstance() {
        if(INSTANCE == null) {
           INSTANCE = new MongoConnection();
        }
        return INSTANCE;
    }
}
