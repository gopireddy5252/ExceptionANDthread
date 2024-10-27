package Thread1;

public class Factorial {
	public static void findFactorial(int num)
	{
		for(int i=1;i<=100;i++)
		{
			if(i%num==0)
			{
				System.out.print(i+" ");
			
			}
			
		}
		System.out.println();
		
	}

	public static void main(String[] args) {
		Thread t=new Thread(()->{
			try {
				findFactorial(2);
			}catch(Exception e)
			{
				System.out.println(e);
			}
			
		});
		t.start();
		Thread th1=new Thread(()->{
			try {
				t.join();
				System.out.println();
				findFactorial(3);
			}catch(Exception e)
			{
				System.out.print(e);
			}
	});
		th1.start();

	}

}
