package unitTest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import model.FundInfoManager;
import model.sortMethod.SortMethod;
import model.sortMethod.YearlyMeanSortMethod;

import org.junit.Test;

public class YearlyMeanSortMethodTest {
	@Test
	public void testSortMethod() throws IOException{
		FundInfoManager fim = FundInfoManager.getInstance();
		fim.init();
		SortMethod sortMethod = new YearlyMeanSortMethod();
		List<String> codes = fim.getSortedFundCodes("全部", 50, sortMethod);
		System.out.println(codes);
		assertEquals(50, codes.size());
	}
}
