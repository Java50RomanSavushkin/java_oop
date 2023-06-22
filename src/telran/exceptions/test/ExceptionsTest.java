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

	int N_FLOORS = 200;
 
	@Test
	void ballBrokenFloorTest() {
		BallBrokenFloor bbf = new BallBrokenFloor(N_FLOORS);
		assertEquals(bbf.getFloor(), getMinFloor(bbf));
	}

	private int getMinFloor(BallBrokenFloor bbf) {
		int minFloor = 1;
		int maxFloor = N_FLOORS;
		System.out.println("safe floor " + bbf.getFloor());
		try {
			while (minFloor < maxFloor) {
				int middleFloor = minFloor + (maxFloor - minFloor) / 2;
				try {
					bbf.broken(middleFloor);
					minFloor = middleFloor + 1;
				} catch (Exception e) {
					maxFloor = middleFloor;
					System.out.println("checked floor " + maxFloor);
				}
			}
		} catch (Exception e) {
		}
		return maxFloor;
	}
}
