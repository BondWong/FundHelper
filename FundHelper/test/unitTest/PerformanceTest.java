package unitTest;

import java.io.IOException;

import model.FundInfoManager;

import org.junit.Assert;
import org.junit.Test;

public class PerformanceTest {
	@Test
	public void testPerformance() throws IOException{
		FundInfoManager fim = FundInfoManager.getInstance();
		fim.init();
		long start = System.currentTimeMillis();
		fim.getRecords("000001");
		long end = System.currentTimeMillis();
		
		long start2 = System.currentTimeMillis();
		fim.getRecords("000001");
		long end2 = System.currentTimeMillis();
		
		long trial1 = end - start;
		long trial2= end2 - start2;
		
		Assert.assertTrue(trial2*10<trial1);
	}
}
