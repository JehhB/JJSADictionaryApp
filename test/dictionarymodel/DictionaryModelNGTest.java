package dictionarymodel;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class DictionaryModelNGTest {

	public DictionaryModelNGTest() {
	}

	@Test
	public void testInit() {
		DictionaryModel instance = new DictionaryModel();
		instance.init();

		var depth = instance.getModel().getDepth();
		var length = instance.getModel().getLength();

		assertTrue(depth > 0);
		assertEquals(length, 78229);
	}
}
