package unitTest;

import java.io.IOException;
import java.util.List;

import model.FundInfoManager;

import org.junit.Assert;
import org.junit.Test;

public class FundInfoManagerGetRecordTest {
	@Test
	public void testFundIngoManagerGetRecord() throws IOException{
		FundInfoManager fim = FundInfoManager.getInstance();
		fim.init();
		List<List<String>> record = fim.getRecords("000001");
		for(List<String> data : record){
			System.out.println(data);
		}
		Assert.assertNotNull(record);
	}
}
