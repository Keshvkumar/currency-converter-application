package com.doimaginative.currencyconversionservice;


public class CurrencyConversionBean {

	private Long id;  
	private String currency_from;  
	private String currency_to;  
	private Double ConversionMultiple;  
	private Double quantity;  
	private Double totalCalculatedAmount;  
	private int port;
	
	public CurrencyConversionBean() {
		super();
		
	}
	public CurrencyConversionBean(Long id, String currency_from, String currency_to, Double conversionMultiple, Double quantity,
			Double totalCalculatedAmount, int port) {
		this.id = id;
		this.currency_from = currency_from;
		this.currency_to = currency_to;
		this.ConversionMultiple = new Double(conversionMultiple);
		this.quantity = quantity;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.port = port;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFrom() {
		return currency_from;
	}
	public void setFrom(String currency_from) {
		this.currency_from = currency_from;
	}
	public String getTo() {
		return currency_to;
	}
	public void setTo(String currency_to) {
		this.currency_to = currency_to;
	}
	public Double getConversionMultiple() {
		return ConversionMultiple;
	}
	public void setConversionMultiple(Double conversionMultiple) {
		this.ConversionMultiple = new Double(conversionMultiple);
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public Double getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}
	public void setTotalCalculatedAmount(Double totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}  
	
	

}
