package com.sam09.cryptography.referenceapp;

import com.sam09.lib.cryptographystarter.service.CryptoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
public class ReferenceAppApplication {

	private static  final Logger log = LoggerFactory.getLogger(ReferenceAppApplication.class);
	public static void main(String[] args) {
		log.info("::Application is initiating::".toUpperCase());
		SpringApplication.run(ReferenceAppApplication.class, args);
	}
}
