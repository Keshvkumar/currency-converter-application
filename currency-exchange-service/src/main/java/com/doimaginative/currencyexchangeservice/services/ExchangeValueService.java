package com.doimaginative.currencyexchangeservice.services;

import java.util.List;
import com.doimaginative.currencyexchangeservice.entity.ExchangeValue;

public interface ExchangeValueService{

	ExchangeValue createExchangeValue(ExchangeValue value);

	ExchangeValue getExchangeValueById(Integer id);

    List<ExchangeValue> getAllExchangeValues();

    ExchangeValue updateExchangeValue(ExchangeValue value);

    void deleteExchangeValue(int Id);
    
    ExchangeValue findByFromAndTo(String from, String to);

}
