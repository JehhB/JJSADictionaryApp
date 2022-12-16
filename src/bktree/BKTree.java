package bktree;

import java.util.ArrayList;
import java.util.List;
import datastructures.BinarySearchTree;

public class BKTree<T> implements Comparable<BKTree<T>> {

	private T value;
	private int distance;
	private BinarySearchTree<BKTree<T>> children;

	private class DistanceSearcher implements Comparable<BKTree<T>> {

		int distance;

		public DistanceSearcher(int distance) {
			this.distance = distance;
		}

		@Override
		public int compareTo(BKTree<T> b) {
			return distance - b.distance;
		}
	}

	private BKTree(T value, int distance) {
		this.value = value;
		this.distance = distance;
		children = null;
	}

	public BKTree(T value) {
		this(value, 0);
	}

	public BKTree<T> insert(T value) {
		int distance = LavenshteinDistance.getDistance(this.value, value);

		if (children == null) {
			children = new BinarySearchTree(new BKTree(value, distance));
		} else {
			BKTree<T> child = children.find(new DistanceSearcher(distance));

			if (child == null) {
				children.insert(new BKTree(value, distance));
			} else {
				child.insert(value);
			}
		}

		return this;
	}

	public List<T> search(Object value, int tolerance) {
		int distance = LavenshteinDistance.getDistance(this.value, value);

		ArrayList<T> res = new ArrayList();
		if (distance <= tolerance) {
			res.add(this.value);
		}

		if (children != null) {
			children.forEach((child) -> {
				if (child.distance >= distance - tolerance && child.distance <= distance + tolerance) {
					res.addAll(child.search(value, tolerance));
				}
			});
		}

		res.sort(new LavenshteinDistanceComparator(value));
		return res;
	}

	public T find(Object value) {
		List<T> res = search(value, 0);
		return res.isEmpty() ? null : res.get(0);
	}

	public int getDepth() {
		if (children == null) return 1;

		var wrapper = new Object(){ int max = 0; };
		children.forEach((child) -> {
			int depth = child.getDepth();
			if (depth > wrapper.max) wrapper.max = depth;
		});

		return 1 + wrapper.max;
	}
	
	@Override
	public int compareTo(BKTree<T> b) {
		return distance - b.distance;
	}
}
