package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class AppConfig {
	
	@Bean
    public MongoClient mongo() {
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
          .applyConnectionString(connectionString)
          .build();
        
        return MongoClients.create(mongoClientSettings);
    }
	
	@Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "db_local_test");
    }
	
//	@Bean
//	public MongoTemplate getMongoTemplate() {
////		String connectionString = "mongodb://" + mongo.getUsername() + ":" + new String(mongo.getPassword()) + "@" +mongo.getUri() + "/" + mongo.getDatabase();
//		String connectionString = "mongodb://localhost:27017";
//		SimpleMongoClientDatabaseFactory simpleMongClient = new SimpleMongoClientDatabaseFactory(connectionString);
//		return new MongoTemplate(simpleMongClient);
//	}
}
