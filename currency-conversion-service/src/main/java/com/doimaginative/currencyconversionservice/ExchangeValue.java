package com.doimaginative.currencyconversionservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeValue {

    public ExchangeValue() {
		super();
		
	}

	public ExchangeValue(int id, String currency_from, String currency_to, double conversion_multiple, int port) {
		super();
		this.id = id;
		this.currency_from = currency_from;
		this.currency_to = currency_to;
		this.conversion_multiple = conversion_multiple;
		this.port = port;
	}

	private int id;
    private String currency_from;
    private String currency_to;
    private double conversion_multiple;
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
