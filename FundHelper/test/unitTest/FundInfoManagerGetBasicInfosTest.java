package unitTest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import model.FundInfoManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FundInfoManagerGetBasicInfosTest {
	FundInfoManager fim;
	@Before
	public void setUp() {
		try {
			fim = FundInfoManager.getInstance();
			fim.init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void testGetBasicInfo() {
			List<String> basicInfo = fim.getBasicInfo("000001");
			System.out.println(basicInfo);
			assertEquals(4, basicInfo.size());
	}
	
	@Test
	public void testGetBasicInfos(){
			Map<String, List<String>> basicInfos = fim.getBasicInfos();
			for(List<String> basicInfo : basicInfos.values()){
				System.out.println(basicInfo);
			}
			Assert.assertNotNull(basicInfos);
	}
	
	@Test
	public void testGetBasicInfoBySN() {
		String[] basicInfo = fim.getBasicInfoBySN("HXCZ");
		assertEquals(4, basicInfo.length);
	}
	
	@Test
	public void testGetBasicInfoByName() {
		String[] basicInfo = fim.getBasicInfoByName("华夏成长");
		assertEquals(4, basicInfo.length);
	}
	
	@Test
	public void testGetTypes(){
		List<String> types = null;
		types = fim.getTypes();
		System.out.println(types);
		Assert.assertNotNull(types);
	}
	
	@Test
	public void testGetFundCode() {
		List<String> codes = null;
		codes = fim.getFundCodes();
		System.out.println(codes);
		Assert.assertNotNull(codes);
	}
	
}
