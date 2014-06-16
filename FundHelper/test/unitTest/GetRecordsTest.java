package unitTest;

import java.io.IOException;
import java.util.List;

import model.Connector;

import org.apache.http.client.ClientProtocolException;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class GetRecordsTest {
	@Test
	public void getRecordsTest(){
		Connector c = Connector.getInstance();
		List<List<String>> records;
		try {
			records = c.getRecords("000001");
			for(List<String> record: records){
				System.out.println(record);
			}
			Assert.assertNotNull(records);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Ignore
	@Test
	public void getRecordsTestWithoutNetwork(){
		Connector c = Connector.getInstance();
		try {
			c.getRecords("000001");
			Assert.fail("No Exception Thrown");
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}
	}
}
