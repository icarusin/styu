package com.stockyou.data.yahoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Logger;

import com.google.appengine.api.urlfetch.HTTPMethod;
import com.google.appengine.api.urlfetch.HTTPRequest;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.stockyou.data.QuotesConverter;
import com.stockyou.data.QuotesFetcher;

public class YahooQuotesFetcher implements QuotesFetcher {
	
private static final Logger log = Logger.getLogger(YahooQuotesFetcher.class.getName());

	@Override
	public String getResponse(String[] quotes) {
		StringBuilder fullJsonResponse = new StringBuilder();
		   try {
	            URL url = prepareOpenTableQuery(quotes);
	            url.openConnection().setReadTimeout(0);
	            url.openConnection().setConnectTimeout(0);
	            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
	            String line;
	            

	            while ((line = reader.readLine()) != null) {
	            	fullJsonResponse.append(line);
	            }
	            reader.close();

	        } catch (MalformedURLException e) {
	        	log.info("Got error : "+e);
	        } catch (IOException e) {
	        	log.info("Got error : "+e);
	        }
		   
		   QuotesConverter converter = new QuotesConverter();
		   
		   GsonBuilder gsonForYahoo = new GsonBuilder();
		   YahooPortfolio portfolio = gsonForYahoo.create().fromJson(fullJsonResponse.toString(), YahooPortfolio.class);
		   
		   GsonBuilder gsonForPortfolio = new GsonBuilder();
		   gsonForPortfolio.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
		   return gsonForPortfolio.create().toJson(converter.convert(portfolio));
	}

	private URL prepareOpenTableQuery(String[] quotes)
			throws MalformedURLException, UnsupportedEncodingException {

		String baseURL = "http://query.yahooapis.com/v1/public/yql?";
		String query = "";

		for (String quote : quotes) {
			query = query + "\"" + quote + "\"" + ",";
		}

		query = query.substring(0, query.length() - 1);

		query =  URLEncoder.encode("select * from yahoo.finance.quotes where symbol in ("+query + ")", "UTF-8");

		String fullURL = baseURL + "q=" + query + "&"
				+ "format=json&env=http%3A%2F%2Fdatatables.org%2Falltables.env";

		URL url = new URL(fullURL);

		return url;

	}
}
