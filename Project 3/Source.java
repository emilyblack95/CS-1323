// Emily Black
import java.util.Scanner;   //equals, equalsIgnoreCase, ==,
public class Source 
{
	public static void main(String [] args)
	{
		
		Scanner input = new Scanner(System.in);
		int count = 0;
		int stressed = 0;
		int stressed2 = 0;
		int stressed3 = 0;
		int stressed4 = 0;
		String yes = new String("yes");
		String no = new String("no");
		String mainQuestion = new String("yes");
		while(mainQuestion.equalsIgnoreCase(yes))   //this starts and repeats quiz
		{
		int points = 0;
		System.out.println("Do you feel trapped?");   //first question
		String question1 = input.nextLine();
		if(question1.equalsIgnoreCase(yes))
		{
			points = points + 1;
			count = count + 1;
		}
		else if(question1.equalsIgnoreCase(no))
		{
			count = count + 1;
		}
		System.out.println("Do you feel tired most of the time?");  //second question
		String question2 = input.nextLine();
		if(question2.equalsIgnoreCase(yes))
		{
			points = points + 1;
			count = count + 1;
		}
		else if(question2.equalsIgnoreCase(no))
		{
			count = count + 1;
		}
		System.out.println("Are you losing your sense of humor?");  //third question
		String question3 = input.nextLine();
		if(question3.equalsIgnoreCase(yes))
		{
			points = points + 1;
			count = count + 1;
		}
		else if(question3.equalsIgnoreCase(no))
		{
			count = count + 1;
		}
		
		if(points == 3)
		{
			System.out.println("You are completely stressed out.");
			stressed += 1;
		}
		else if(points == 2)
		{
			System.out.println("You are moderately stressed out.");
			stressed2 += 1;
		}
		else if(points == 1)
		{
			System.out.println("You are slightly stressed");
			stressed3 += 1;
		}
		else
		{
			System.out.println("You are not stressed at all");
			stressed4 += 1;
		}
		System.out.println("Would you like to run the stress test again?");
		mainQuestion = input.nextLine();
		}
		System.out.println(stressed + " of your friends are completely stressed");
		System.out.println(stressed2 + " of your friends are moderately stressed");
		System.out.println(stressed3 + " of your friends are slightly stressed");
		System.out.println(stressed4 + " of your friends are not stressed at all");
	}
	}

