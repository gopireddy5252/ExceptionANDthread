package Exception;

import java.util.Scanner;

class Demo1 {
     void fun1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a numarator: ");
        int a=sc.nextInt() ;
        System.out.println("Enter a denaminator: ");
        int b=sc.nextInt();
        System.out.println(a/b);
        System.out.println("Connection-1 is estableshed");
    	 }	 
    }
class Demo2{
	void fun2()
	{
		Demo1 d=new Demo1();
		d.fun1();
		System.out.println("Connection-2 is estableshed");
		
	}
	
}
class Demo3{
	void fun3()
	{
		try {
		Demo2 d3=new Demo2();
		d3.fun2();
			System.out.println("Completed");
		}
		catch(RuntimeException e)
	   	 {
	   		 System.out.println("Exception is handled in fun2()");
	   	 }
	}
}

public class TapException {
    public static void main(String[] args) {
    	System.out.println("Main statred");
    	Demo3 d2=new Demo3();
    	d2.fun3();
    	System.out.println("Main ends");
        
    }
}
