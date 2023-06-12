package telran.util.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static telran.util.Arrays.addObject;
import static telran.util.Arrays.bubbleSort;
import static telran.util.Arrays.insertObject;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

public class ArraysTest {
	Integer[] numbers = { 10, 5, -5, 100, 200 };
	String[] strings = { "lmn", "a", "ab", "abc", "b", "ba" };

	@Test
	void addObjectTest() {
		Integer[] expectedNumbers = { 10, 5, -5, 100, 200, 50 };
		assertArrayEquals(expectedNumbers, addObject(numbers, 50));
		String[] expectedStrings = { "lmn", "a", "ab", "abc", "b", "ba", "bb" };
		assertArrayEquals(expectedStrings, addObject(strings, "bb"));

	}

	@Test
	void insertObjectTest() {
		Integer[] expectedLast = { 10, 5, -5, 100, 200, 50 };
		Integer[] expectedFirst = { 50, 10, 5, -5, 100, 200 };
		Integer[] expectedMiddle = { 10, 5, 50, -5, 100, 200 };
		assertArrayEquals(expectedLast, insertObject(numbers, 5, 50));
		assertArrayEquals(expectedFirst, insertObject(numbers, 0, 50));
		assertArrayEquals(expectedMiddle, insertObject(numbers, 2, 50));
	}

	@Test
	void digitsSumComporatorTest() {
		Comparator<Integer> comp = new DigitsSumComparator();
		assertTrue(comp.compare(9, 66) < 0);
		assertTrue(comp.compare(9, 111) > 0);
		assertTrue(comp.compare(3, 111) == 0);
		assertTrue(comp.compare(3, -111) == 0);
	}
    
	@Test
	void standardSortComparatorTest() {
		Integer[] array = { 10, 5, 110, 9, 22, 33 };
		Integer[] expected = { 10, 110, 22, 5, 33, 9 };
		Arrays.sort(array, new DigitsSumComparator());
		assertArrayEquals(expected, array);
	}
	
	@Test
	  void bubbleSortComparatorTest() {
	    Integer[] expected = { 10, 100, 200, 5, -5 };
	    Integer[] array = { 10, 5, -5, 100, 200 };
	    bubbleSort(array,new EvenOddComparator());
	    assertArrayEquals(expected, array);
	  }

}
