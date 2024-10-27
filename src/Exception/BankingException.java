package Exception;

import java.util.Scanner;

@SuppressWarnings("serial")
class InvalidAmountException extends Exception {
	public InvalidAmountException()
	{
		
	}
    InvalidAmountException(String message) {
        super(message);
    }
}
class InsufficientFundException extends Exception {
	public InsufficientFundException()
	{
		
	}
    InsufficientFundException(String msg) {
        super(msg);
    }
}
class Bank {
    private String accountNumber;
    private double balance;
    public Bank(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public void deposit(double Amount) throws InvalidAmountException {
        if (Amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be greater than 0");
        }
        balance += Amount;
        System.out.println(Amount + " Deposit successfully");
        System.out.println("Available balance is " + balance);
    }
    public void withdraw(double Amount) throws InsufficientFundException {
        if (Amount > balance) {
            throw new InsufficientFundException("Insufficient funds. Please check your balance.");
        }
        balance -= Amount;
        System.out.println(Amount + " withdraw Successfully");
        System.out.println("Available balance is :" + balance);
    }
}
public class BankingException {
    public static void main(String[] args)throws InsufficientFundException , InvalidAmountException  {
        try {
            Bank b = new Bank("123ybl", 1000);
            Scanner sc = new Scanner(System.in);
            System.out.println("Deposit for 'd' / Withdraw for 'w': ");
            char choice = sc.next().charAt(0);
            switch (choice) {
                case 'd','D':
                    System.out.println("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    b.deposit(depositAmount);
                    break;
                case 'w','W':
                    System.out.println("Enter withdrawal amount: ");
                    double withdrawAmount = sc.nextDouble();
                    b.withdraw(withdrawAmount);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 'd' for deposit or 'w' for withdrawal.");
            }
        } catch (InsufficientFundException | InvalidAmountException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
    }
}
