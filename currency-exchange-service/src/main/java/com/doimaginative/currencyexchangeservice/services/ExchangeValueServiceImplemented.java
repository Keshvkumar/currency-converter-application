package com.doimaginative.currencyexchangeservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doimaginative.currencyexchangeservice.entity.ExchangeValue;
import com.doimaginative.currencyexchangeservice.repositories.ExchangeValueRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ExchangeValueServiceImplemented implements ExchangeValueService{
	
	@Autowired
	private ExchangeValueRepository repository;

	@Override
	public ExchangeValue createExchangeValue(ExchangeValue value) {
		return repository.save(value);
	}

	@Override
	public ExchangeValue getExchangeValueById(Integer id) {
		 Optional<ExchangeValue> optionalValue = repository.findById(id);
	     return optionalValue.get();
	}

	@Override
	public List<ExchangeValue> getAllExchangeValues() {
		return repository.findAll();
	}

	@Override
	public ExchangeValue updateExchangeValue(ExchangeValue value) {
		ExchangeValue existingValue = (ExchangeValue)(repository.findById((Integer) value.getId())).get();
		
		existingValue.setCurrency_from(value.getCurrency_from());
		existingValue.setCurrency_to(value.getCurrency_to());
		existingValue.setConversion_multiple(value.getConversion_multiple());
		
		ExchangeValue updatedValue = repository.save(existingValue);
        return updatedValue;
	}

	@Override
	public void deleteExchangeValue(int Id) {
		repository.deleteById(Id);		
	}

	@Override
	public ExchangeValue findByFromAndTo(String from, String to) 
	{
		ExchangeValue existingValue = (ExchangeValue) (repository.findByFromAndTo(from, to));
		
        return existingValue;
	}

	

}
