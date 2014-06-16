package model.sortMethod;

import java.io.IOException;

import model.FileDataBase;

public class DailyMeanComparator extends SimpleComparator{
	
	@Override
	public int compare(String fundCode1, String fundCode2) {
		// TODO Auto-generated method stub
		try {
			double result =  -((dailyMean(fundCode1)/365) - dailyMean(fundCode2)/365);
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
