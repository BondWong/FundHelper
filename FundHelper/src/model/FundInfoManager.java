package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.swing.filechooser.FileSystemView;

import org.apache.http.client.ClientProtocolException;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class FundInfoManager {
	private static FundInfoManager fim;
	private static Connector c;
	private static String root = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath() + "/funddatas";
	private static Gson gson ;
	
	private static String[][] basicInfos;
	private static Map<String, String[][]> records;
	
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
	
	public String[][] getBasicInfo() throws IOException {
		if(basicInfos == null){
			try {
				initBasicInfoFromInternet();
				return basicInfos;
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
			return basicInfos;
		}
		
		return basicInfos;
	}
	
	public String[][] getRecords(String fundCode) throws IOException {
		if(records == null){
			records = new HashMap<String, String[][]>();
		} 
		if(records.size() > 100){
			records.clear();
		}
		
		if(!records.containsKey(fundCode)){
			String[][] record = null;
			try {
				record = c.getRecords(fundCode);
				records.put(fundCode, record);
				save(records.get(fundCode), root + "/" + fundCode + ".txt");
				return records.get(fundCode);
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String json = readFromFile(root + "/" + fundCode + ".txt");
			records.put(fundCode, gson.fromJson(json, String[][].class));
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
		basicInfosJson = readFromFile(basicInfosPath);
		
		basicInfos = gson.fromJson(basicInfosJson, String[][].class);
	
	}
	
	private void fetchData() throws ClientProtocolException, IOException{
		basicInfos = gson.fromJson(c.getFundInfo(), String[][].class);
		save(basicInfos, root + "/" + "basicInfos.txt");
		fetchRecords(basicInfos);
	}
	
	private void fetchRecords(String[][] basicInfos) throws ClientProtocolException, IOException{
		for(String[] basicInfo : basicInfos){
			save( c.getRecords(basicInfo[0]), root + "/" + basicInfo[0] + ".txt");
			System.out.println(basicInfo[0]);
		}
	}
	
	private String readFromFile(String path) throws IOException{
		byte[] bytes = Files.readAllBytes(Paths.get(path));
		return new String(bytes, "utf8");
	}
	
	private void save(String[][] datas, String path) throws IOException{
		if(!Files.exists(Paths.get(path))){
			Files.createFile(Paths.get(path));
		}
		
		Files.write(Paths.get(path), gson.toJson(datas).getBytes());
	}
	
}
