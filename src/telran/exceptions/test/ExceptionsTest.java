package telran.exceptions.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import telran.exceptions.BallBrokenFloor;

class ExceptionsTest {

	@Test
	void testException() {
		int res = 0;
		try {
			res = itThrowsCheckedException(10000);
			System.out.println("everything ok");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			res = 100;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			res = 200;
		}
		assertEquals(20, res);
	}

	private int itThrowsCheckedException(int number) throws Exception {
		if (number < 0) {
			throw new Exception("just test checked exception");
		}
		if (number > 1000) {
			throw new RuntimeException("number cannot be greater than 1000");
		}
		return number * 2;
	}

	@Test
	void ballBrokenFloorTest() {
		for (int i = 0; i < 1000; i++) {
			BallBrokenFloor bbf = new BallBrokenFloor((int) (1 + Math.random() * 100_000));
			assertEquals(bbf.getFloor(), getMinFloor(bbf));
		}
	}

	private int getMinFloor(BallBrokenFloor bbf) {
		int left = 1;
		int right = bbf.getnFloors();
		int middle = right / 2;
		while (left <= right) {
			try {
				bbf.broken(middle);
				left = middle + 1;
			} catch (Exception e) {
				right = middle - 1;
			}
			middle = (left + right) / 2;
		}
		return left;
	}
}
