package com.stockyou.data.yahoo;

import java.util.Date;

public class YahooPortfolioQuery {

	private int count;
	private Date created;
	private String lang;
	private YahooQuotes results;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public YahooQuotes getResults() {
		return results;
	}

	public void setResults(YahooQuotes results) {
		this.results = results;
	}

}
