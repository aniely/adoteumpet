package com.adoteumpet.adocao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.adoteumpet.adocao")

public class AdocaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdocaoApplication.class, args);
	}

}
