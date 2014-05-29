package unitTest;

import java.util.Comparator;

import model.sortMethod.DailyMeanComparator;

import org.junit.Assert;
import org.junit.Test;

public class DailyMeanComparatorTest {
	@Test
	public void testYearlyMeanComparasion(){
		Comparator<String> comparator = new DailyMeanComparator();
		int i = comparator.compare("000001", "000014");
		
		Assert.assertTrue(i==-1);
	}
}
