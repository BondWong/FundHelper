package unitTest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import model.FundInfoManager;

import org.apache.http.client.ClientProtocolException;
import org.junit.Assert;
import org.junit.Test;

public class FundInfoManagerGetBasicInfosTest {
	@Test
	public void testGetBasicInfos() throws ClientProtocolException, IOException{
		FundInfoManager fim = FundInfoManager.getInstance();
		fim.init();
		Map<String, List<String>> basicInfos = fim.getBasicInfos();
		for(List<String> basicInfo : basicInfos.values()){
			System.out.println(basicInfo);
		}
		Assert.assertNotNull(basicInfos);
	}
}
