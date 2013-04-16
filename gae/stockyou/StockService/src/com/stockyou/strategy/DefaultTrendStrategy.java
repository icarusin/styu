package com.stockyou.strategy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.stockyou.data.Quote;
import com.stockyou.data.Trend;

public class DefaultTrendStrategy implements QuoteTrendStrategy {
    static Map<Quote,Queue<Double>> nseTrend; // 
    final int queueSize;
    public DefaultTrendStrategy(int maxSize){
    	nseTrend =  new HashMap<Quote,Queue<Double>>();
    	queueSize = maxSize;
    }
	@Override
	public Trend getTrend(Quote quote) {
		Queue<Double> prices = nseTrend.get(quote);
		if(prices==null)
			throw new IllegalArgumentException("Stock Code not found");
		
		double sum = 0.0d;
		for(Double d : prices){
			sum +=d.doubleValue();
		}
		double avg = sum / prices.size();
		//prices.
		double calc = (prices.peek().doubleValue()-avg)/avg;
		if(calc< 0.0){
		  return Trend.POOR;
		}
		else if(calc>0.0)
			return Trend.GOOD;
		else
			return Trend.OK;
	
	
	}
	@Override
	public synchronized void updateQuote(Quote quote) {
		Queue<Double> quotePrices = nseTrend.get(quote);
		if(quotePrices == null){
			quotePrices = new LinkedList<Double>();
		}
		
		if(quotePrices.size()>=queueSize){
			quotePrices.remove();
			
		}
		quotePrices.add(Double.valueOf(quote.getStockPrice()));
		
		nseTrend.put(quote, quotePrices);
		
	}

}
