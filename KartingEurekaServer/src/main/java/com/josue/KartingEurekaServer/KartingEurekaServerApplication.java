package com.josue.KartingEurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class KartingEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KartingEurekaServerApplication.class, args);
	}

}
