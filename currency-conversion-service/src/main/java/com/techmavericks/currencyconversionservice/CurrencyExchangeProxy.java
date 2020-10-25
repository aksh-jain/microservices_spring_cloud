/**
 * 
 */
package com.techmavericks.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 
 * Proxy class for calling Currency-Exchange-service using Netflix Feign and
 * load balancing using Netflix Ribbon.
 * 
 * @author Akshay Jain
 *
 */

//@FeignClient(name = "currency-exchange-service", url = "http://localhost:8000")- configure URL when eureka is not implemented

@FeignClient(name = "currency-exchange-service")
//@RibbonClient(name = "currency-exchange-service") - As Feign is capable of doing load balancing using ribbon internally
public interface CurrencyExchangeProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable(name = "from") String from,
			@PathVariable(name = "to") String to);

}
