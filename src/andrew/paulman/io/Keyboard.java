package andrew.paulman.io;

import java.util.Scanner;

public class Keyboard
{

	public static int readInt()
	{
		Scanner keyboard = new Scanner(System.in);
		boolean hasGivenNonInt = false;
		String temp;
		do
		{
			if (hasGivenNonInt)
			{
				System.out.println("That is not an integer. Try again.");
			}
			temp = keyboard.nextLine();
			hasGivenNonInt = true;
		}
		while (!isNumeric(temp));
		int number = Integer.parseInt(temp);
		return number;
	}

	public static double readDouble()
	{
		Scanner keyboard = new Scanner(System.in);
		return keyboard.nextDouble();
	}

	public static String readString()
	{
		Scanner keyboard = new Scanner(System.in);
		return keyboard.nextLine();
	}

	private static boolean isNumeric(String str)
	{
		for (char c : str.toCharArray())
		{
			if (!Character.isDigit(c))
			{
				return false;
			}
		}

		return true;
	}
}
