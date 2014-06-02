package unitTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.FundInfoManager;

import org.junit.Assert;
import org.junit.Test;

public class ListToMapTest {
	@Test
	public void testListToMap() throws IOException{
		FundInfoManager fim = FundInfoManager.getInstance();
		fim.init();
		List<List<String>> fundRecords = fim.getRecords("000001"); 
		Map<String, Double> timemap = new HashMap<String, Double>();
		for(List<String> record : fundRecords) {
			String time = record.get(0) + "-" + record.get(1);
			if(!timemap.containsKey(time))
				timemap.put(time, 0.0);
			Double netValue =  Double.parseDouble(record.get(3)) + timemap.get(time);
			timemap.put(time, netValue);
		}
		String[] timekey = new String[timemap.size()];
		timemap.keySet().toArray(timekey);
		
		System.out.println(timekey.length);
		Assert.assertNotEquals(0, timekey.length);
		System.out.println(timemap);
		Assert.assertNotEquals(0, timemap.size());
	}
}
