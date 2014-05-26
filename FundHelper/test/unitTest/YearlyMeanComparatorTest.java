package unitTest;

import java.util.Comparator;

import model.sortMethod.YearlyMeanComparator;

import org.junit.Assert;
import org.junit.Test;

public class YearlyMeanComparatorTest {
	@Test
	public void testYearlyMeanComparasion(){
		Comparator<String> comparator = new YearlyMeanComparator();
		int i = comparator.compare("000001", "000014");
		
		Assert.assertTrue(i==-1);
	}
}
