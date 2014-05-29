package model.sortMethod;

import java.io.IOException;
import java.util.Comparator;

import javax.swing.filechooser.FileSystemView;

import com.google.gson.Gson;

import model.FileDataBase;

public class DailyMeanComparator implements Comparator<String>{
	private static String root = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath() + "/funddatas";
	private static Gson gson = new Gson();
	@Override
	public int compare(String fundCode1, String fundCode2) {
		// TODO Auto-generated method stub
		try {
			double result =  -((dailyMean(fundCode1)/365) - dailyMean(fundCode2)/365);
			System.out.println(result);
			if(result > 0)
				return 1;
			else if(result < 0)
				return -1;
			else
				return 0;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	private double dailyMean(String fundCode) throws IOException{
		String json = FileDataBase.readFromFile(root + "/" + fundCode + ".txt");
		String[][] datas = gson.fromJson(json, String[][].class);
		double mean = 0.0;
		
		for(String[] data : datas){
			mean +=Double.parseDouble(data[3]);
		}
		
		return mean/=(datas.length==0?1:(datas.length));
	}
	
}
