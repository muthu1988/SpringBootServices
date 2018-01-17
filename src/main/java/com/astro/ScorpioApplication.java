package com.astro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ScorpioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScorpioApplication.class, args);
	}
}
