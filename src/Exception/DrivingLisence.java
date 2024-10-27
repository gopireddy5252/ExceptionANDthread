package Exception;

import java.util.Scanner;

class OverAgeException extends RuntimeException
{
	@Override
	public String getMessage()
	{
		return "you are age old..pls cool down!";
	}
}
class UnderAgeException extends RuntimeException
{
	@Override
	public String getMessage()
	{
		return "you are age young..pls have some patience!";
	}
}
class Applicant
{
	private int age;
	public void acceptInput()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter ur age");
		age=sc.nextInt();
		sc.close();
	}
	public void validate()  {
		if(age>=18 && age<60)
			System.out.println("Collect ur DL");
		else if(age<18)
		{
			OverAgeException oge=new OverAgeException();
			System.out.println(oge.getMessage());
			
		}
		else
		{
			UnderAgeException uge=new UnderAgeException();
			System.out.println(uge.getMessage());
		}
	}
}
class RTO
{
	public void permit() {
		Applicant ap=new Applicant();
		ap.acceptInput();
		ap.validate();			
	}
}
public class DrivingLisence {
	public static void main(String[] args) {
		RTO rto=new RTO();
		rto.permit();
	}

}
