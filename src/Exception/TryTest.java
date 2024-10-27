package Exception;

public class TryTest {
	public static void main(String[] args) {
		System.out.print("main start");
		System.out.print(m1());
		System.out.print("main end");
		}
		static public int m1() {
		try {
		   System.out.print("In try");
		   int a=10;
		   int b=0;
		   int result=a/b;
		   return result;
		}
		catch(ArithmeticException A) {
		System.out.print("In catch");
		 return 20;
		}
		finally {
		System.out.print("In finally");
		return 30;
		}
	}

}

