package Thread1;
//class A extends Thread {
//	@Override
//	public void run()
//	{
//		System.out.println("hello");
//	}
//	// program to demonstrete to get the name and priority and state of currect thread
//}
public class Thread1  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		A a1=new A();
//		a1.start();
		Thread t1=Thread.currentThread();
		//Thread t2=new Thread();
		System.out.println("Name of currect thread :"+t1.getName());
		System.out.println("Priority of thread :"+t1.getPriority());
		System.out.println("State of Thread:"+t1.getState());
		System.out.println(Thread.activeCount());
		System.out.println(t1.isAlive());
	}
}


//Note: isAlive() is used to check wheaher the thread is alive or not
//   isAlive() method return true if the thread has been started and thread is not dead yet
//     it return false if the thread is not started yet all the execution of thread is completed.
//     in java the thread status can be of different state the thread are NEW RUNNABLE BLOCKED WAITING AND TIMED_WAITING
// TERMINATED
//  NEW means the newly created thread that has not started  threda execution
// RUNNABLE
//    Thread that is either or ready to run 
// Lock
// the thread that is waiting to accuire a lock to enter the syncronized block or method
// the thread is waitiing indeffinetly for another thread to forform a perticuler task or action 
//TIMED_WAITING
//     A Thread that is waitiing for another thread to perform a specific task or an action for specified peroid of time 
// TERMINATED
//    THE Thread that has completed it's execution.











