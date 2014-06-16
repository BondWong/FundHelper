package unitTest;

import static org.junit.Assert.*;

import java.io.IOException;

import model.Connector;
import model.FundInfoManager;

import org.junit.Test;

public class SingletonTest {
	@Test
	public void testSingleConnetor() {
		Connector c1 = Connector.getInstance();
		Connector c2 = Connector.getInstance();
		
		assertEquals(c1, c2);
	}
	
	@Test
	public void testSingleFundInfoManager() throws IOException {
		FundInfoManager fim2 = FundInfoManager.getInstance();
		FundInfoManager fim1 = FundInfoManager.getInstance();
		
		assertEquals(fim1, fim2);
	}
}
