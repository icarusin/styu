package com.stockyou.data;

public class Quote {
	

	private String FiftyDayAverage;
	private String TwoHundredDayAverage;
	private String stockCode;
	private String stockPrice;
	private String unit;
	private String updatedDt;
	private String logo;
	private String name;
	
	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	public String getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(String stockPrice) {
		this.stockPrice = stockPrice;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getUpdatedDt() {
		return updatedDt;
	}
	public void setUpdatedDt(String updatedDt) {
		this.updatedDt = updatedDt;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getFiftyDayAverage() {
		return FiftyDayAverage;
	}
	public void setFiftyDayAverage(String fiftyDayAverage) {
		FiftyDayAverage = fiftyDayAverage;
	}
	public String getTwoHundredDayAverage() {
		return TwoHundredDayAverage;
	}
	public void setTwoHundredDayAverage(String twoHundredDayAverage) {
		TwoHundredDayAverage = twoHundredDayAverage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
