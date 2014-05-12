package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class FundConvertor {
	private Connector c;
	
	public FundConvertor(){
		c = Connector.getInstance();
	}
	
	public List<Fund> getFunds() throws IOException{
		List<String> jsons = c.getFundData();
		Gson gson = new Gson();
		
		List<Fund> funds = new ArrayList<Fund>();
		for(String json : jsons){
			Datas fundDatas = gson.fromJson(json, Datas.class);
			for(int i=0;i<fundDatas.getDatas().length;i++){
				Fund fund;
				try{
					fund = converToFund(fundDatas.getDatas()[i]);				
				} catch(Exception e){
					continue;
				}
				funds.add(fund);
			}
		}
		
		return funds;
	}
	
	private Fund converToFund(String data){
		String[] attrs = getAttributes(data);
		attrs = trimPresentage(attrs);
		Fund fund = new Fund();
		fillData(fund, attrs);
		return fund;
	}
	
	private String[] getAttributes(String data){
		data = data.replaceAll(",{2,}",",---,");
		return data.split(",");
	}
	
	private String[] trimPresentage(String[] data){
		for(int i=0;i<data.length;i++){
			if(data[i].contains("%")){
				data[i] = data[i].substring(0, data[i].length()-1);
			}
		}
		
		return data;
	}
	
	private Fund fillData(Fund fund, String[] attrs){
		fund.setID(attrs[0]);
		fund.setName(attrs[1]);
		fund.setShortName(attrs[2]);
		fund.setNetAssetValue(setFloatAttr(attrs[4]));
		fund.setAccumulatedNet(setFloatAttr(attrs[5]));
		fund.setDailyGrowth(setFloatAttr(attrs[6]));
		fund.setWeeklyGrowth(setFloatAttr(attrs[7]));
		fund.setMonthlyGrowth(setFloatAttr(attrs[8]));
		fund.setThreeMonthGrowth(setFloatAttr(attrs[9]));
		fund.setSixMonthGrowth(setFloatAttr(attrs[10]));
		fund.setYearlyGrowth(setFloatAttr(attrs[11]));
		fund.setTwoYearGrowth(setFloatAttr(attrs[12]));
		fund.setThreeYearGrowth(setFloatAttr(attrs[14]));
		fund.setSinceFunded(setFloatAttr(attrs[15]));
		return fund;
	}
	
	public Float setFloatAttr(String data){
		if(data.contains("-"))
			return null;
		Float f = Float.valueOf(data);
		return f;
	}
	
}
