import java.util.Scanner;

/**
 * This class holds methods for the choices user can choose from the Menu class.
 * 
 * 
 * @author gpupe
 * @version 10/28/2019
 */
public class Choice {

	
	// Method to convert percentage mark into a letter grade
	public static char convertResultIntoLetterGrade(int percentage)
	{

		char result = 0;
		
		// Provided user input is compared until the corresponding letter is found
		if(percentage > 69) result = 'A';
		else if (percentage > 59) result = 'B';
		else if (percentage > 49) result = 'C';
		else if (percentage > 39) result = 'D';
		else if (percentage < 40) result = 'E';
		
		return result;
	}
	
	// Method to calculate a table using provided user input of lower and upper bounds in a for loop
	public static void calculateTable(int lower, int upper)
	{
		System.out.println("Value	Square	Cube	Square Root");
		
		for(int i=lower; i<=upper; i++)
		{
			System.out.println(i+"	"+i*i+"	"+i*i*i+"	"+ Math.sqrt(i));
		}
		
	}
	
	//Method to calculate the statistics of provided numbers using while loop
	public static void calculateStatisticsOfNumbers()
	{
		//Local variables to hold statistics
		double total = 0, average = 0, minimum = 0, maximum = 0;
		
		Scanner s3 = new Scanner(System.in);
		double number = 0;
		
		int i=1;
		while(i>=1)
		{
			System.out.println("Enter a number, or enter -1 to stop:");
			
			// Checks if the entered number is a double type
			while(!(s3.hasNextDouble()))
			{
				System.out.println ("Enter a valid number");
				s3.next();
			}
			number = s3.nextDouble();
			
			// If the user inputs -1, the loop stops
			if (number == -1) break;
			
			// After each number is entered, statistics are recalculated 
			
			//Calculates total
			total= total + number;
			
			//Calculates the average
			average= total/i;
			
			//Finds the minimum number
			//If it's the first entered number, it's assigned to be the minimum number
			if(i==1) minimum = number;
			else if(minimum > number) minimum = number;
			
			//Finds the maximum number
			//If it's the first entered number, it's assigned to be the maximum number
			if(i==1) maximum = number;
			else if(maximum < number) maximum = number;
			
			i++;
			
		}
		
		// After the loop is stopped, the results are displayed
		System.out.println("The total of all entered numbers: " + total);
		System.out.println("The average of all entered numbers: " + average);
		System.out.println("The minimum number is: " + minimum);
		System.out.println("The maximum number is: " + maximum);

	}
	
	// Method to read user's input and convert percentage grade to a letter grade
	public static void convertGrade()
	{
		Scanner s4 = new Scanner(System.in);
		int percentage = 0;
		
		int attempts = 1;
		do
		{
			System.out.println ("Enter the percentage mark you wish to convert, or enter -1 to terminate:");
			
			//System checks if the input is an integer and displays an error message if not
			while(!(s4.hasNextInt()))
			{
				System.out.println("Only integers are allowed.");
				s4.next();
				
				//If user makes 3 incorrect attempts, the process is stopped. 
				attempts ++;
				if(attempts > 3) break;
			}
			
			if(attempts > 3) break;
			
			
			percentage = s4.nextInt();
			
			// If input is -1, the loop is stopped
			if(percentage == -1) break;
			
			//If input is not within limits, user is given a warning
			if(percentage < 0 || percentage > 100) 
				{
					attempts++;
					if(attempts > 3) break;
					System.out.println("Please enter a value from 0 to 100");
				}

			
		} while (percentage < 0 || percentage > 100);
		
		if (attempts > 3) System.out.println ("You have entered the wrong value 3 times. Please try again later.");
		else if (percentage == -1) System.out.println("Option cancelled.");
		// If the right value is given, the input is sent to the method 1 of Choice class
		else System.out.println("The grade letter is: " + Choice.convertResultIntoLetterGrade(percentage));
	}
	public static void exit()
	{
		System.out.println("Goodbye");
	}
	
}
