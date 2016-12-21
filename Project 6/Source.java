import java.util.Scanner;  //imports scanner
public class Source    //Emily Black
{
	public static void noun1(String firstNoun, String pluralNoun)       //first line method
	{
		System.out.println("Be kind to your " + firstNoun + "-footed " + pluralNoun);
	}
	public static void anotherNoun(String thisNoun)        //second line method
	{
		System.out.println("For a duck may be somebody`s " + thisNoun + ",");
	}
	public static void aPlace(String pluralNoun, String location)   //third line method
	{
		System.out.println("Be kind to your " + pluralNoun + " in " + location);   //uses same pluralNoun as first method
	}
	public static void anAdjective(String thisAdjective)       //forth line method
	{
		System.out.println("Where the weather is always " + thisAdjective + ".");
	}
	public static void lastNoun(String finalNoun)           //fifth line method
	{
		System.out.println("You may think that this is the " + finalNoun + ",");
		System.out.println("Well it is.");
	}
	public static void main(String [] args)          //starts program
	{
	Scanner input = new Scanner(System.in);
	System.out.println("Enter a noun.");
	String a = input.next();
	System.out.println("Enter a plural noun.");
	String b = input.next();
	System.out.println("Enter another noun.");
	String d = input.next();
	System.out.println("Enter a place.");
	String e = input.next();
	System.out.println("Enter an adjective.");                 //abcdefg = all references to the parameters above
	String f = input.next();
	System.out.println("Enter a noun.");
	String g = input.next();
	Source.noun1(a, b);
	Source.anotherNoun(d);                      //calls all the methods about public static void main
	Source.aPlace(b, e);
	Source.anAdjective(f);
	Source.lastNoun(g);
	
	}
}
