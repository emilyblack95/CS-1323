import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

/** This class uses the Item class to run the inner workings of an
 * e-commerce website.  The user interface of the class is in the
 * Driver method.  The site stores Items.
 * 
 * @author Deborah A. Trytten
 * @version 1.0
 *
 */
public class Inventory 
{
	private ArrayList<Item> items;
	
	/** Construct the inventory from a CSV file.  The tile should contain
	 * the name of items in the first column, the price of the item in 
	 * the second column and the number in stock in the third column.
	 * @param fileName The name of the CSV file that contains the inventory.
	 * @throws FileNotFoundException If the named file is not found in the home directory for the project.
	 */
	public Inventory(String fileName) throws FileNotFoundException //READS FROM FILE TO LIST
	{
		items = new ArrayList<Item>();
		Scanner file = new Scanner(new File(fileName));
		while (file.hasNextLine())
		{
			Scanner line = new Scanner(file.nextLine());
			line.useDelimiter(",");  // This tells the Scanner class to use a comma as a separator
			String name = line.next();
			double price = line.nextDouble();
			int quantity = line.nextInt(); 
			Item example = new Item(name, price, quantity);
			items.add(example);
			line.close();
		}
		file.close();
	}
	
	/** Write out the inventory to a CSV file.  The name of each item will be in
	 * the leftmost column, then the price, and lastly the number in stock.
	 * @param fileName The name of the file to write the inventory to.
	 * @throws FileNotFoundException If the file cannot be opened for some reason (usually this will
	 * be file permissions).
	 */
	public void writeToCSV(String fileName) throws FileNotFoundException //READS FROM LIST TO FILE
	{
		PrintWriter file = new PrintWriter(new File(fileName));  //IMPORTANT: THIS IS ASSUMING ALL DATA IS IN THE ARRAYLIST AND NONE IS IN THE FILE. FILE IS TRUNCATED TO ZERO ACCORDING TO JAVA API
		for(int i = 0; i < items.size(); ++i)  //going through the full array list
		{
			String place = items.get(i).toString();
			file.write(place); //add each element into file
		}
		file.close();
	}
	
	/**  Sell the given quantity of the named item.  The person who uses
	 * this method must check that there is sufficient quantity first.
	 * 
	 * @param name The name of the item being sold.
	 * @param quantity The number sold (should be positive).
	 */
	public void sellItem(String name, int quantity)
	{
		Item item = findItemByName(name);
		
		if (item != null)
		{
			item.changeQuantity(-quantity);
		}
	}
	
	/** Restock the item with the given name. 
	 * 
	 * @param name The name of the item that is restocked.
	 * @param quantity The number that were returned or purchased for stock. This should be postive.
	 */
	public void restockItem(String name, int quantity)
	{
		Item temp = findItemByName(name);
		temp.changeQuantity(quantity);
	}
	
	/** Determine how many of the given items are in stock.
	 * 
	 * @param name The name of the item.
	 * @return The number currently in stock. If the name is not found in the inventory
	 * (for example, if it was misspelled), then -1 will be returned.
	 */
	public int getStock(String name)
	{
		Item temp1 = findItemByName(name);
		int currentStock = temp1.getStock();
		return currentStock;
	}
	
	/** Show the entire inventory as a single String.
	 * 
	 * @return A String describing all items in inventory.
	 */
	public String toString()
	{
		String output = items.toString();
		return output; 
	}
	
	/** Find the item with the given name.  This is a private method and would not have to be
	 * Javadoced (although I personally prefer this kind of documentation).
	 * 
	 * @param name The name of the item.
	 * @return A reference to the item with that name, or null if the item does not exist.
	 */
	private Item findItemByName(String name)
	{
		for(int i = 0; i < items.size(); ++i)
		{
			String searching = items.get(i).getName();
			if(searching.equalsIgnoreCase(name))
			{
				return items.get(i);
			}
		}
		return null; //if no name was found
	}
}
