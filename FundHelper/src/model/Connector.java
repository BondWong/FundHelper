package model;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Connector {
	private static CloseableHttpClient chp;
	private static ResponseHandler<String> responseHandler;
	private static Connector instance = null;
	private final static String FUNDINFOURL = "http://fund.eastmoney.com/js/fundcode_search.js";
	
	private Connector(){
		chp = HttpClients.createDefault();
		responseHandler = new ResponseHandler<String>(){
			public String handleResponse(final HttpResponse response) throws IOException{		
				int status = response.getStatusLine().getStatusCode();
				if(status >=200 && status < 300){
					HttpEntity entity = response.getEntity();
					return entity != null ? EntityUtils.toString(entity):null;
				} else{
					throw new ClientProtocolException("Unexcepted response status: " + status);
				}
			}
		};
	}
	
	public static Connector getInstance(){
		if(instance == null){
			instance = new Connector();
		}
		return instance;
	}
	
	public String getFundInfo() throws ClientProtocolException, IOException {
		String fundDatas = "";
		HttpGet get = new HttpGet(FUNDINFOURL);
		try {
			fundDatas = chp.execute(get, responseHandler);
		} catch (IOException e) {
			throw e;
		}
		
		try {
			fundDatas = new String(fundDatas.getBytes("ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fundDatas.split("=")[1].replaceFirst(";", "").trim();
		
	}
	
	public List<List<String>> getRecords(String code) throws ClientProtocolException, IOException {
		String getRecordsURL = "http://fund.eastmoney.com/f10/F10DataApi.aspx?type=lsjz&code=" + code + "&page=1&per=10000&sdate=&edate=";
		String response = "";
		
		HttpGet get = new HttpGet(getRecordsURL);
		response = chp.execute(get, responseHandler);
		
		Pattern pattern = Pattern.compile("<td>(\\d{4})-(\\d{2})-(\\d{2})</td><td class='tor bold'>(\\d{1,}.\\d{1,})</td><td class='tor bold'>(\\d{1,}.\\d{1,})</td>");
		Matcher m = pattern.matcher(response);
		
		List<List<String>> temp = new ArrayList<List<String>>();
		while(m.find()){
			List<String> data = new ArrayList<String>();
			data.add(m.group(1));
			data.add(m.group(2));
			data.add(m.group(3));
			data.add(m.group(4));
			data.add(m.group(5));
			temp.add(data);
		}
		
		return temp;
	}
	
	public void close() throws IOException{
		chp.close();
	}
	
}
