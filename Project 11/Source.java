import java.util.Scanner;
import java.util.Arrays;
//AUTHOR: EMILY BLACK!
public class Source 
{
		public static final int ADD = 1;
		public static final int SEARCH = 2;
		public static final int QUIT = 3;
		public static void main(String [] args)
		{
			final int EMAIL_LIST_CAPACITY = 1000; //oversized
			String[] source = new String[EMAIL_LIST_CAPACITY];
			Scanner input = new Scanner(System.in);
			int sizeOfArray = 0;
			while(true)
			{
				System.out.println("1. Enter a new email address.");
				System.out.println("2. Find an existing email address.");
				System.out.println("3. Quit");
				System.out.println("What is your choice?");
				int answer = input.nextInt();
				input.nextLine();
				if(answer == QUIT)
				{
					System.out.println("Goodbye!");
					input.close();
					return;
				}
				else 
				{
					sizeOfArray = Source.Interface(answer, source, input, sizeOfArray);
				}
			}
		}
		public static int fillOversizedArray(String [] source, Scanner input, int sizeOfArray) //keeps track of size, NOT CAPACITY
		{
			System.out.println("Enter the email address");
			String email = input.nextLine();
			if(sizeOfArray == 0) 
			{
				source[sizeOfArray] = email;
				System.out.println("Insertion successful!");
				++sizeOfArray;
				return sizeOfArray;
			}
			else if(sizeOfArray > 0) //if they already entered another email
			{
				for(int i = 0; i < sizeOfArray; ++i)
				{
					int x = email.compareTo(source[i]);
					if(x == 0) //returns 0 if same string
					{
						source[sizeOfArray] = null;
						System.out.println("That email address is already inserted!");
						return sizeOfArray;
					}
				}
				source[sizeOfArray] = email;
				System.out.println("Insertion successful!");
				++sizeOfArray;
			}
			return sizeOfArray;
		}
		
		public static int Interface(int answer, String[] source, Scanner input, int sizeOfArray) //runs main program, calls other methods
		{
			if(answer == SEARCH)
			{
				System.out.println("Enter the first letter");
				String firstLetter = input.next(); 
				String[] similarList = Source.searchForSimilars(source, sizeOfArray, firstLetter);
				String anotherTarget = null;
				int sizeOfSL = similarList.length;
				while(similarList.length > 1) //if it has 2 or more similar emails
				{
					System.out.println("The possible choices are: " + Arrays.toString(similarList)); //prints out emails of firstLetter
					System.out.println("Enter another letter");
					anotherTarget = input.next();
					anotherTarget = firstLetter + anotherTarget;
					sizeOfSL = similarList.length;
					similarList = Source.searchForSimilars(similarList, sizeOfSL, anotherTarget);
				}
				if(similarList.length == 1) //if it has 1 email
				{
					System.out.println("Found this email address: " + "[" + similarList[0] + "]");
				}
				else
				{
					System.out.println("Sorry no such email exist!");
				}
				return sizeOfArray;
			}
			else if(answer == ADD)
			{
				sizeOfArray = Source.fillOversizedArray(source, input, sizeOfArray);
				Source.sort(source, sizeOfArray);
			}
			return sizeOfArray;
	}
		public static String[] searchForSimilars(String[] source, int arraySize, String letter)  //searches for target
		{
			int counter = 0;
			
			for(int i = 0; i < arraySize; ++i)  //go through array and add those emails
			{
				if(source[i].startsWith(letter)) //add the similar email to array
				{
					++counter;
				}
			}
			String[] listOfSimilars = new String[counter];
			counter = 0;
			for(int i = 0; i < arraySize; ++i)  //go through array and add those emails
			{
				if(source[i].startsWith(letter)) //add the similar email to array
				{
					listOfSimilars[counter] = source[i];
					++counter;
				}
			}
			return listOfSimilars;
		}
		public static void sort(String[] source, int sizeOfArray)   //sorts array of emails
		{
				int swapMe;
				int index = sizeOfArray-1;
				String temp = source[index];
				for(swapMe = sizeOfArray-2; swapMe >= 0 && source[swapMe].compareTo(temp) > 0; --swapMe)
				{
					source[swapMe + 1] = source[swapMe];
					--index;
				}
				source[swapMe+1] = temp;
		}
}
