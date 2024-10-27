package Thread1;

import java.util.Scanner;

//A typical example of simultaneous threads is that of a bank account where two people could be operating at the same time.
//In this problem, we are writing an Account class.
//* An Account class is given to you. This class is used to deposit and withdraw from the account.
//* Declare an integer variable called balance. This variable holds the current balance of the account.
//* Declare a method deposit(int amount):
//* This method should add the given amount to balance. There is no need to validate amount. This method returns void.
//* Declare a method withdraw(int amount):
//* This method should subtract the given amount from balance. There is no need to validate amount. This method returns void.
//* If Multiple threads are trying to use this class for operating the account, this class should be able to hand le the multiple threads
//Such that there is no thread interference or error in the balance.
//* Use the class AccountTester.java to test the Account class and its methods. Make sure you test the class for single and multi-threaded operations.	
class Account   {
	double balance;

	public Account(double balance) {
		this.balance = balance;
	}

	public synchronized void deposit(double amount) {
		try {
			if(amount>0)
			{
			balance += amount;
			System.out.println("$ "+amount+" deposited....");
			System.out.println("Available balance is: " + balance);
			}
			else
			{
				System.out.println("Invalid amount....");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public synchronized void withdraw(double amount) {
		try {
		if (balance >= amount) {
				balance -= amount;
				System.out.println("$ "+amount+" withdrwal....");
				System.out.println("Available balance is: " + balance);
			}
		else {
			System.out.println("insufficient money");
		}
		}catch (Exception e) {
				System.out.println(e);
			}
		} 
	}
class Transaction implements Runnable{
	private Account account;
	private boolean flag;
	private double amount ;
	
	public Transaction(Account account, boolean flag, double amount) {
		this.account = account;
		this.flag=flag;
		this.amount = amount;
		
	}

	@Override
	public void run() {
		if(flag)
		{
			account.deposit(amount);
		}
		else
		{
			account.withdraw(amount);
		}
		
	}
	
}
public class AccountTester{
		public static void main(String[] args) {
			Account a = new Account(1000);
			Thread t1=new Thread(new Transaction(a, true, 500),"deposit");
			Thread t2=new Thread(new Transaction(a, false, 1000),"withdraw");
			Thread t3=new Thread(new Transaction(a, true, 500),"deposit");
			
			try {
	            t1.start();
	            t1.join(); // Wait for t1 to finish
	            t2.start();
	            t2.join(); // Wait for t2 to finish
	            t3.start();
	            t3.join(); // Wait for t3 to finish
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
			
		}
}
			
			
			

//			Thread th=new Thread() {
//				public void run()
//				{
//					try {
//						a.deposit(1000);
//						a.withdraw(500);
//					}
//					catch(Exception e)
//					{
//						System.out.println(e);
//					}
//				}
//			
//
//		};
//		th.start();
//		Thread th2=new Thread(()->
//		{
//			try {
//				Thread.sleep(300);
//				a.withdraw(100);
//			}catch(Exception e)
//			{
//				System.out.println(e);
//			}
//			
//		});
//		th2.start();
//	}
//}


	
