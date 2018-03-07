package com.naldojesse.productscategories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;



@Controller

@SpringBootApplication
public class ProductscategoriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductscategoriesApplication.class, args);
	}

	@RequestMapping("/")
	public String index()  {
		return "index.jsp";
	}
}
