package com.stockyou.service.portfolio.rest.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.stockyou.data.QuotesFetcher;
import com.stockyou.data.yahoo.YahooQuotesFetcher;


@Path("/portfolio/")
public class PortfolioResource {
	
	@GET
	@Produces("text/plain")
	@Path("/nse")
	public String getPortfolio(){
		 
		 
		   String[] quotes = new String[]{
				   	"ACC.NS",
				   	"AMBUJACEM.NS",
				   	"ASIANPAIN.NS",
				   	"AXISBANK.NS",
				   	"BAJAJHIND.NS",
				   	"BANKBAROD.NS",
				   	"BHARTIART.NS",
				   	"BHEL.NS",
				   	"BPCL.NS",
				   	"CAIRN.NS",
				   	"CIPLA.NS",
				   	"COALINDIA.NS",
				   	"DLF.NS",
				   	"DRREDDY.NS",
				   	"GAIL.NS",
				   	"GRASIM.NS",
				   	"HCLTECH.NS",
				   	"HDFC.NS",
				   	"HDFCBANK.NS",
				   	"HEROHONDA.NS",
				   	"HINDALCO.NS",
				   	"HINDUNILV.NS",
				   	"ICICIBANK.NS",
				   	"IDFC.NS",
				   	"INFY.NS",
				   	"ITC.NS",
				   	"JINDALSTE.NS",
				   	"JPASSOCIA.NS",
				   	"KOTAKBANK.NS",
				   	"LT.NS",
				   	"LUPIN.NS",
				   	"M&M.NS",
				   	"MARUTI.NS",
				   	"NTPC.NS",
				   	"ONGC.NS",
				   	"PNB.NS",
				   	"POWERGRID.NS",
				   	"RANBAXY.NS",
				   	"RELIANCE.NS",
				   	"RELINFRA.NS",
				   	"SBI.NS",
				   	"SESAGOA.NS",
				   	"SIEMENS.NS",
				   	"SUNPHARMA.NS",
				   	"TATAMOTOR.NS",
				   	"TATAPOWER.NS",
				   	"TATASTEEL.NS",
				   	"TCS.NS",
				   	"ULTRACEMC.NS",
				   	"WIPRO.NS"

		   };
		   
		   QuotesFetcher quotesFetcher = new YahooQuotesFetcher();
		   
		   return quotesFetcher.getResponse(quotes);
		   
		 
	}

}
