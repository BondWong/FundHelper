package unitTest;

import java.io.IOException;
import java.util.List;

import model.FundInfoManager;

import org.junit.Assert;
import org.junit.Test;

public class FundInfoManagerGetBasicInfo {
	@Test
	public void testGetBasicInfo() throws IOException {
		FundInfoManager fim = FundInfoManager.getInstance();
		fim.init(); 
		List<String> basicInfo = fim.getBasicInfo("000001");
		
		System.out.println(basicInfo);
		Assert.assertNotEquals(0, basicInfo.size());
	}
}
