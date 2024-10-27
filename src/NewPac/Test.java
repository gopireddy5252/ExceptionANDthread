package NewPac;

public class Test {
	static Thread th1, th2;

	public static void main(String[] args) throws InterruptedException {
		th1 = new Thread() {
			public void run() {
				System.out.print("A");
				try {
					th2.sleep(1000);
				} catch (Exception e) {
					System.out.print("B");
				}
				System.out.println("sadsfghj");
			}
		};
		th2 = new Thread() {
			public void run() {
				System.out.print("D");
				try {
					th1.join();
				} catch (Exception e) {
					System.out.print("E");
				}
			}
		};
		th1.start();th1.join();
		th2.start();th2.join();
	}
}