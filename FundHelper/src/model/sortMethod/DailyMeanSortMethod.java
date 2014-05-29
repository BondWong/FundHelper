package model.sortMethod;

import java.util.Comparator;

public class DailyMeanSortMethod extends SortMethod{

	@Override
	protected Comparator<String> getComparator() {
		// TODO Auto-generated method stub
		return new DailyMeanComparator();
	}
	
}
