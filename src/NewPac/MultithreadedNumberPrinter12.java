package NewPac;

import java.util.concurrent.atomic.AtomicInteger;

class NumberPrinter {
	private static final int MAX_NUMBER = 100;
	private static AtomicInteger currentNumber = new AtomicInteger(1);

	public static void printPrime() {
		while (true) {
			int number = currentNumber.getAndIncrement();
			if (number > MAX_NUMBER)
				break;
			if (isPrime(number)) {
				System.out.println("Prime: " + number);
			}
		}
	}

	public static void printEven() {
		while (true) {
			int number = currentNumber.getAndIncrement();
			if (number > MAX_NUMBER)
				break;
			if (number % 2 == 0) {
				System.out.println("Even: " + number);
			}
		}
	}

	public static void printOdd() {
		while (true) {
			int number = currentNumber.getAndIncrement();
			if (number > MAX_NUMBER)
				break;
			if (number % 2 != 0) {
				System.out.println("Odd: " + number);
			}
		}
	}

	private static boolean isPrime(int num) {
		if (num <= 1)
			return false;
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
}

public class MultithreadedNumberPrinter12 {
	public static void main(String[] args) {
		System.out.println("Main starts");

		Thread th1 = new Thread(NumberPrinter::printPrime);
		Thread th2 = new Thread(NumberPrinter::printEven);
		Thread th3 = new Thread(NumberPrinter::printOdd);

		th1.start();
		th2.start();
		th3.start();
	}
}
