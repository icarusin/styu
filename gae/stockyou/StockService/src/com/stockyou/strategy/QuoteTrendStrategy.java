package com.stockyou.strategy;

import com.stockyou.data.Quote;
import com.stockyou.data.Trend;

public interface QuoteTrendStrategy {

	public Trend getTrend(Quote quote);
	
	public void updateQuote(Quote quote);
}
