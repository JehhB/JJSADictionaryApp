/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package bktree;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author eco
 */
public class LavenshteinDistanceNGTest {

	@Test
	public void testGetDistance() {
		LavenshteinDistance instance = new LavenshteinDistance("book");
		assertEquals(instance.getDistance("book"), 0);
		assertEquals(instance.getDistance("back"), 2);
		assertEquals(instance.getDistance("bookie"), 2);
		assertEquals(instance.getDistance("booc"), 1);
	}

}
