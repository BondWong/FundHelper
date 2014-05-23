package unitTest;

import java.io.IOException;

import model.Connector;

import org.apache.http.client.ClientProtocolException;
import org.junit.Assert;
import org.junit.Test;

public class GetRecordsTest {
	@Test
	public void getRecordsTest() throws ClientProtocolException, IOException{
		Connector c = Connector.getInstance();
		String[][] records = c.getRecords("000001");
		for(String[] record: records){
			System.out.println(record[0] + " " + record[1] + " " + record[2] + " " +
		record[3] + " " + record[4]);
		}
		Assert.assertNotNull(records);
	}
}
