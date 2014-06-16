package unitTest;

import java.io.IOException;

import model.Connector;

import org.apache.http.client.ClientProtocolException;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class GetBasicInfoTest {
	@Test
	public void testConnection(){
		Connector c = Connector.getInstance();
		String s;
		try {
			s = c.getFundInfo();
			System.out.println(s);
			Assert.assertNotNull(s);
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
	public void testConnectionWithoutNetWork(){
		Connector c = Connector.getInstance();
		try {
			c.getFundInfo();
			Assert.fail("No Exception Thrown");
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
