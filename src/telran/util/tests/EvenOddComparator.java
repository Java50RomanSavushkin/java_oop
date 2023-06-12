package telran.util.tests;

import java.util.Comparator;

class EvenOddComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer num1, Integer num2) {
		boolean num1Even = num1 % 2 == 0;
		boolean num2Even = num2 % 2 == 0;

		if (num1Even && num2Even) {
			return num1.compareTo(num2);
		} else if (num1Even) {
			return -1; 
		} else if (num2Even) {
			return 1; 
		} else {
			return num2.compareTo(num1);
		}
	}
}
