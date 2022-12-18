package com.httora.toy_servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class ToyServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToyServletApplication.class, args);
	}

}
