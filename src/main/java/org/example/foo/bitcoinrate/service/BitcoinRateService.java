package org.example.foo.bitcoinrate.service;

import java.util.Collection;

import org.example.foo.bitcoinrate.blockchain.service.RateRestTemplateClient;
import org.example.foo.bitcoinrate.model.BitcoinRate;
import org.springframework.stereotype.Service;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Service
public class BitcoinRateService {

	private final RateRestTemplateClient client;

	public BitcoinRateService(RateRestTemplateClient client) {
		this.client = client;
	}

	public double getRate(@NotNull @Size(min = 3, max = 3) String currency) {
		return client.getRates().get(currency).getSell();
	}

	public Collection<BitcoinRate> getRates() {
		return client.getRates().entrySet().stream()
				.map(e -> new BitcoinRate(e.getKey(), e.getValue().getBuy(), e.getValue().getSell())).toList();
	}
}
