package formulas;
import andrew.paulman.io.*;
import java.util.ArrayList;

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
		
		double lengthOfLoanMonths = lengthOfLoan * 12;
		double monthlyRate = (interestRate / 100) / 12;
		double ratePower = (interestRate / 100) * lengthOfLoan;
		
		double powerNumber = (Math.pow(napierNumber, ratePower));
		
		double totalPaid = loanAmount * powerNumber;
		double interestPaid = totalPaid - loanAmount;
		System.out.println("Your total amount paid would be: $" + totalPaid);
		System.out.println("Your total interest paid would be: $ " + interestPaid);

		
		double paymentVariable = (1+monthlyRate);
		double monthlyPaymentVariable = Math.pow(paymentVariable, lengthOfLoanMonths);
		double monthlyPayment = loanAmount * ((monthlyRate * monthlyPaymentVariable) / (monthlyPaymentVariable - 1));
		System.out.println("Your monthly payment would be: " + monthlyPayment);
		
		
		double firstMonthInterestPayment = monthlyPayment - (loanAmount * monthlyRate);
		double principlePayment = monthlyPayment - firstMonthInterestPayment;
		
	
		while (loanAmount >= 0)
		{
			principlePayment = 0;
			double newLoanAmount = loanAmount - principlePayment;
			double interestPayment = newLoanAmount * monthlyRate;
			principlePayment = monthlyPayment - interestPayment;
			loanAmount = newLoanAmount - principlePayment;
			
			ArrayList <Double> amortizationTable = new ArrayList <Double> ();
			amortizationTable.add(newLoanAmount);
			amortizationTable.add(monthlyPayment);
			amortizationTable.add(principlePayment);
			amortizationTable.add(interestPayment);
			
			System.out.println(amortizationTable);
		
		}
		
		
		return totalPaid;
	}

	

	


}