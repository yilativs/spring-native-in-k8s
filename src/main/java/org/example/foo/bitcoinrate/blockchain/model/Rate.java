package org.example.foo.bitcoinrate.blockchain.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonKey;

@JsonIgnoreProperties(ignoreUnknown = true) 
public class Rate {

	public double buy;
	public double sell;
	public String symbol;
	
	public double getBuy() {
		return buy;
	}

	public void setBuy(double buy) {
		this.buy = buy;
	}

	public double getSell() {
		return sell;
	}

	public void setSell(double sell) {
		this.sell = sell;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public int hashCode() {
		return Objects.hash(buy, sell, symbol);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rate other = (Rate) obj;
		return Double.doubleToLongBits(buy) == Double.doubleToLongBits(other.buy)
				&& Double.doubleToLongBits(sell) == Double.doubleToLongBits(other.sell)
				&& Objects.equals(symbol, other.symbol);
	}
	

	
}
