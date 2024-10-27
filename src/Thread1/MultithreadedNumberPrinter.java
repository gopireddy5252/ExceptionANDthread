package Thread1;

class NumberPrinter {
	int primeNumber = 1;
	int evenNumber = 1;
	int oddNumber = 1;

	public synchronized void printPrime() throws InterruptedException {
		boolean flag;
		while (primeNumber <= 100) {
			flag = false;
			if (isPrime(primeNumber)) {
				System.out.println("prime :" + primeNumber);
				flag = true;
			}
			primeNumber++;
			Thread.sleep(100);
			notify();
			if (flag) {
				wait();
			}
		}
		System.exit(0);
	}

	public boolean isPrime(int num) {
		if (num <= 1)
			return false;
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	public synchronized void isEven() throws InterruptedException {
		boolean flag;
		while (evenNumber <= 100) {
			flag = false;
			if (evenNumber % 2 == 0) {
				System.out.println("Even :" + evenNumber);
				flag = true;
			}
			evenNumber++;
			Thread.sleep(200);
			notify();
			if (flag) {
				wait();
			}
		}
		System.exit(0);
	}

	public synchronized void isOdd() {
		boolean flag;
		while (oddNumber <= 100) {
			flag = false;
			if (oddNumber % 2 == 1) {
				System.out.println("Odd :" + oddNumber);
				flag = true;
			}
			oddNumber++;
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			notify();
			if (flag) {
				try {
					wait();
				} catch (InterruptedException e) {
					System.out.println(e);
				}
			}
		}
		System.exit(0);
	}
	public synchronized void m12()
	{
		for(char c='a'; c>='z';c++)
		{
			System.out.print(c+" ");
		}
			}

}

public class MultithreadedNumberPrinter {

	public static void main(String[] args) {
		System.out.println("Main starts");
		NumberPrinter np = new NumberPrinter();
		Thread th1 = new Thread() {
			public void run() {
				try {
					np.printPrime();
				} catch (InterruptedException e) {
					System.out.println(e);
				}
			}
		};
		Thread th2 = new Thread(() -> {
			try {
				np.isEven();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		});
		Thread th3 = new Thread(np::isOdd);
		Thread th4=new Thread()
		{
		public void run() {
				try {
					np.m12();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
			
		};
		th4.start();
		th2.start();
		th3.start();
		
	}

}
