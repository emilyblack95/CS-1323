import java.util.Arrays;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
public class Source  //Emily Black
{
	
	public static String[] fillGlobalArray() throws FileNotFoundException  //global dictionary
	{
		Scanner input = new Scanner(new File("dictionary"));
		int count = 0;
		while(input.hasNextLine())
		{
			input.nextLine();
			++count;
		}
		input.close();
		String[] spellChecker = new String[count];
		input = new Scanner(new File("dictionary"));
		for(int i = 0; input.hasNext() && i < spellChecker.length; ++i)
		{
			spellChecker[i] = input.nextLine();
		}
		input.close();
		return spellChecker;
		
	}
	public static int fillPersonalArray(String[] personalArray) throws FileNotFoundException  //personal dictionary
	{
		int count = 0;
		Scanner input = new Scanner(new File("personalDictionary"));
		for(int i = 0; input.hasNextLine() && i < personalArray.length; ++i)
		{
			personalArray[i] = input.nextLine();
			++count;
		}
		input.close();
		return count;
		
	}
	public static int addsToOneDictionary(String [] global, String[] personal, String wordEntered, Scanner input, int size) throws FileNotFoundException
	{
		if(Arrays.binarySearch(global, wordEntered) >= 0) 
		{
			System.out.println("You spelled it correctly!");
		}
		else if(Arrays.binarySearch(global, 0, global.length-1, wordEntered) < 0) //if it returns -1
		{
			System.out.println("You spelled it wrong!");
			System.out.println("Would you like to enter it into personal dictionary?");
			String answer = input.nextLine();
			if(answer.equalsIgnoreCase("yes"))
			{
				personal[size] = wordEntered;
				++size;
				Arrays.sort(personal, 0, size); 
			}
		}
		return size;
	}
	public static void createNewFile(String[] source, int size) throws FileNotFoundException  //creates new file
	{
		PrintWriter personal = new PrintWriter(new File("personalDictionary"));
		for(int i = 0; i < size; ++i)
		{
			personal.write(source[i] + '\n');
		}
		personal.close();
	}
	public static void main(String [] args) throws FileNotFoundException  //only add 1 scanner and pass as parameter
	{
		final int OVERSIZED_ARRAY = 500;
		String[] personal = new String[OVERSIZED_ARRAY];
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a word to spell check, or enter QUIT to stop");
		String x = input.nextLine();
		int size = Source.fillPersonalArray(personal);
		String[] global = Source.fillGlobalArray();
		while(!(x.equalsIgnoreCase("quit")))    //priming read
		{
			size = Source.addsToOneDictionary(global, personal, x, input, size);
			System.out.println("Enter a word to spell check, or enter QUIT to stop");  
			x = input.nextLine();
		}
		Source.createNewFile(personal, size);
		input.close();
	}
	
}
