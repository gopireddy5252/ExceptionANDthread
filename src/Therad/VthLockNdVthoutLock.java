package Therad;

class Printer implements Runnable{

	

//	@Override
//	public void run() {
//		String name = Thread.currentThread().getName();
//		
//		System.out.println(name+" started printing..");
//		for(int i=1;i<=3;i++)
//		{
//			System.out.println(name+" is printing...");
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.println(name+" complted printing");
//		
//	}
	
	//here at a time 3 numbers not going to use the printer so we can use synchronized method for provide lock
	
	@Override
	synchronized public void run() {
		String name = Thread.currentThread().getName();
		
		System.out.println(name+" started printing..");
		for(int i=1;i<=3;i++)
		{
			System.out.println(name+" is printing...");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(name+" complted printing");
		
	}
	
}
public class VthLockNdVthoutLock {

	public static void main(String[] args) {
		
		Printer p=new Printer();
		
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(p);
		Thread t3 = new Thread(p);
		
		t1.setName("Dad");
		t2.setName("Mom");
		t3.setName("son");
		
		t1.start();
		t2.start();
		t3.start();
	}

}
