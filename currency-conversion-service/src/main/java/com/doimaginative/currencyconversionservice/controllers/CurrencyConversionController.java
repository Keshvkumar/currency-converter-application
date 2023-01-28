package com.doimaginative.currencyconversionservice.controllers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.doimaginative.currencyconversionservice.CurrencyConversionBean;
import com.doimaginative.currencyconversionservice.ExchangeValue;

@RestController  
public class CurrencyConversionController {
	
	
	 // "http://localhost:8080/forex-service/api/v1/currency-exchange/from/{from}/to/{to}"
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}") //where {from} and {to} represents the column   
	//returns a bean back  
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable Double quantity)  
	{  
		//setting variables to currency exchange service  
		Map<String, String>uriVariables=new HashMap<>();  
		uriVariables.put("from", from);  
		uriVariables.put("to", to);  
		
		//calling the currency-exchange-service  
		ResponseEntity<ExchangeValue>responseEntity=new RestTemplate().getForEntity("http://localhost:8080/forex-service/api/v1/currency-exchange/from/{from}/to/{to}", ExchangeValue.class, uriVariables);  
		ExchangeValue response=responseEntity.getBody();  
		
		String str_id = ""+response.getId();
		Long _id = new Long(str_id);
		
		//creating a new response bean and getting the response back and taking it into Bean  
		return new CurrencyConversionBean(_id, from,to,response.getConversion_multiple(), quantity,(quantity*(response.getConversion_multiple())),response.getPort());  
	}  
	 
	/*@GetMapping("/currency-converter/from/{from}/to/{to}/ quantity/{quantity}") 
	// http://localhost:8081/currency-converter/from/USD/to/INR/quantity/100
	//where {from} and {to} represents the column   
	//return a bean back  
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity)  
	{  
		return new CurrencyConversionBean(1L, from,to,BigDecimal.ONE, quantity,quantity,0 );  
	} */ 

}
