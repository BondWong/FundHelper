package unitTest;

import java.io.IOException;

import model.FundInfoManager;

import org.apache.http.client.ClientProtocolException;
import org.junit.Assert;
import org.junit.Test;

public class FundInfoManagerGetBasicInfosTest {
	@Test
	public void testGetBasicInfos() throws ClientProtocolException, IOException{
		FundInfoManager fim = FundInfoManager.getInstance();
		String[][] basicInfos = fim.getBasicInfo();
		for(String[] basicInfo : basicInfos){
			System.out.println(basicInfo[0] + basicInfo[1] + basicInfo[2] + basicInfo[3]);
		}
		Assert.assertNotNull(basicInfos);
	}
}
