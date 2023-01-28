package com.doimaginative.currencyexchangeservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doimaginative.currencyexchangeservice.entity.ExchangeValue;
import com.doimaginative.currencyexchangeservice.services.ExchangeValueService;

@RestController
@RequestMapping("/forex-service/api/v1")
public class HomeController {
	
	@Autowired
	private Environment environment;
	  
	@Autowired
	private ExchangeValueService exchangeValueService;
	
	// retrieve home REST API
	// http://localhost:8080/forex-service/api/v1/home
	@RequestMapping("/home")  
    public String display()  
    {  
        return "home";  
    }  
	
	
	// retrieve ExchangeValue from to REST API
	// http://localhost:8080/forex-service/api/v1/currency-exchange/from/{from}/to/{to}
	@RequestMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to)
	{
		ExchangeValue exchangeValue = exchangeValueService.findByFromAndTo(from, to);
	    
	    exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
	    
	    return exchangeValue;
	}
	
	// build create ExchangeValue REST API
	// http://localhost:8080/forex-service/api/v1/exchange-value/
    @PostMapping("/exchange-value/")
    public ResponseEntity<ExchangeValue> createExchangeValue(@RequestBody ExchangeValue exchangeValue)
    {
    	ExchangeValue savedExchangeValue = exchangeValueService.createExchangeValue(exchangeValue);
    	savedExchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
    	
        return new ResponseEntity<>(savedExchangeValue, HttpStatus.CREATED);
    }

    // build get ExchangeValue by id REST API
    // http://localhost:8080/forex-service/api/v1/exchange-value/1
    @GetMapping("/exchange-value/{id}")
    public ResponseEntity<ExchangeValue> getExchangeValueById(@PathVariable("id") Integer id)
    {
    	ExchangeValue exchangeValue = exchangeValueService.getExchangeValueById(id);
        return new ResponseEntity<>(exchangeValue, HttpStatus.OK);
    }

    // Build Get All ExchangeValues REST API
    // http://localhost:8080/forex-service/api/v1/exchange-values
    @GetMapping("/exchange-values")
    public ResponseEntity<List<ExchangeValue>> getAllExchangeValues()
    {
        List<ExchangeValue> exchangeValues = exchangeValueService.getAllExchangeValues();
        
        for(ExchangeValue val:exchangeValues)
        {
        	val.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        }
        return new ResponseEntity<>(exchangeValues, HttpStatus.OK);
    }

    // Build Update ExchangeValue REST API
    // http://localhost:8080/forex-service/api/v1/exchange-value/1
    @PutMapping("/exchange-value/{id}")
    public ResponseEntity<ExchangeValue> updateExchangeValue(@PathVariable("id") Integer id,
                                           @RequestBody ExchangeValue exchangeValue)
    {
    	exchangeValue.setId(id);
        ExchangeValue updatedExchangeValue = exchangeValueService.updateExchangeValue(exchangeValue);
        return new ResponseEntity<>(updatedExchangeValue, HttpStatus.OK);
    }

    // Build Delete ExchangeValue REST API
    // http://localhost:8080/forex-service/api/v1/exchange-value/1
    @DeleteMapping("/exchange-value/{id}")
    public ResponseEntity<String> deleteExchangeValue(@PathVariable("id") Integer id)
    {
    	exchangeValueService.deleteExchangeValue(id);
        return new ResponseEntity<>("Value successfully deleted!", HttpStatus.OK);
    }

}

