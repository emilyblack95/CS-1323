// Emily
import java.util.Scanner;
public class Source 
{
public static void main(String [] args)
{
	Scanner bookReader = new Scanner(System.in); 
	System.out.println("How many copies of Design Patterns?");
	int firstBook = bookReader.nextInt();
	double priceOfFirstBook = (firstBook*32.46);
	System.out.println("How many copies of Effective Java by Bloch?");
	int secondBook = bookReader.nextInt();
	double priceOfSecondBook = (secondBook*35.48);
	System.out.println("How many copies of Java Puzzlers?");
	int thirdBook = bookReader.nextInt();
	double priceOfThirdBook = (thirdBook*27.86);
	double total = (priceOfFirstBook + priceOfSecondBook + priceOfThirdBook); //adds up all of the books and multiplies them by their prices
	System.out.println("The total is $" + total); //prints out the total
}
}
