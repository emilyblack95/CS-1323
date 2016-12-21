import java.util.Scanner;
public class Source       //Emily Black
{
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		final int randomNumber = (int)(Math.random() * 1000) + 1; // generates the random number between 1 and 1000
		int high = 1000;
		int low = 1;
		int guessBinary = 0;
		int mid = 500;
		while (mid != randomNumber)          //computer does this, binary search
				{
					guessBinary++;
					if (mid > randomNumber)
					{
						high = mid - 1;
					}
					else
					{
						low = mid + 1;
					}
					mid = (high + low) / 2;
				}
				System.out.println("It took the computer " + guessBinary + " guesses!");
				System.out.println("Enter a whole number between 1-1000. Try to guess my number."); // asks the user to guess a number
				int guessUser = 0;
				while(input.hasNextInt())
				{
					guessUser++;
					int randGuess = input.nextInt();
					if(randGuess > randomNumber)
					{
						System.out.println("TOO HIGH"); // prints out, user is too high
					}
					else if(randGuess < randomNumber)
					{
						System.out.println("TOO LOW");       //user is too low
					}
					else
					{
						System.out.println("CORRECT");    //user is correct
						System.out.println("You guessed a total of " + guessUser + " times! Your score is " + (10 - guessUser));
					}
				}
				
	}
}
