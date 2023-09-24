package org.example.foo.bitcoinrate.blockchain;

public class RateClientException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RateClientException(String message) {
		super(message);
	}

	public RateClientException(String message, Throwable cause) {
		super(message, cause);
	}

}
