package org.example.foo.bitcoinrate.controller;

import java.util.Collection;

import org.example.foo.bitcoinrate.model.BitcoinRate;
import org.example.foo.bitcoinrate.service.BitcoinRateService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@RestController()
@RequestMapping("bitcoin-rate")
public class BitcoinRateController {

	private final BitcoinRateService bitcoinRateService;

	public BitcoinRateController(BitcoinRateService bitcoinRateService) {
		this.bitcoinRateService = bitcoinRateService;
	}

	@GetMapping("/rates/{currency}")
	public double getRate(@Validated @NotNull @Size(min = 3, max = 3) @PathVariable String currency) {
		return bitcoinRateService.getRate(currency);
	}

	@GetMapping("/rates")
	public Collection<BitcoinRate> getRate() {
		return bitcoinRateService.getRates();
	}

}
