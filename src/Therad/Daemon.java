package Therad;

class Demo implements Runnable {

	@Override
	public void run() {
		Thread thread = Thread.currentThread();
		String name = thread.getName();
		
		if(name.equals("code"))
			code();
			
		else if(name.equals("save"))
			autosave();
		else {
			execute();
		}	
	}
	void code()
	{
		System.out.println("the code start  writing");
		for(int i=1;i<=5;i++)
		{
			System.out.println("writing.....");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	void autosave()
	{	
		System.out.println("the code is automatically save ");
		for(; ;)
		{
			System.out.println("saving.....");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	void execute()
	{	
		System.out.println("the code is ready to execute");
		for(; ;)
		{
			System.out.println("executing....");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class Daemon{
	public static void main(String[] args) {
		Demo d = new Demo();
		
		Thread t1=new Thread(d);
		Thread t2=new Thread(d);
		Thread t3=new Thread(d);
		
	// if u want to stop the infinate for loop execution we can converted user thread to daemon thread 
		t2.setDaemon(true);
		t3.setDaemon(true);
		
		t1.setName("code");
		t2.setName("save");
		t3.setName("execute");
		 
		t1.start();
		t2.start();
		t3.start();
		}
	
}
