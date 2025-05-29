package com.josue.KartingConfigServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class KartingConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KartingConfigServerApplication.class, args);
	}

}
