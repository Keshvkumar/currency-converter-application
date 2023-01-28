package com.doimaginative.currencyexchangeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.doimaginative.currencyexchangeservice.*",
										 "com.doimaginative.currencyexchangeservice.repositories",
										 "com.doimaginative.currencyexchangeservice.services"})
public class CurrencyExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}

}
