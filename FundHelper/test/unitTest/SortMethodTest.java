package unitTest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import model.FundInfoManager;
import model.sortMethod.DailyMeanComparator;
import model.sortMethod.FiveYearRaiseComparator;
import model.sortMethod.FiveYearRaiseSortMethod;
import model.sortMethod.HalfYearRaiseComparator;
import model.sortMethod.HalfYearRaiseSortMethod;
import model.sortMethod.OneYearRaiseComparator;
import model.sortMethod.OneYearRaiseSortMethod;
import model.sortMethod.SortMethod;
import model.sortMethod.DailyMeanSortMethod;
import model.sortMethod.TwoYearRaiseComparator;
import model.sortMethod.TwoYearRaiseSortMethod;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class SortMethodTest {
	FundInfoManager fim;
	@Before
	public void setUp() throws IOException {
		fim = FundInfoManager.getInstance();
		fim.init();
	}
	
	@Ignore
	@Test
	public void testSortMethod() throws IOException{
		SortMethod sortMethod = new DailyMeanSortMethod();
		List<String> codes = fim.getSortedFundCodes("全部", 50, sortMethod);
		//System.out.println(codes);
		DailyMeanComparator c = new DailyMeanComparator();
		assertEquals(-1, c.compare(codes.get(0), codes.get(1)));
		assertEquals(50, codes.size());
	}
	
	@Ignore
	@Test
	public void testOneYearRaiseSortMethod() {
		SortMethod sortMethod = new OneYearRaiseSortMethod();
		List<String> codes = fim.getSortedFundCodes("全部", 50, sortMethod);
		//System.out.println(codes);
		OneYearRaiseComparator c = new OneYearRaiseComparator();
		assertEquals(-1, c.compare(codes.get(0), codes.get(1)));
		assertEquals(50, codes.size());
	}
	
	@Ignore
	@Test
	public void testHalfYearRaiseSortMethod() {
		SortMethod sortMethod = new HalfYearRaiseSortMethod();
		List<String> codes = fim.getSortedFundCodes("全部", 50, sortMethod);
		//System.out.println(codes);
		HalfYearRaiseComparator c = new HalfYearRaiseComparator();
		assertEquals(-1, c.compare(codes.get(0), codes.get(1)));
		assertEquals(50, codes.size());
	}
	
	@Ignore
	@Test
	public void testTwoYearRaiseSortMethod() {
		SortMethod sortMethod = new TwoYearRaiseSortMethod();
		List<String> codes = fim.getSortedFundCodes("全部", 50, sortMethod);
		//System.out.println(codes);
		TwoYearRaiseComparator c = new TwoYearRaiseComparator();
		assertEquals(-1, c.compare(codes.get(0), codes.get(1)));
		assertEquals(50, codes.size());
	}
	
	@Test
	public void testFiveYearRaiseSortMethod() {
		SortMethod sortMethod = new FiveYearRaiseSortMethod();
		List<String> codes = fim.getSortedFundCodes("全部", 50, sortMethod);
		//System.out.println(codes);
		FiveYearRaiseComparator c = new FiveYearRaiseComparator();
		assertEquals(-1, c.compare(codes.get(0), codes.get(1)));
		assertEquals(50, codes.size());
	}
	
}
