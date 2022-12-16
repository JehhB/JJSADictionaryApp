/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package datastructures;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

class DummyComparable implements Comparable<DummyComparable> {

	public int key;
	public int value;

	public DummyComparable(int key) {
		this(key, 0);
	}

	public DummyComparable(int key, int value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public boolean equals(Object b) {
		if (b == null) {
			return false;
		}
		DummyComparable cmp = (DummyComparable) b;
		return key == cmp.key && value == cmp.value;
	}

	@Override
	public int compareTo(DummyComparable b) {
		return key - b.key;
	}
}

class DummySearch implements Comparable<DummyComparable> {

	public int key;

	public DummySearch(int key) {
		this.key = key;
	}

	@Override
	public int compareTo(DummyComparable b) {
		return key - b.key;
	}
}

public class BinaryTreeNGTest {

	public BinaryTreeNGTest() {
	}

	/**
	 * Test of constructor and getters, of class BinaryTree.
	 */
	@Test
	public void testConstructorAndGetters() {
		BinarySearchTree<DummyComparable> instance = new BinarySearchTree(new DummyComparable(5));

		DummyComparable data = instance.getData();
		assertEquals(data, new DummyComparable(5, 0));
		assertNotEquals(data, new DummyComparable(5, 1));
		assertNotEquals(data, new DummyComparable(0));

		assertEquals(instance.getLeft(), null);
		assertEquals(instance.getLeft(), null);
	}

	@Test
	public void testInsertion() {
		BinarySearchTree<DummyComparable> root = new BinarySearchTree(new DummyComparable(0));

		BinarySearchTree<DummyComparable> ret = root.insert(new DummyComparable(1, 0));
		assertSame(root, ret);

		ret = root.insert(new DummyComparable(-1));
		assertSame(root, ret);

		ret = root.insert(new DummyComparable(0, 1));
		assertSame(root, ret);

		DummyComparable right = root.getRight().getData();
		DummyComparable expRight = new DummyComparable(1, 0);
		assertEquals(right, expRight);

		DummyComparable left = root.getLeft().getData();
		DummyComparable expLeft = new DummyComparable(-1, 0);
		assertEquals(left, expLeft);
	}

	@Test
	public void testFind() {
		DummyComparable result, expected;
		BinarySearchTree<DummyComparable> root = new BinarySearchTree(new DummyComparable(0))
			.insert(new DummyComparable(-2))
			.insert(new DummyComparable(-3))
			.insert(new DummyComparable(-1))
			.insert(new DummyComparable(2))
			.insert(new DummyComparable(1))
			.insert(new DummyComparable(3));

		result = root.find(new DummySearch(2));
		expected = new DummyComparable(2);
		assertEquals(result, expected);

		result = root.find(new DummySearch(5));
		expected = null;
		assertEquals(result, expected);
	}
}