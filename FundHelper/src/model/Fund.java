package model;

public class Fund {
	private String ID;
	private String shortName;
	private String name;
	private Float netAssetValue;
	private Float accumulatedNet;
	private Float dailyGrowth;
	private Float weeklyGrowth;
	private Float monthlyGrowth;
	private Float threeMonthGrowth;
	private Float sixMonthGrowth;
	private Float yearlyGrowth;
	private Float twoYearGrowth;
	private Float threeYearGrowth;
	private Float sinceFunded;
	
	public Fund(){
		
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public float getNetAssetValue() {
		return netAssetValue;
	}

	public void setNetAssetValue(Float netAssetValue) {
		this.netAssetValue = netAssetValue;
	}

	public Float getAccumulatedNet() {
		return accumulatedNet;
	}

	public void setAccumulatedNet(Float accumulatedNet) {
		this.accumulatedNet = accumulatedNet;
	}

	public Float getDailyGrowth() {
		return dailyGrowth;
	}

	public void setDailyGrowth(Float dailyGrowth) {
		this.dailyGrowth = dailyGrowth;
	}

	public Float getWeeklyGrowth() {
		return weeklyGrowth;
	}

	public void setWeeklyGrowth(Float weeklyGrowth) {
		this.weeklyGrowth = weeklyGrowth;
	}

	public Float getMonthlyGrowth() {
		return monthlyGrowth;
	}

	public void setMonthlyGrowth(Float monthlyGrowth) {
		this.monthlyGrowth = monthlyGrowth;
	}

	public Float getThreeMonthGrowth() {
		return threeMonthGrowth;
	}

	public void setThreeMonthGrowth(Float threeMonthGrowth) {
		this.threeMonthGrowth = threeMonthGrowth;
	}

	public Float getSixMonthGrowth() {
		return sixMonthGrowth;
	}

	public void setSixMonthGrowth(Float sixMonthGrowth) {
		this.sixMonthGrowth = sixMonthGrowth;
	}

	public Float getYearlyGrowth() {
		return yearlyGrowth;
	}

	public void setYearlyGrowth(Float yearlyGrowth) {
		this.yearlyGrowth = yearlyGrowth;
	}

	public Float getTwoYearGrowth() {
		return twoYearGrowth;
	}

	public void setTwoYearGrowth(Float twoYearGrowth) {
		this.twoYearGrowth = twoYearGrowth;
	}

	public Float getThreeYearGrowth() {
		return threeYearGrowth;
	}

	public void setThreeYearGrowth(Float threeYearGrowth) {
		this.threeYearGrowth = threeYearGrowth;
	}

	public Float getSinceFunded() {
		return sinceFunded;
	}

	public void setSinceFunded(Float sinceFunded) {
		this.sinceFunded = sinceFunded;
	}
	
}
