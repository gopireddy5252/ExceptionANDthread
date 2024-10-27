package Exception;

import java.util.Scanner;
class InvaliUserException extends Exception // or RuntimeException
{
	@Override
	public String getMessage()
	{
		return "Invalid card details...pls try Again";
		
	}
}
class Atm
{
	private int accountNum=6025;
	private int pinNum=3589;
	int acc;
	int pin;
	public void acceptInput()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter account Number");
		acc=sc.nextInt();
		System.out.println("Enter pin number: ");
		pin=sc.nextInt();
	}
	public void validate()throws InvaliUserException
	{
		if(accountNum==acc && pinNum==pin)
		{
			System.out.println("Collect ur cash");
		}
		else
		{
			InvaliUserException iue=new InvaliUserException();
			System.out.println(iue.getMessage());
			throw iue;
		}
	}
}
class Banking
{
	public void permit() {
		Atm a=new Atm();
		try {
		a.acceptInput();
		a.validate();
	}catch(Exception e)
		{
		try {
			a.acceptInput();
			a.validate();
			}
			catch(Exception e1)
			{
				try {
					a.acceptInput();
					a.validate();
				}
				catch(Exception e2)
				{
					System.err.println("your card is blocked..pls visit ur bank");
				}
				
				}
			}
		
		}
}
public class ATMexception {
	public static void main(String[] args) {
		Banking b=new Banking();
		b.permit();			
	}

}
