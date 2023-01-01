package bktree;

import java.util.Comparator;

public class LavenshteinDistanceComparator implements Comparator<Object> {

	private final LavenshteinDistance ld;

	public LavenshteinDistanceComparator(Object base) {
		ld = new LavenshteinDistance(base.toString());
	}

	@Override
	public int compare(Object a, Object b) {
		return ld.getDistance(a.toString()) - ld.getDistance(b.toString());
	}
}
