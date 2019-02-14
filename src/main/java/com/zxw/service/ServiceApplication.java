package com.zxw.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceApplication {

	public static void main(String[] args) {
        System.out.println("master");
        SpringApplication.run(ServiceApplication.class, args);
	}

}

