package unitTest;

import java.io.IOException;
import java.util.List;

import model.Connector;

import org.apache.http.client.ClientProtocolException;
import org.junit.Assert;
import org.junit.Test;

public class FundDataFetchTest {
	private Connector c;
	
	@Test
	public void testFundDataFetch() throws ClientProtocolException, IOException{
		c = Connector.getInstance();
		c.connect("http://fund.eastmoney.com/data/fundranking.html");
		List<String> datas = c.getFundData();
		
		Assert.assertNotNull(datas);
		
		System.out.println(datas.get(0));
	}
}
