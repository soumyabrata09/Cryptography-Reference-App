package com.sam09.cryptography.referenceapp;

import com.sam09.lib.cryptographystarter.service.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReferenceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReferenceAppApplication.class, args);
	}
}
