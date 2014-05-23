package unitTest;

import java.io.IOException;

import model.Connector;

import org.apache.http.client.ClientProtocolException;
import org.junit.Assert;
import org.junit.Test;

public class GetBasicInfoTest {
	@Test
	public void testConnection() throws ClientProtocolException, IOException{
		Connector c = Connector.getInstance();
		String s = c.getFundInfo();
		System.out.println(s);
		Assert.assertNotNull(s);
	}
}
