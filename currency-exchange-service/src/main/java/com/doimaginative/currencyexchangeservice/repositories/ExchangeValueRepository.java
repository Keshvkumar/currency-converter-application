package com.doimaginative.currencyexchangeservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.doimaginative.currencyexchangeservice.entity.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Integer> 
{
	@Query(value="SELECT * FROM exchange_value where currency_from=? and currency_to=?",nativeQuery=true)
	ExchangeValue findByFromAndTo(String from, String to);

}
