package Thread1;
// WAP To create a class that extends thread, create a parameteized constructor which
// will recive the name of thread, invoke the super class constructor the passing the name received
// override the run method and perform the following task
//1.display the currect thread name
//2.make the thread pause for 2000 milli seconds 
//
//create multiple custom thread object and assign name to the threads
//make the first thread come to running state 
//wait for first thread to finish its execution
// start the second thread 

class Class1 extends Thread{
	public Class1(String name) {
		super(name);
	}
	public void run()
	{
		System.out.println(this+"born");
		try {
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			
		}
		System.out.println(this+" die");
		
	}
	
}
public class Sample {
	public static void main(String[] args) {
		Thread t1=Thread.currentThread();
		//System.out.println(t1);
		Class1 c=new Class1(t1.getName());
		
		try {
			c.start();
			Thread.sleep(2000); // just wait 2000 milli seconds if task is 			complete or not
			//c.join();// wait the complete execution of first task but if 			multiple
			//Threads runs the at a time this join() may not works.
			//c.yield(); do not put the try block
			//c.wait(); // if u invoke a wait() method then method should be 			Synchronized
			// if use multiple threads at a time wait() should be, to perform 			multiple tasks in sequencial order.
			
			
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
		System.out.println("main thread is executeted");
		Class1 c1=new Class1("Thread-1");
		c1.start();	
	}

}
