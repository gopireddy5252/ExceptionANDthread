package Therad;

class Printer1 implements Runnable
{

	@Override
	public void run() {
		
		String name = Thread.currentThread().getName();
		
		try {
			System.out.println(name + " 1st line printing");
			Thread.sleep(1000);
			System.out.println(name + " 2nd line printing");
			Thread.sleep(1000);
			System.out.println(name + " 3rd line printing");
			Thread.sleep(1000);
			System.out.println(name + " 4th line printing");
			Thread.sleep(1000);
			System.out.println(name + " 5th line printing");
			Thread.sleep(1000);
			System.out.println();
			
			synchronized (this) {
				System.out.println(name + " 6th line printing");
				Thread.sleep(1000);
				System.out.println(name + " 7th line printing");
				Thread.sleep(1000);
				System.out.println(name + " 8th line printing");
				Thread.sleep(1000);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
public class SychronizedBlock {

	public static void main(String[] args) {
		Printer1 p=new Printer1();
		
		Thread t1=new Thread(p);
		Thread t2=new Thread(p);
		Thread t3=new Thread(p);
		
		t1.setName("gopi");
		t2.setName("raju");
		t3.setName("ramu");
		
		t1.start();
		t2.start();
		t3.start();

	}

}
