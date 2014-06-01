package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.filechooser.FileSystemView;

import model.sortMethod.SortMethod;

import org.apache.http.client.ClientProtocolException;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class FundInfoManager {
	private static FundInfoManager fim;
	private static Connector c;
	private static String root = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath() + "/funddatas";
	private final static int RECORDCACHESIZE = 100;
	private static Gson gson ;
	
	private static String[][] basicInfos;
	private static Map<String, List<String>> mapBasicInfos;
	private static Map<String, List<List<String>>> records;
	
	private FundInfoManager() throws IOException{
		c = Connector.getInstance();
		gson = new Gson();
		if(!Files.exists(Paths.get(root))){
			Files.createDirectories(Paths.get(root));
			fetchData();
		}
	}
	
	public static FundInfoManager getInstance() throws IOException{
		if(fim == null){
			fim = new FundInfoManager();
		}
		
		return fim;
	}
	
	public void init() throws IOException{
		if(basicInfos == null){
			try {
				initBasicInfoFromInternet();
			} catch (JsonSyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			initBasicInfoFromFile();
		}
	}
	
	public String[][] getRawBasicInfos() {
		return basicInfos;
	}
	
	public Map<String, List<String>> getBasicInfos() {
		if(mapBasicInfos == null){
			mapBasicInfos = new HashMap<String, List<String>>();
			for(String[] basicInfo : basicInfos){
				List<String> data = new ArrayList<String>();
				data.add(basicInfo[0]);
				data.add(basicInfo[1]);
				data.add(basicInfo[2]);
				data.add(basicInfo[3]);
				mapBasicInfos.put(basicInfo[0], data);
			}
		}
		
		return mapBasicInfos;
	}
	
	public List<String> getBasicInfo(String fundCode) {
		if(mapBasicInfos == null){
			mapBasicInfos = new HashMap<String, List<String>>();
			for(String[] basicInfo : basicInfos){
				List<String> data = new ArrayList<String>();
				data.add(basicInfo[0]);
				data.add(basicInfo[1]);
				data.add(basicInfo[2]);
				data.add(basicInfo[3]);
				mapBasicInfos.put(basicInfo[0], data);
			}
		}
		
		return mapBasicInfos.get(fundCode);
	}
	
	public List<String> getSortedFundCodes(String type, int top, SortMethod sortMethod){
		List<String> candidates = new ArrayList<String>();
		if(mapBasicInfos == null){
			mapBasicInfos = new HashMap<String, List<String>>();
			for(String[] basicInfo : basicInfos){
				List<String> data = new ArrayList<String>();
				data.add(basicInfo[0]);
				data.add(basicInfo[1]);
				data.add(basicInfo[2]);
				data.add(basicInfo[3]);
				mapBasicInfos.put(basicInfo[0], data);
			}
		}
		for(List<String> mapBasicInfo : mapBasicInfos.values()){
			if(!type.equals("全部")){
				if(mapBasicInfo.get(3).equals(type)){
					candidates.add(mapBasicInfo.get(0));
				}
			} else{
				candidates.add(mapBasicInfo.get(0));
			}
		}
		
		candidates = sortMethod.sort(candidates);
		
		return candidates.size()>top?candidates.subList(0, top):candidates;
		
	}
	
	public List<String> getTypes() {
		List<String> types = new ArrayList<String>();
		for(String[] basicInfo : basicInfos){
			if(!types.contains(basicInfo[3]))
				types.add(basicInfo[3]);
		}
		
		return types;
	}
	
	public List<List<String>> getRecords(String fundCode) throws IOException {
		if(records == null){
			records = new HashMap<String, List<List<String>>>();
		} 
		if(records.size() > RECORDCACHESIZE){
			records.clear();
		}
		
		if(!records.containsKey(fundCode)){
			List<List<String>> record = null;
			try {
				record = c.getRecords(fundCode);
				records.put(fundCode, record);
				FileDataBase.save(records.get(fundCode), root + "/" + fundCode + ".txt");
				return records.get(fundCode);
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String json = FileDataBase.readFromFile(root + "/" + fundCode + ".txt");
			String[][] datas = gson.fromJson(json, String[][].class);
			List<List<String>> lDatas = new ArrayList<List<String>>();
			for(String[] data : datas){
				List<String> llData = new ArrayList<String>();
				llData.add(data[0]);
				llData.add(data[1]);
				llData.add(data[2]);
				llData.add(data[3]);
				llData.add(data[4]);
				lDatas.add(llData);
			}
			records.put(fundCode, lDatas);
			return records.get(fundCode);
			
		}
		return records.get(fundCode);
	}
	
	private void initBasicInfoFromInternet() throws JsonSyntaxException, ClientProtocolException, IOException{
		basicInfos = gson.fromJson(c.getFundInfo(), String[][].class);
	}
	
	private void initBasicInfoFromFile() throws IOException {
		String basicInfosPath = root + "/" + "basicInfos.txt";
		
		String basicInfosJson = "";
		basicInfosJson = FileDataBase.readFromFile(basicInfosPath);
		
		basicInfos = gson.fromJson(basicInfosJson, String[][].class);
	
	}
	
	private void fetchData() throws ClientProtocolException, IOException{
		basicInfos = gson.fromJson(c.getFundInfo(), String[][].class);
		FileDataBase.save(basicInfos, root + "/" + "basicInfos.txt");
		fetchRecords(basicInfos);
	}
	
	private void fetchRecords(String[][] basicInfos) throws ClientProtocolException, IOException{
		for(String[] basicInfo : basicInfos){
			FileDataBase.save( c.getRecords(basicInfo[0]), root + "/" + basicInfo[0] + ".txt");
			System.out.println(basicInfo[0]);
		}
	}
	
}
