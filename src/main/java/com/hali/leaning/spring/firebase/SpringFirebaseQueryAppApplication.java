package com.hali.leaning.spring.firebase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gcp.data.firestore.repository.config.EnableReactiveFirestoreRepositories;

@SpringBootApplication
@EnableReactiveFirestoreRepositories
public class SpringFirebaseQueryAppApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(SpringFirebaseQueryAppApplication.class, args);
	}
}
