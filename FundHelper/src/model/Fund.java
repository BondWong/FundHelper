package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fund {
	private String fundname;
	private int firstNum;
	private int monthNum;

	private Map<String, Double> timemap = new HashMap<String, Double>();
	private String timeKey[];
	private Map<String,Double> typemap = new HashMap<String, Double>();
	
	public Fund(String fund_name) {
		fundname = fund_name;
	}
	
	public String getFundName() {
		return fundname;
	}

	public int getFirstNum() {
		return firstNum;
	}

	public int getMonthNum() {
		return monthNum;
	}

	public Map<String, Double> getTimeMap() {
		return timemap;
	}
	
	public void setTimeMap(List<List<String>> fundRecords) {
		for(List<String> record : fundRecords) {
			String time = record.get(0) + "-" + record.get(1);
			if(!this.timemap.containsKey(time)){
				this.timemap.put(time, 0.0);
			}
			Double netValue = this.timemap.get(time) + Double.parseDouble(record.get(3));
			this.timemap.put(time, netValue);
			this.timeKey = new String[timemap.size()];
			this.timemap.keySet().toArray(this.timeKey);
		}
	}
	
	public String[] getTimeKey() {
		return timeKey;
	}
	
	public Map<String, Double> getTypeMap() {
		return typemap;
	}
}
