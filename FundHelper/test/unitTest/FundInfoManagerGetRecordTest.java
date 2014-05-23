package unitTest;

import java.io.IOException;

import model.FundInfoManager;

import org.junit.Assert;
import org.junit.Test;

public class FundInfoManagerGetRecordTest {
	@Test
	public void testFundIngoManagerGetRecord() throws IOException{
		FundInfoManager fim = FundInfoManager.getInstance();
		String[][]record = fim.getRecords("000001");
		for(String [] data : record){
			System.out.println(data[0] + " " + data[1] + " " + data[2] + " " + data[3] + " " + data[4]);
		}
		Assert.assertNotNull(record);
	}
}
