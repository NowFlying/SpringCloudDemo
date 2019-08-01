package com.ggf.eurekahatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekahatestApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekahatestApplication.class, args);
	}

}
