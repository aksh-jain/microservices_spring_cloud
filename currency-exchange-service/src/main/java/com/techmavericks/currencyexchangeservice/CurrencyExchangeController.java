/**
 * 
 */
package com.techmavericks.currencyexchangeservice;

import java.math.BigDecimal;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Akshay Jain
 *
 */

@RestController
public class CurrencyExchangeController {

	@Autowired
	Environment env;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

		return new ExchangeValue(new Random().nextInt(1000), from, to, BigDecimal.valueOf(56.73),
				env.getProperty("local.server.port"));
	}

}
