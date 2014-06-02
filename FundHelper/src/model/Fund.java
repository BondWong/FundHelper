package model;

import java.util.HashMap;
import java.util.Map;

public class Fund {
	private String fundname;
	private int firstNum;
	private int monthNum;

	private int NUM = 10000;
	private Map<String, Integer> timemap = new HashMap<String, Integer>();
	private String timeKey[] = new String[NUM];
	private Map<String,Integer> typemap = new HashMap<String, Integer>();
	
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

	public Map<String, Integer> getTimeMap() {
		return timemap;
	}

	public String[] getTimeKey() {
		return timeKey;
	}

	public Map<String, Integer> getTypeMap() {
		return typemap;
	}
}
