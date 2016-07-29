package formulas;
import andrew.paulman.io.*;
import java.util.ArrayList;

public class PERTFunction
{
	
	
	public static double pERTCalc()
	{
		/*Asks user for details on loan*/
		
		System.out.println("Please input your loan amount: ");
		double loanAmount = Keyboard.readDouble();
		System.out.println("Please input your APR: ");
		double interestRate = Keyboard.readDouble();
		System.out.println("Please input how long the loan is (years): ");
		double lengthOfLoan = Keyboard.readDouble();
			
		double lengthOfLoanMonths = getLengthOfLoanInMonths (lengthOfLoan);
		double monthlyRate = getMonthlyRate (interestRate);
		double totalPaid = getTotalPaid (loanAmount, interestRate, lengthOfLoan);
		double interestPaid = getInterestPaid(totalPaid , loanAmount);
		double monthlyPayment = getMonthlyPayment (loanAmount, monthlyRate, lengthOfLoanMonths);
		double firstMonthInterestPayment = getfirstMonthInterestPayment (monthlyPayment, loanAmount, monthlyRate);
		double principlePayment = getPrinciplePayment (monthlyPayment, firstMonthInterestPayment); 
		
		
		System.out.printf("Your total amount paid would be: $%.2f %n", totalPaid);
		System.out.printf("Your total interest paid would be: $%.2f %n", interestPaid);
		System.out.printf("Your monthly payment would be: $%.2f %n", monthlyPayment);
		System.out.println("");
		System.out.println("Would You Like To See Your Amortization Table? (Yes or No)");
		
		ArrayList <String> validResponses = new ArrayList<String> ();
		validResponses.add("y");
		validResponses.add("n");
		String warning = "This Is An Invalid Key. Please Try Again.";
		String amortizationTableQuestion = getValidKeyTyped (warning, validResponses);
		if (amortizationTableQuestion.equals("y"))
		{
			System.out.println("Here You Go!");
			//place headers here
			while (loanAmount >= 0)
			{
				principlePayment = 0;
				double newLoanAmount = loanAmount - principlePayment;
				double interestPayment = newLoanAmount * monthlyRate;
				principlePayment = monthlyPayment - interestPayment;
				loanAmount = newLoanAmount - principlePayment;
				
				
				System.out.printf("%10.2f %10.2f %10.2f %10.2f %n", newLoanAmount, monthlyPayment, principlePayment, interestPayment);
				
				/*ArrayList <Double> amortizationTable = new ArrayList <Double> ();
				amortizationTable.add(newLoanAmount);
				amortizationTable.add(monthlyPayment);
				amortizationTable.add(principlePayment);
				amortizationTable.add(interestPayment);
				System.out.println(amortizationTable);
				*/
				
				
			
			}	
		}
		return totalPaid;
	}
	
	
	//where functions go
	
	private static double getMonthlyRate (double interestRate)
	{
		double monthlyRate = (interestRate / 100) / 12;
		return monthlyRate;
	}
	
	private static double getLengthOfLoanInMonths (double lengthOfLoan)
	{
		double loanLength = lengthOfLoan * 12;
		return loanLength;
	}
	
	private static double getPrinciplePayment (double monthlyPayment, double interestPayment)
	{
		double principlePayment = monthlyPayment - interestPayment;
		return principlePayment;
	}
	
	private static double getfirstMonthInterestPayment (double monthlyPayment, double loanAmount, double monthlyRate)
	{
		double interestPayment = monthlyPayment - (loanAmount * monthlyRate);
		return interestPayment;
	}
	
	private static double getInterestPaid (double totalPaid, double loanAmount)
	{
		double interestPaid = totalPaid - loanAmount;
		return interestPaid;
	}
	
	private static double getTotalPaid (double loanAmount, double interestRate, double lengthOfLoan)
	{
		double ratePower = (interestRate / 100) * lengthOfLoan;
		double napierNumber = 2.7183;
		
		double powerNumber = (Math.pow(napierNumber, ratePower));
		double totalPaid = loanAmount * powerNumber;
		
		return totalPaid;
	}
	
	private static double getMonthlyPayment (double loanAmount, double monthlyRate, double lengthOfLoanMonths)
	{
		double paymentVariable = (1+monthlyRate);
		double monthlyPaymentVariable = Math.pow(paymentVariable, lengthOfLoanMonths);
		
		double monthlyPayment = loanAmount * ((monthlyRate * monthlyPaymentVariable) / (monthlyPaymentVariable - 1));
		return monthlyPayment;
	}
	
	private static String getValidKeyTyped (String warning, ArrayList<String> validResponses)
	{
		boolean isValidReponse = false;
		String validkey = "";
		while (isValidReponse == false)
		{
			String userInput = Keyboard.readString();
			if (isValidKeyTyped (userInput, validResponses))
			{
				userInput.equals(validResponses);
				isValidReponse = true;
			}
			else 
			{
				System.out.println(warning);
			}
		return userInput.substring(0,1).toLowerCase();	
		}
		return validkey;
	}
	
	private static boolean isValidKeyTyped (String userInput, ArrayList <String> validResponses)
	{
		boolean isValidKey = false;
		for (String validResponse: validResponses)		
		{
			if (validResponse.equals(userInput.substring(0,1)))
			{
				isValidKey = true;
				break;
			}
		}
		return isValidKey;
	}	
	

}