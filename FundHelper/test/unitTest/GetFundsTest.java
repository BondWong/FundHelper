package unitTest;

import java.io.IOException;
import java.util.List;

import model.Fund;
import model.FundConvertor;

import org.junit.Assert;
import org.junit.Test;

public class GetFundsTest {
	private FundConvertor fc;
	
	@Test
	public void testGetFunds() throws IOException{
		fc = new FundConvertor();
		
		List<Fund> funds = fc.getFunds();
		
		Assert.assertNotNull(funds);
	}
}
