import java.util.Scanner;

/**
 * This class is a menu that allows user to make choices.
 * 
 * 
 * @author gpupe
 * @version 10/28/2019
 */

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Menu mainmenu = new Menu();
		mainmenu.processUserChoices();

	}
	
	// Method that displays menu options
	public void displayMenu()
	{
		System.out.println("Please select one of the options below");
		System.out.println("1. Convert student's percentage mark into a letter grade");
		System.out.println("2. Provide lower and upper bounds to display a table");
		System.out.println("3. Provide statistics about the numbers you input");
		System.out.println("4. Convert student's percentage mark into a letter grade v2");
		System.out.println("0. Exit");
	}
	
	
	//Method for processing User's choices
	public void processUserChoices()
	{
		// Variable to hold user's input
		String usersChoice;
		Scanner s = new Scanner(System.in);
		
		
		// Loop to keep the user selecting menu options until the exit option is chosen
		do
		{
			
		displayMenu();
		//User's input is compared and the selected choice is executed. 
		usersChoice = s.nextLine();
		
		
		//Choice 1 - Converts user's percentage mark into a letter grade
		if (usersChoice.equals("1"))
		{
			int percentage = 0;
			System.out.println("Please enter student's percentage mark: ");
			Scanner s1 = new Scanner (System.in);
			
			// Variable to check for input errors
			boolean inputIsCorrect=false;
			
			// Reading user's input
			while (!inputIsCorrect)
			{
				if(!(s1.hasNextInt()))
				{	
					// Checks if input is an integer
					System.out.println("Please enter an integer.");
					s1.next();
				}
				else if (s1.hasNextInt())
					{
						percentage = s1.nextInt();
						if(percentage > 100 || percentage < 0)
						{
							// Checks if input is within the limits
							System.out.println("Please enter a value between 0 and 100.");
							s1.nextLine();
						}
						
						//If input is correct, the loop stops
						else inputIsCorrect = true;

					}
			
			}

			// User's input is sent to the corresponding public method in Choice class
			System.out.println("The grade letter is: " + Choice.convertResultIntoLetterGrade(percentage));
			
		}
		
		// Choice 2 - calculates a table by using the lower and upper bounds the user provides
		else if(usersChoice.equals("2"))
		{
			int lower = 0, upper = 0;
			System.out.println("Please enter the lower bound for the table: ");
			Scanner s2 = new Scanner (System.in);
			

			boolean inputIsCorrect=false;
			
			// Reads the input for lower limit
			while (!inputIsCorrect)
			{
				if(!(s2.hasNextInt()))
				{	
					// Checks if input is an integer
					System.out.println("Please enter an integer.");
					s2.next();
				}
				else if (s2.hasNextInt())
					{
						lower = s2.nextInt();
						if(lower <= 0)
						{
							// Checks if input is within the limits
							System.out.println("Please enter a value greater than 0.");
							s2.nextLine();
						}
						else inputIsCorrect = true;

					}
			
			}
			

			System.out.println("Please enter the upper bound for the table: ");
			
			//User's input for the upper bound is read			
			
			inputIsCorrect = false;
			while (!inputIsCorrect)
			{
				if(!(s2.hasNextInt()))
				{	
					// Checks if input is an integer
					System.out.println("Please enter an integer.");
					s2.next();
				}
				else if (s2.hasNextInt())
					{
						upper = s2.nextInt();
						if(upper < lower)
						{
							// Checks if input is within the limits
							System.out.println("Please enter a value greater than the lower limit.");
							s2.nextLine();
						}
						else inputIsCorrect = true;

					}
			
			}
			
			// The appropriate public method from Choice class is called
			Choice.calculateTable(lower,upper);
		}
		
		//Choice 3 - provides statistics about the numbers the user inputs
		else if (usersChoice.equals("3"))
		{
			// Calls the appropriate method from Choice class
			Choice.calculateStatisticsOfNumbers();
		}
		
		
		//Choice 4 - an updated choice 1 method with a do while loop
		//Converts a percentage mark into a letter grade
		else if (usersChoice.equals("4"))
		{
			Choice.convertGrade();
			
		}
		
		
		else if(usersChoice.equals("0"))
		{	
			//Calls the exit method from Choice class
			Choice.exit();
		}
		
		
		else 
		{
			//In case the user enters an invalid number, an error message is displayed
			System.out.println("An invalid option was selected.");
		}
		} while (!usersChoice.equals("0"));
		
	}

}
