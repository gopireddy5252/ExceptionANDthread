package Exception;

import java.util.InputMismatchException;
import java.util.Scanner;
class Animal{
	String name;
	int age;
	public Animal(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + "]";
	}
}
class Dog extends Animal
{
	public Dog(String name, int age) {
		super(name,age);
		this.name=name;
		this.age=age;
	}
	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age  + "]";
	}
	public static void printDetails(Animal ani)
	{
		System.out.println(ani.name);
		System.out.println(ani.age);
	}	
	
}

public class TryndCatch
{
	public static Object[] intializeArray(Object[] obj)
	{
		try {
			obj[1]=123;
			return obj;
		}
		catch(ArrayStoreException ase)
		{
			System.out.println("do not store incompactable values");
			return obj;
		}
		
	}
	public static void div(int a,int b)
	{
		try {
			System.out.println(a/b);
		}
		catch(Exception a1)
		{
			System.out.println("u sholud give second number is other than zero" + a1.getMessage());
			//a1.printStackTrace();
		}
	}
	public static void convert(String str)
	{
		try {
			int st=Integer.parseInt(str);
			System.out.println(st);
		}
		catch(NumberFormatException n)
		{
			System.out.println("you will digits in String then only it is possible");
		}
	}
	public static void readInt()
	{
		try {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter one integer value: ");
		int i=sc.nextInt();
		System.out.println(i);
		}
		catch(InputMismatchException im)
		{
			System.out.println("pls enter integer format " + im.getMessage());
		}
	}
	public static void insertArrayElements()
	{
		try {
			int[] arr= {1,2,3,4};
			System.out.println(arr[5]);
		}
		catch(ArrayIndexOutOfBoundsException ai)
		{
			System.out.println("your not give any parameter in method");
		}
	}
	public static void convertUpperCase(String s)
	{
		try {
			System.out.println(s.toUpperCase());
		}
		catch(NullPointerException n)
		{
			System.out.println("pls enter some word");
		}
	}
    public static void main(String[] args) {
    		div(10, 0);
    		convert("abc");
    		readInt();
    		insertArrayElements();
    		convertUpperCase("gopi reddy");
    		String[] str=new String[2];
    		Object[] ob=intializeArray(str);
    		System.out.println(ob[1]);
    		
    		
    		try {
    		Scanner sc1=new Scanner(System.in);
    		System.out.println("Enter dog name: ");
    		String name=sc1.nextLine();
    		System.out.println("Enter dog age: ");
    		int age=sc1.nextInt();
    		Dog d=new Dog(name,age);
    		Animal animal=new Animal(name, age);
    		Dog dog=(Dog)animal;
    		//12System.out.println(d);
   
    		}
    		catch(Exception ims)
    		{
    			System.out.println("pls enter valid input:"+ims.getMessage());
    		}
    		finally {
    			System.out.println("complete");
    		}   		
    }
}