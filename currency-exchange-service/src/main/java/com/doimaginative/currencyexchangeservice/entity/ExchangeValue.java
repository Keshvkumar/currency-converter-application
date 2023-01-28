package com.doimaginative.currencyexchangeservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exchange_value")
public class ExchangeValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="currency_from",nullable = false)
    private String currency_from;
    @Column(name="currency_to",nullable = false)
    private String currency_to;
    @Column(name="conversion_multiple",nullable = false)
    private double conversion_multiple;
    @Column
    int port;
    
	public String getCurrency_from() {
		return currency_from;
	}

	public void setCurrency_from(String currency_from) {
		this.currency_from = currency_from;
	}

	public String getCurrency_to() {
		return currency_to;
	}

	public void setCurrency_to(String currency_to) {
		this.currency_to = currency_to;
	}

	public double getConversion_multiple() {
		return conversion_multiple;
	}

	public void setConversion_multiple(double conversion_multiple) {
		this.conversion_multiple = conversion_multiple;
	}

	public int getPort() {
		return port;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPort(int parseInt) {
		this.port = parseInt;
		
	}

	public Object getId() {
		return this.id;
	}
}
