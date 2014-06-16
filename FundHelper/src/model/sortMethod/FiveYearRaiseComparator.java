package model.sortMethod;

import java.io.IOException;

import model.FileDataBase;

public class FiveYearRaiseComparator extends SimpleComparator {

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		double result;
		try {
			result = -(getFiveYearRaise(o1) - getFiveYearRaise(o2));
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
	
	private double getFiveYearRaise(String fundCode) throws IOException {
		String json = FileDataBase.readFromFile(root + "/" + fundCode + ".txt");
		String[][] datas = gson.fromJson(json, String[][].class);
		
		if(datas.length==0)
			return 0.0;
		double currentValue = Double.parseDouble(datas[0][3]);
		double compareValue = 0.0;
		if(datas.length<=365*5)
			compareValue = Double.parseDouble(datas[datas.length-1][3]);
		else
			compareValue = Double.parseDouble(datas[365*5][3]);
		
		return currentValue - compareValue;
	}
	
}
