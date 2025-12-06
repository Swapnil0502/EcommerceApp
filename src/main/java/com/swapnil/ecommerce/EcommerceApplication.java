package com.swapnil.ecommerce;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EcommerceApplication {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.configure().load();  //loading the .env file
	//(entries() is a function in Dotenv class as Set<DotenvEntry>entries())
		dotenv.entries().forEach((DotenvEntry entry)->System.setProperty(entry.getKey(),entry.getValue())); // setting the properties of env files
		SpringApplication.run(EcommerceApplication.class, args);
	}

}

