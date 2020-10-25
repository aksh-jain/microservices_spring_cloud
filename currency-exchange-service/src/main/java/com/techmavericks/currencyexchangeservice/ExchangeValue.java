/**
 * 
 */
package com.techmavericks.currencyexchangeservice;

import java.math.BigDecimal;

/**
 * @author Akshay Jain
 *
 */
public class ExchangeValue {

//	@Id
    private int id;

//	@Column(name="currency_from")
    private String from;

//	@Column(name="currency_to")
    private String to;

    private BigDecimal conversionMultiple;

    private String port;

    public ExchangeValue(int id, String from, String to, BigDecimal conversionMultiple, String port) {
	super();
	this.id = id;
	this.from = from;
	this.to = to;
	this.conversionMultiple = conversionMultiple;
	this.port = port;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getFrom() {
	return from;
    }

    public void setFrom(String from) {
	this.from = from;
    }

    public String getTo() {
	return to;
    }

    public void setTo(String to) {
	this.to = to;
    }

    public BigDecimal getConversionMultiple() {
	return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
	this.conversionMultiple = conversionMultiple;
    }

    public String getPort() {
	return port;
    }

    public void setPort(String port) {
	this.port = port;
    }

}
