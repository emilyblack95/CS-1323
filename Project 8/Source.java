import java.util.Random;
import java.util.Scanner;
public class Source              //Emily Black
{
	public static int didTheyWin(int randIntOne, int randIntTwo, int randIntThree)  //method if they got matching numbers
	{
		int points = 0;
		if(randIntOne == 7 && randIntTwo == 7 && randIntThree == 7)
		{
			points = 750;
		}
		else if(randIntOne == randIntTwo && randIntTwo == randIntThree && randIntThree == randIntOne) //they are all same
		{
			points = 75;
		}
		else if((randIntOne == 7 && randIntTwo == 7) || (randIntTwo == 7 && randIntThree == 7) || (randIntOne == 7 && randIntThree == 7))
		{
			
			points = 20;
		}
		else if(randIntOne == randIntTwo || randIntTwo == randIntThree || randIntThree == randIntOne)  //if two are same
		{
			
			points = 5;
		}
		else 
			{
			points = -1;
			}
		return points;
	}
	public static int basicallyDoesTheWholeProgram(String userAnswer, int totalPoints1)  //method to calculate if there are some 7s
	{
		
			if(userAnswer.equalsIgnoreCase("Yes") && totalPoints1 != 0)
			{
				Random randAgain = new Random();
				int randIntOne = randAgain.nextInt(9);
				randIntOne = randIntOne + 1;
				Random randAgain2 = new Random();
				int randIntTwo = randAgain2.nextInt(9);
				randIntTwo = randIntTwo + 1;
				Random randAgain3 = new Random();
				int randIntThree = randAgain3.nextInt(9);
				randIntThree = randIntThree + 1;
				System.out.println("Your numbers are " + randIntOne + ", " + randIntTwo + ", " + randIntThree);
				totalPoints1 = totalPoints1 + Source.didTheyWin(randIntOne, randIntTwo, randIntThree);
				System.out.println("Congrats! You have a total of " + totalPoints1 + " points!");
				return totalPoints1;
			}
			else 
			{
				 return totalPoints1 = 0;   
			}
	}

	
	
	
	public static void main(String [] args)
	{
		int totalPoints1 = 20;
		Scanner input = new Scanner(System.in);
		System.out.println("Do you want to play?");
		String userAnswer = input.nextLine();
		totalPoints1 = Source.basicallyDoesTheWholeProgram(userAnswer, totalPoints1);
		while(totalPoints1 > 0 && userAnswer.equalsIgnoreCase("Yes"))
		{
			System.out.println("You have enough points. Do you want to play again?");
			userAnswer = input.nextLine();
			totalPoints1 = Source.basicallyDoesTheWholeProgram(userAnswer, totalPoints1);
	}
	}
}
