package org.example.foo.bitcoinrate.service;

import java.util.Collection;

import org.example.foo.bitcoinrate.model.BitcoinRate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Service
public class BitcoinRateService {

	public BitcoinRateService()	 {
	}

	public String getRate(@NotNull @Size(min = 3, max = 3) String currency) {
		if ("USD".equals(currency.toUpperCase())) {
			return "26000";
		}
		throw new UnsupportedOperationException("not implemented yet");
	}

	public Collection<BitcoinRate> getRates() {
		throw new UnsupportedOperationException("not implemented yet");
	}
}
