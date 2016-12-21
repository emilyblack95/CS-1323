import java.util.Scanner;
import java.io.FileNotFoundException;

/** A simple user interface for an e-commerce site.
 * 
 * @author Deborah A. Trytten
 * @version 1.0
 *
 */
public class Driver 
{
	// If the order of these constants is changed the program will break
	private static final int SELL = 1;
	private static final int RESTOCK = 2;
	private static final int INVENTORY = 3;
	private static final int QUIT = 4;
	private static final String FILE_NAME = "Inventory.txt";
	private static Inventory inventory;
	
	/** Run the user interface.  Inventory is read from a file called "Inventory.csv" that is 
	 * stored in the project home directory.  The user is then asked to buy and restock items on the
	 * site. Inventory can also be seen.  When the user quits the program, the inventory will be saved
	 * to the same CSV file.
	 * @param args This program takes no command line arguments.
	 * @throws FileNotFoundException If the inventory file is not found in the project home directory.
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		inventory = new Inventory(FILE_NAME);
		Scanner input = new Scanner(System.in);
		boolean keepRunning = true;
		int answer = menuAndResponse(input);
		while(keepRunning == true)
		{
			if(answer == 3)
			{
				Driver.showInventory();
				answer = menuAndResponse(input);
			}
			else if(answer == 2)
			{
				restock(input);
				answer = menuAndResponse(input);
			}
			else if(answer == 1)
			{
				sell(input);
				answer = menuAndResponse(input);
			}
			else
			{
				keepRunning = false;
			}
		}
		input.close();
		
	}
	
	/** The user interface to sell products.
	 * 
	 * @param input A scanner connected to the keyboard.
	 */
	public static void sell(Scanner input)
	{
		System.out.println("Enter the name of the product purchased");
		String name = input.nextLine();
		
		int stock = inventory.getStock(name);
		if (stock> 0)
		{
			System.out.println("We have " + stock + " in stock. How many would you like?");
			int quantity = input.nextInt();
			input.nextLine(); // get rid of newline
			
			if (quantity < stock)
			{
				inventory.sellItem(name,  quantity);
				return;
			}
			else
			{
				System.out.println("I'm sorry, but we don't have that many in stock.  I'll see you all we have.");
				inventory.sellItem(name, stock);
				return;
			}
		}
		else
		{
			System.out.println("I'm sorry, but we don't have that item in stock.");
		}
				
	}
	
	/** The user interface to restock products.
	 * 
	 * @param input A scanner connected to the keyboard.
	 */
	public static void restock(Scanner input)
	{
		System.out.println("What do you want to restock?");
		String name = input.nextLine();
		System.out.println("How much do you want to restock of " + name + "?");
		int inputQuantity = input.nextInt();
		inventory.restockItem(name, inputQuantity);
	}
	
	/** The user interface to show inventory of all items.
	 * 
	 */
	public static void showInventory()
	{
		System.out.println(inventory); // call the toString method
	}
	
	/** Show the menu to the user and let them make a legal choice.
	 * 
	 * @param input A scanner connected to the keyboard.
	 * @return The menu choice.
	 */
	public static int menuAndResponse(Scanner input)
	{
		System.out.println("Please choose one option");
		System.out.println(SELL + ". Sell an item to a customer.");
		System.out.println(RESTOCK + ". Restock an item.");
		System.out.println(INVENTORY + ". List items in inventory");
		System.out.println(QUIT + ". Exit the program.");
		
		int in = input.nextInt();
		input.nextLine(); // remove the newline
		
		if (in >= SELL && in <= QUIT)
			return in;
		
		System.out.println("That is not a valid input");
		return menuAndResponse(input); // this is really cool technique called recursion
		// just thought you'd like some intellectual entertainment
		// This can also be done with a loop, but it isn't nearly as cool
	}

}
