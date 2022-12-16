package datastructures;

import java.util.function.Consumer;

public class BinarySearchTree<T extends Comparable<T>> {
	private T data;
	private BinarySearchTree<T> left;
	private BinarySearchTree<T> right;

	public BinarySearchTree(T data) {
		this.data = data;
		left = null;
		right = null;
	}

	public T getData() {
		return data;
	}

	public BinarySearchTree<T> getLeft() {
		return left;
	}

	public BinarySearchTree<T> getRight() {
		return right;
	}

	private BinarySearchTree<T> insert(BinarySearchTree<T> node, T data) {
		if (node == null) return new BinarySearchTree(data);
		return node.insert(data);
	}

	public BinarySearchTree<T> insert(T data) {
		if (data.compareTo(this.data) == 0) this.data = data;
		if (data.compareTo(this.data) < 0) left = insert(left, data);
		if (data.compareTo(this.data) > 0) right = insert(right, data);

		return this;
	}

	private <U extends Comparable<T>> T find(BinarySearchTree<T> node, U key) {
		if (node == null) return null;
		return node.find(key);
	}

	public <U extends Comparable<T>> T find(U key) {
		if (key.compareTo(data) == 0) return this.data;
		if (key.compareTo(data) < 0) return find(left, key);
		if (key.compareTo(data) > 0) return find(right, key);
		return null;
	}

	public void forEach(Consumer<T> consumer) {
		if (left != null) left.forEach(consumer);
		consumer.accept(data);
		if (right != null) right.forEach(consumer);
	}
}
