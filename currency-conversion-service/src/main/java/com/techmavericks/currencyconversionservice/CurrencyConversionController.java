/**
 * 
 */
package com.techmavericks.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Rest Controller Class for converting currency
 * 
 * @author Akshay Jain
 *
 */
@RestController
public class CurrencyConversionController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	CurrencyExchangeProxy currencyExchangeProxy;

	/**
	 * 
	 * Method to call exchange service using RestTemplate
	 * 
	 * @param from     Origin Country Currency
	 * @param to       Destination Country Currency
	 * @param quantity Amount to be converted
	 * @return
	 */
	@GetMapping("/currency-converter-rest-template/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		String url = "//currency-exchange-service/currency-exchange/from/{from}/to/{to}";
		Map<String, String> uriVariables = new HashMap<String, String>(4);
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		CurrencyConversionBean reponse = restTemplate.getForObject(url, CurrencyConversionBean.class, uriVariables);

		return new CurrencyConversionBean(reponse.getId(), from, to, reponse.getConversionMultiple(), quantity,
				reponse.getConversionMultiple().multiply(quantity), reponse.getPort());

	}

	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		CurrencyConversionBean reponse = currencyExchangeProxy.retrieveExchangeValue(from, to);

		return new CurrencyConversionBean(reponse.getId(), from, to, reponse.getConversionMultiple(), quantity,
				reponse.getConversionMultiple().multiply(quantity), reponse.getPort());

	}

}
