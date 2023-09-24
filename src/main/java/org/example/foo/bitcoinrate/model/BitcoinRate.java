package org.example.foo.bitcoinrate.model;

import java.util.Objects;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class BitcoinRate {

	@Size(min = 3, max = 3)
	@NotNull
	private String currency;
	private String value;

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(currency, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BitcoinRate other = (BitcoinRate) obj;
		return Objects.equals(currency, other.currency) && Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return "BitcoinRate [currency=" + currency + ", value=" + value + "]";
	}

}
