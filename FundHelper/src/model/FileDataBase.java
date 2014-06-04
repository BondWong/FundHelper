package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.Gson;

public class FileDataBase {
	private static Gson gson = new Gson();
	public static String readFromFile(String path) throws IOException{
		byte[] bytes = Files.readAllBytes(Paths.get(path));
		return new String(bytes, "utf8");
	}
	
	public static  void save(List<List<String>> datas, String path) throws IOException{
		if(!Files.exists(Paths.get(path))){
			Files.createFile(Paths.get(path));
		}
		
		String[][] sDatas = new String[datas.size()][datas.size()==0?0:datas.get(0).size()];
		for(int i=0;i<sDatas.length;i++){
			for(int j=0;j<sDatas[i].length;j++){
				sDatas[i][j] = datas.get(i).get(j);
			}
		}
		
		Files.write(Paths.get(path), gson.toJson(datas).getBytes());
	}
	
	public static  void save(String[][] datas, String path) throws IOException{
		if(!Files.exists(Paths.get(path))){
			Files.createFile(Paths.get(path));
		}
		
		Files.write(Paths.get(path), gson.toJson(datas).getBytes());
	}
}
