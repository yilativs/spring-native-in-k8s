package org.example.foo.bitcoinrate.blockchain.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RateMappingTest {

	@Test
	void mapsRate() throws StreamReadException, DatabindException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		TypeReference<HashMap<String, Rate>> typeRef = new TypeReference<HashMap<String, Rate>>() {
		};
		HashMap<String, Rate> currencyToRate = objectMapper
				.readValue(objectMapper.getClass().getResourceAsStream("/bitcoin-rate-sample.json"), typeRef);

		assertEquals(2, currencyToRate.size());
		assertNotNull(currencyToRate.get("USD"));
		assertNotNull(currencyToRate.get("CNY"));
		assertEquals(57527.96, currencyToRate.get("USD").getBuy());
		assertEquals(372412.98, currencyToRate.get("CNY").getSell());
		assertEquals("¥", currencyToRate.get("CNY").getSymbol());
	}

}
