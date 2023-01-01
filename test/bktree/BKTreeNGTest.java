/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package bktree;

import java.util.List;
import java.util.Arrays;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BKTreeNGTest {

	static BKTree<String> instance;

	@BeforeClass
	public static void setUpClass() throws Exception {
		instance = new BKTree("help")
			.insert("hell")
			.insert("hello")
			.insert("loop")
			.insert("helps")
			.insert("shell")
			.insert("helper")
			.insert("troop");
	}

	@Test
	public void testGetDepth() {
		int depth = instance.getDepth();
		assertEquals(depth, 3);
	}

	@Test
	public void testFind() {
		String res = instance.find("hell");
		assertEquals(res, "hell");

		res = instance.find("troop");
		assertEquals(res, "troop");

		res = instance.find("none");
		assertEquals(res, null);
	}

	@Test
	public void testSearch() {
		List<String> result = instance.search("oop", 2);
		List<String> expected = Arrays.asList("loop", "troop");

		assertEquals(result, expected);
	}
}
