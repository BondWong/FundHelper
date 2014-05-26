package model.sortMethod;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class SortMethod {
	public List<String> sort(List<String> fundCodes) {
		// TODO Auto-generated method stub
		Collections.sort(fundCodes, getComparator());
		return fundCodes;
	}
	
	protected abstract Comparator<String> getComparator();
}
