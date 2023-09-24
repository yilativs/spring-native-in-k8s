package org.example.foo.bitcoinrate.blockchain.service;

import java.util.HashMap;
import java.util.Map;

import org.example.foo.bitcoinrate.blockchain.RateClientException;
import org.example.foo.bitcoinrate.blockchain.model.Rate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RateRestTemplateClient {

	private final RestTemplate restTemplate = new RestTemplate();
	private String url;

	public RateRestTemplateClient(@Value("${bitcoin.rate.url}") String url) {
		this.url = url;
	}

	public Map<String, Rate> getRates() {
		ParameterizedTypeReference<HashMap<String, Rate>> typeRef = new ParameterizedTypeReference<HashMap<String, Rate>>() {
		};
		ResponseEntity<HashMap<String, Rate>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null,
				typeRef);
		if (responseEntity.getStatusCode().is2xxSuccessful()) {
			return responseEntity.getBody();
		} else {
			throw new RateClientException("Loading rates failed, because of " + responseEntity.getStatusCode());
		}
	}

}
