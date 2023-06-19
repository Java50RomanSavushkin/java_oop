package telran.numbers;

import java.util.function.BinaryOperator;

public class Calculator {
	public static double calculate(CalcData cd) {
//		double num1 = cd.op1;
//		double num2 = cd.op2;
//		char oper = cd.operation;

		int maxAsciiCode = Math.max(Math.max('+', '-'), Math.max('/', '*'));
		DoubleBinaryOperator[] operations = new DoubleBinaryOperator[maxAsciiCode + 1];

		operations['+'] = (a, b) -> a + b;
		operations['-'] = (a, b) -> a - b;
		operations['*'] = (a, b) -> a * b;
		operations['/'] = (a, b) -> a / b;

		return operations[(int) cd.operation].apply(cd.op1, cd.op2);

	}

	interface DoubleBinaryOperator extends BinaryOperator<Double> {
		
	}
}
