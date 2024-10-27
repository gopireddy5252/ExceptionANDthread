package Exception;

import java.util.Scanner;

public class Convert {
	public static void convertUppercase(String str)
	{
		try {
			System.out.println(str.toUpperCase());	
		}
		catch(NullPointerException n)
		{
			System.out.println("you will enter alphabets in String then only it is possible");
		}
	}
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter value: ");
		String str=sc.nextLine();
		String st=null;
		convertUppercase(str);
		convertUppercase(st);
		
	}
	}
