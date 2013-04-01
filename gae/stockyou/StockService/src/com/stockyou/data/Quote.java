package com.stockyou.data;

public class Quote {
	

	private String fiftyDayAverage;
	private String twoHundredDayAverage;
	private String stockCode;
	private String stockPrice;
	private String unit;
	private String updatedDt;
	private String logo;
	private String name;
	private String dayValueChange;
	private String dayPercentageChange;
	
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
		return fiftyDayAverage;
	}
	public void setFiftyDayAverage(String fiftyDayAverage) {
		this.fiftyDayAverage = fiftyDayAverage;
	}
	public String getTwoHundredDayAverage() {
		return twoHundredDayAverage;
	}
	public void setTwoHundredDayAverage(String twoHundredDayAverage) {
		this.twoHundredDayAverage = twoHundredDayAverage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDayValueChange() {
		return dayValueChange;
	}
	public void setDayValueChange(String dayValueChange) {
		this.dayValueChange = dayValueChange;
	}
	public String getDayPercentageChange() {
		return dayPercentageChange;
	}
	public void setDayPercentageChange(String dayPercentageChange) {
		this.dayPercentageChange = dayPercentageChange;
	}
}
