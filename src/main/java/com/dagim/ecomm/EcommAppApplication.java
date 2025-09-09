package com.dagim.ecomm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EcommAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommAppApplication.class, args);
	}

}
