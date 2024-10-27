package Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

//The program utilizes the Scanner class to accept user input.
//It incorporates a try-catch block to handle two types of exceptions:
//If the user enters a non-numeric value, it catches a java.util.InputMismatchException and prints an error message instructing the user to enter a valid number.
//If the user enters a negative number, it throws an IllegalArgumentException with a corresponding error message, preventing the calculation of the square root.
//The square root calculation is encapsulated in a separate method named calculateSquareRoot.
//The program uses the finally block to ensure proper closure of the Scanner object, preventing resource leaks.
//User Interaction:
//The program interacts with the user by displaying a prompt to enter a number. After the user provides input:
//If the input is a valid positive number, the program calculates and prints the square root.
//If the input is a non-numeric value, an error message is displayed.
//If the input is a negative number, an error message indicating that the square root of a negative number cannot be calculated is shown.
//Note: To enhance the program, consider allowing the user to input numbers until a valid one is provided and handling additional types of input errors.
//To find Square root:
//Math.sqrt(number);



//public class Try {
//	public static double calculateSquareRoot(int num)
//	{
//		double result= Math.sqrt(num);
//		return result;
//	}
//	public static void main(String[] args)throws IllegalArgumentException  {
//		try {
//		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter  number: ");
//		int num=sc.nextInt();
//		if(num<0)
//		{
//			throw new NagativeInputException();
//		}
//		System.out.println("output is:"+calculateSquareRoot(num));
//		}
//		catch(InputMismatchException i)
//		{
//			System.out.println("Pls enter a valid number: "+ i.getMessage());
//		}
//		catch(NagativeInputException n)
//		{
//			System.out.println("do not enter nagtive number");
//		}
//		catch(Exception e)
//		{
//			System.out.println("Completed");
//		}
//		}
//	 {
//		
//	}
//
//}




//Write a java program to find all palindrome numbers from an array?
//Class Name :- FindPalindromeArray
//Method Name:- IsPalindrome()
//Method Argument Type:- int[] arr
//Method Return Type: -Boolean
//Output –
//Enter the size of the array :– 5
//Now enter the elements of the array :– 23 98 454 101 6
//Array is :– 23 98 454 101 6
//All the Palindrome numbers in the array are :– 454 101


public class Try {
    
    public static boolean IsPalindrome(int num) {
        int reversedNum = 0;
        int originalNum = num;
        
        while (num != 0) {
            int digit = num % 10;
            reversedNum = reversedNum * 10 + digit;
            num /= 10;
        }
        
        return originalNum == reversedNum;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        
        int[] arr = new int[size];
        
        System.out.println("Now enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        
        System.out.println("Array is:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        System.out.print("All the Palindrome numbers in the array are:");
        for (int num : arr) {
            if (IsPalindrome(num)) {
                System.out.print(" " + num);
            }
        }
        
        scanner.close();
    }
}


//method name : intializeArray
//modifiers : public 
//parameters : Object[]
//return type : Object[]
//Operation : This method will recieve an Object[] type array and insert some hetrogeneous elements to the arg array.
//Note : 
//raise ArrayStoreException and handle it by providing some user friendly message.
//[Hint : From main method create one String[] object and send this as an argument to this method and store some non string literal in that array].














//You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
//
//Increment the large integer by one and return the resulting array of digits.
//
//Example 1:
//
//Input: digits = [1,2,3]
//Output: [1,2,4]
//Explanation: The array represents the integer 123.
//Incrementing by one gives 123 + 1 = 124.
//Thus, the result should be [1,2,4].
//Example 2:
//
//Input: digits = [4,3,2,1]
//Output: [4,3,2,2]
//Explanation: The array represents the integer 4321.
//Incrementing by one gives 4321 + 1 = 4322.
//Thus, the result should be [4,3,2,2].
//
//Example 3:
//
//Input: digits = [9]
//Output: [1,0]
//Explanation: The array represents the integer 9.
//Incrementing by one gives 9 + 1 = 10.
//Thus, the result should be [1,0].




//Create an Animal class with attributes name and age. Develop one parameterized constructor and a toString method. Create one Dog class as a subclass of Animal. Initialize the attributes through a parameterized constructor and provide a toString method, as well as one more method called printDogDetails.
//
//Method name: printDetails
//Modifiers: public
//Parameters: Animal
//Return type: void
//Operation: This will receive Animal as an argument and it should invoke the printDogDetails method from the Dog class.
//
//Note :
//raise ClassCastException and handle it by providing some user friendly message.
//
//SET-C
//------
//INSTRUCTIONS:
//--------------
//i)    Take BLC and ELC classes for all programs, as they are mandatory.
//ii)   Define variables, methods, constructors, and classes... etc according to naming conventions.
//iii)  These instructions apply to all programs and are mandatory.







