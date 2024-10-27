package Therad;
class Queue
{
	int x;
	boolean is_data_present=false;
	synchronized void store(int j)
	{
		try{
		if(is_data_present==false)
		{
		x=j;
		System.out.println(" Produced "+x);
		is_data_present=true;
		notify();
		}
		else {
			wait();
		}
	}
	catch(Exception e)
	{
		System.out.println(" some problem occured.");
	}
	
}
	synchronized void retrieve()
	{
		try {
			if (is_data_present==true) {
				System.out.println(" Consumed "+x);
				is_data_present=false;
				notify();
			}
			else {
				wait();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
class Producer extends Thread
{
	Queue a;
	
	public Producer(Queue q) {
		a = q;
	}

	@Override
	public void run()
	{
		int i=1;
		for(; ;)
		{
			a.store(i++);
		}
	}
}
class Consumer extends Thread
{
	Queue b;
	
	public Consumer(Queue q) {
		b=q;
	}

	@Override
	public void run()
	{
		for(; ;)
		{
			b.retrieve();
		}
	}
}
public class ProducerNDconsumer {

	public static void main(String[] args) {
		Queue q=new Queue();
		
		Producer p=new Producer(q);
		Consumer c=new Consumer(q);
		
		p.start();
		c.start();
		

	}

}

