package org.example.foo.bitcoinrate.blockchain.service;

import java.util.Map;

import org.example.foo.bitcoinrate.blockchain.model.Rate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RateRestTemplateClientTest {

	@Autowired
	RateRestTemplateClient rateRestTemplateClient;

	@Test
	void loadsRates() {
		Map<String, Rate> currenyToRate = rateRestTemplateClient.getRates();
		Assertions.assertTrue(currenyToRate.containsKey("USD"));
		Assertions.assertFalse(currenyToRate.containsKey("SOME KEY THAT DOES NOT EXIST FOR SURE"));
		Assertions.assertTrue(currenyToRate.containsKey("CNY"));
		Assertions.assertTrue(currenyToRate.get("USD").getBuy() > 0);
		Assertions.assertTrue(currenyToRate.get("USD").getSell() > 0);
		Assertions.assertEquals("TWD", currenyToRate.get("TWD").getSymbol());
	}

}
