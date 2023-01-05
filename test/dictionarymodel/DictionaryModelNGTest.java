package dictionarymodel;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class DictionaryModelNGTest {

	public DictionaryModelNGTest() {
	}

	@Test
	public void testInit() {
		DictionaryModel instance = new DictionaryModel();

		var depth = instance.getModel().getDepth();
		var length = instance.getModel().getLength();

		System.out.println(depth + " " + length);

		assertTrue(depth > 0);
		assertEquals(length, instance.getSize());
	}
}
