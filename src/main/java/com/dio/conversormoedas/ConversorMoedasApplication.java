package com.dio.conversormoedas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConversorMoedasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConversorMoedasApplication.class, args);
	}

}
