package org.example.foo.bitcoinrate.controller;

import org.example.foo.bitcoinrate.service.BitcoinRateService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping("/rate")
	public String getRate(@Validated @NotNull @Size(min = 3, max = 3) @RequestParam String currency) {
		return bitcoinRateService.getRate(currency);
	}

}
