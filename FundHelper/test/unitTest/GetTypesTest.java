package unitTest;

import java.io.IOException;
import java.util.List;

import model.FundInfoManager;

import org.junit.Assert;
import org.junit.Test;

public class GetTypesTest {
	@Test
	public void testGetTypes() throws IOException{
		FundInfoManager fim = FundInfoManager.getInstance();
		fim.init();
		List<String> types = null;
		types = fim.getTypes();
		System.out.println(types);
		Assert.assertNotNull(types);
	}
}
