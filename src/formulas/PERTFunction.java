package formulas;
import andrew.paulman.io.*;
import java.util.*;

public class PERTFunction
{
	
	
	public static double pERTCalc()
	{
		System.out.println("Please input your loan amount: ");
		double loanAmount = Keyboard.readDouble();
		System.out.println("Please input your APR: ");
		double interestRate = Keyboard.readDouble();
		System.out.println("Please input how long the loan is (years): ");
		double lengthOfLoan = Keyboard.readDouble();
				
		double napierNumber = 2.7183;
		
		double monthlyRate = (interestRate / 100) / 12;
		double ratePower = (interestRate / 100) * lengthOfLoan;
		
		double powerNumber = (Math.pow(napierNumber, ratePower));
		
		double totalPaid = loanAmount * powerNumber;
		double interestPaid = totalPaid - loanAmount;
		System.out.println("Your total amount paid would be: $" + totalPaid);
		System.out.println("Your total interest paid would be: $ " + interestPaid);
		
		return totalPaid;
		
		// for (amountToPay = principle, amountToPay = 0, amountToPay -= monthlyPayment )
		//monthlyPayment = amountToPay * monthlyRate
	}

	

	


}