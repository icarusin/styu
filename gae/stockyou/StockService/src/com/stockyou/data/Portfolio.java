package com.stockyou.data;

import java.util.List;

public class Portfolio {
	private List<Quote> quote;

	public List<Quote> getQuote() {
		return quote;
	}

	public void setQuote(List<Quote> quotes) {
		this.quote = quotes;
	}
}
