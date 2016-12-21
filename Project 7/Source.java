import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
//Emily Black

public class Source
{

	public static ArrayList<String> fillTheArray()  throws FileNotFoundException
	{
		ArrayList<String> listOfWords = new ArrayList<String>();  
		Scanner dictionary = new Scanner(new File("dictionary.txt"));
		int count = 0;
		String wordsInList;
		while(dictionary.hasNextLine())             //this reads dictionary and adds words into dictionary
		{
			wordsInList = dictionary.nextLine();
			listOfWords.add(count, wordsInList);
			count++;
		}
		return(listOfWords);
	}
	
	public static String chooseRandomWordFromDictionary(ArrayList<String> listOfWords, Random randPick) throws FileNotFoundException
	{
		int count = listOfWords.size();
		int randInt = randPick.nextInt(count);                //This takes the size of the array and picks a random element
		String pickedWord = listOfWords.get(randInt);
		return pickedWord;
}
	
	public static String thisScramblesLetters(String pickedWord) throws FileNotFoundException
	{		
		// mix up the letters randomly
					StringBuilder tempWord = new StringBuilder(pickedWord);
					StringBuilder scrambledTempWord = new StringBuilder();
					
					// Repeatedly choose a letter to remove from the current word, and put these randomly
					// chosen letters in order in a new word.  This uses the StringBuilder class, which is like String
					// but has different methods--including delete and append which are useful here
					while (tempWord.length() > 0)
					{
						int letterNumber = (int) (Math.random()*tempWord.length());
						char nextLetter = tempWord.charAt(letterNumber);
						tempWord.deleteCharAt(letterNumber);
						scrambledTempWord.append(nextLetter);
					}
					String scrambledWord = scrambledTempWord.toString();
					return scrambledWord;
	}	
	
	// Give the  user 3 chances to guess the word
	public static boolean letsTheUserGuess(String scrambledWord, String pickedWord) throws FileNotFoundException
	{
		Scanner keyboard = new Scanner(System.in);
		final int TRIES = 3; // the number of guesses a user is allowed
		// Give the  user 3 chances to guess the word
					int guesses = 0;
					String guessedWord="";  // keep the compiler happy
					while (guesses < TRIES)
					{
						System.out.println("The scrambled word is " + scrambledWord);
						System.out.println("What is your guess?");
						guessedWord = keyboard.nextLine();
						guessedWord = guessedWord.toLowerCase();
						++guesses;
						if (guessedWord.equals(pickedWord))
							guesses = TRIES; // stop the loop
					}
					boolean won = (guessedWord.equals(pickedWord));
					return won;
	}
	
	
	
	
	public static void main(String[] args) throws FileNotFoundException
	{
		ArrayList<String> listOfWords = fillTheArray();
		Random randPick = new Random();
		String repeatPlay="yes"; // Used at the end of the loop to determine if the game should be played again
		int wins = 0;
		int losses = 0;
		while(repeatPlay.equalsIgnoreCase("yes"))
		{
		String pickedWord = chooseRandomWordFromDictionary(listOfWords, randPick);
		String scrambledWord = thisScramblesLetters(pickedWord);
		boolean won = letsTheUserGuess(scrambledWord, pickedWord);
		
		Scanner keyboard = new Scanner(System.in);
		//If they didn't succeed, tell them the word, otherwise congratulate them
			if (won)
			{
				System.out.println("Congratulations!  You guessed the word correctly!");
				++wins;
			}
			else
			{
				System.out.println("I'm sorry but you lost.  The word was: " + pickedWord);
				++losses;
			}
			
			// Report the number of wins and losses
			System.out.println("You have won " + wins + " times.");
			System.out.println("You have lost " + losses + " times.");
		
			// Let them choose to play again
			System.out.println("Do you want to play again? Yes or no");
			repeatPlay = keyboard.nextLine();
		}		
	}

	private static void randomDictWord() {
		// TODO Auto-generated method stub
		
	}

}
