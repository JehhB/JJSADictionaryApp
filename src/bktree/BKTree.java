package bktree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BKTree<T> {

	private final T value;
	private final Map<Integer, BKTree<T>> children;

	public BKTree(T value) {
		this.value = value;
		children = new TreeMap();
	}

	public BKTree<T> insert(T value) {
		int distance = LavenshteinDistance.getDistance(this.value, value);

		children.compute(distance, (k, v)
			-> v == null ? new BKTree(value) : v.insert(value)
		);

		return this;
	}

	public List<T> search(LavenshteinDistance lavenshteinDistance, int tolerance) {
		Integer distance = lavenshteinDistance.getDistance(value.toString());

		List<T> res = new ArrayList();
		if (distance <= tolerance) {
			res.add(value);
		}

		children.forEach((dist, child) -> {
			if (dist >= distance - tolerance && dist <= distance + tolerance) {
				res.addAll(child.search(lavenshteinDistance, tolerance));
			}
		});

		res.sort(new LavenshteinDistanceComparator(lavenshteinDistance));
		return res;
	}

	public List<T> search(Object value, int tolerance) {
		return search(new LavenshteinDistance(value.toString()), tolerance);
	}

	public T find(Object value) {
		List<T> res = search(value, 0);
		return res.isEmpty() ? null : res.get(0);
	}

	public int getDepth() {
		if (children == null) {
			return 1;
		}

		var wrapper = new Object() {
			int max = 0;
		};

		children.forEach((dist, child) -> {
			int depth = child.getDepth();
			if (depth > wrapper.max) {
				wrapper.max = depth;
			}
		});

		return 1 + wrapper.max;
	}

	public int getLength() {
		var wrapper = new Object() {
			int length = 1;
		};
		children.forEach((dist, child) -> {
			wrapper.length += child.getLength();
		});
		return wrapper.length;
	}
}
