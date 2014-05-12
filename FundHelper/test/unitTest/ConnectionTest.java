package unitTest;

import static org.junit.Assert.*;

import java.io.IOException;

import model.Connector;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

public class ConnectionTest {
	private String URL = "http://fund.eastmoney.com/data/fundranking.html";
	
	@Test
	public void testConnection() throws ClientProtocolException, IOException{
		Connector c = Connector.getInstance();
		boolean result = c.connect(URL);
		
		assertEquals(true, result);
	}
}
