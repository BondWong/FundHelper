package model.sortMethod;

import java.util.Comparator;

public class FiveYearRaiseSortMethod extends SortMethod{

	@Override
	protected Comparator<String> getComparator() {
		// TODO Auto-generated method stub
		return new FiveYearRaiseComparator();
	}

}
