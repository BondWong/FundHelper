package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.filechooser.FileSystemView;

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
	private final static String DATAURLREX = "http://fund.eastmoney.com/js/fundcode_search.js";
	
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
	
	@SuppressWarnings("unused")
	public boolean connect(String URL) {
		HttpGet get = new HttpGet(URL);
		String response = "";
		try {
			response = chp.execute(get, responseHandler);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		Pattern p = Pattern.compile(DATAURLREX);
		Matcher m = p.matcher(response);
		String dataURL = "";
		if(m.find()){
			dataURL = m.group();
			return true;
		}
		
		return false;
		
	}
	
	public List<String> getFundData() throws IOException{
		String data = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(Connector.class.getResourceAsStream("/download.txt")));
		try {
			Thread.sleep(1000*8);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		FileSystemView fsv = FileSystemView.getFileSystemView(); 
		File downloadData = new File(fsv.getHomeDirectory(),"fundData.txt");
		System.out.println(downloadData.getAbsolutePath());
		FileWriter writer = new FileWriter(downloadData);
		
		List<String> datas = new ArrayList<String>();
		while((data=br.readLine())!=null){
			writer.append(data);
			datas.add(data);
		}
		
		br.close();
		writer.close();
		return datas;
	}
	
}
