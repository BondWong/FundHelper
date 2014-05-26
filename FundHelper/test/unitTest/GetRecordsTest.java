package unitTest;

import java.io.IOException;
import java.util.List;

import model.Connector;

import org.apache.http.client.ClientProtocolException;
import org.junit.Assert;
import org.junit.Test;

public class GetRecordsTest {
	@Test
	public void getRecordsTest() throws ClientProtocolException, IOException{
		Connector c = Connector.getInstance();
		List<List<String>> records = c.getRecords("000001");
		for(List<String> record: records){
			System.out.println(record);
		}
		Assert.assertNotNull(records);
	}
}
