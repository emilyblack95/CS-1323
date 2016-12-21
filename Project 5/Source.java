import java.io.*;
import java.util.Scanner;

//Emily Black

public class Source
{

	public static String chooseRandomWordFromDictionary() throws FileNotFoundException
	{
		Scanner dictionary;  
		int wordsInDictionary; 
		int randomCount; 
		// randomly pick a word from the dictionary
		dictionary = new Scanner(new File("dictionary.txt"));

		// The format of the dictionary file is the number of words in the dictionary, followed
		// by the words, one to a line
		wordsInDictionary = dictionary.nextInt(); // Get the number of words out of the file.
		dictionary.nextLine(); // remove the end of line after the integer number of words
		randomCount = (int)(Math.random() * wordsInDictionary);

		// Skip over the randomly chosen number of lines
		int i=0;
		while (i<randomCount)
		{
			dictionary.nextLine(); // skip a word
			++i;
		}
		// The chosen word is on the next line
		String chosenWord = dictionary.nextLine();
		
		// mix up the letters randomly
		StringBuilder tempWord = new StringBuilder(chosenWord);
		StringBuilder scrambledTempWord = new StringBuilder();
		return chosenWord;
		
}
	
	public static String thisScramblesLetters(String chosenWord) throws FileNotFoundException
	{		
		// mix up the letters randomly
					StringBuilder tempWord = new StringBuilder(chosenWord);
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
	public static boolean letsTheUserGuess(String scrambledWord, String chosenWord) throws FileNotFoundException
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
						if (guessedWord.equals(chosenWord))
							guesses = TRIES; // stop the loop
					}
					boolean won = (guessedWord.equals(chosenWord));
					return won;
	}
	
	
	
	
	public static void main(String[] args) throws FileNotFoundException
	{
		String repeatPlay="yes"; // Used at the end of the loop to determine if the game should be played again
		int wins = 0;
		int losses = 0;
		while(repeatPlay.equalsIgnoreCase("yes"))
		{
		String chosenWord = chooseRandomWordFromDictionary();
		String scrambledWord = thisScramblesLetters(chosenWord);
		boolean won = letsTheUserGuess(scrambledWord, chosenWord);
		
		Scanner keyboard = new Scanner(System.in);
		//If they didn't succeed, tell them the word, otherwise congratulate them
			if (won)
			{
				System.out.println("Congratulations!  You guessed the word correctly!");
				++wins;
			}
			else
			{
				System.out.println("I'm sorry but you lost.  The word was: " + chosenWord);
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
