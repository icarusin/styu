package com.stockyou.data;

import java.util.ArrayList;
import java.util.List;

import com.stockyou.data.yahoo.YahooPortfolio;
import com.stockyou.data.yahoo.YahooQuote;

public class QuotesConverter {
	
	public Portfolio convert(YahooPortfolio yPortfolio){
		
		Portfolio portfolio = new Portfolio();
		
		if(yPortfolio != null && yPortfolio.getQuery().getResults().getQuote() != null){
			List<Quote> quotes = new ArrayList<Quote>();
			for (YahooQuote yQuote : yPortfolio.getQuery().getResults().getQuote()) {
				Quote quote = new Quote();
				quote.setFiftyDayAverage(yQuote.getFiftydayMovingAverage());
				quote.setTwoHundredDayAverage(yQuote.getTwoHundreddayMovingAverage());
				quote.setStockCode(yQuote.getSymbol());
				quote.setStockPrice(yQuote.getLastTradePriceOnly());
				quote.setUnit("Rs");
				quote.setName(yQuote.getName());
				quote.setUpdatedDt(yQuote.getLastTradeDate());
				quote.setLogo(getImageFile(yQuote));
				quotes.add(quote);
			}
			portfolio.setQuote(quotes);
		}
		
		return portfolio;
	}

	private String getImageFile(YahooQuote yQuote) {
		return "images/"+yQuote.getSymbol().replaceAll("\\.(.)*", "") + ".png";
	}

}
