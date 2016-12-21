import java.text.DecimalFormat;

/** Store the details of a single item in inventory.
 * 
 * @author Deborah A. Trytten
 * @version 1.0
 *
 */
public class Item 
{
	private int stock;
	private double price;
	private String name;
	private static final DecimalFormat DOLLARS = new DecimalFormat("$0.00");
	
	/** Construct a new item with attributes, itemName, itemPrice and itemStock.
	 * 
	 * @param itemName The name of the item (immutable).
	 * @param itemPrice The price of the item (immutable).
	 * @param itemStock The current stock of the item (mutable).
	 */
	public Item(String itemName, double itemPrice, int itemStock)
	{
		stock = itemStock;
		price = itemPrice;
		name = itemName;
	}
	
	/** Construct a new item with attributes, itemName, itemPrice. The stock will
	 * be set to zero.
	 * 
	 * @param itemName The name of the item (immutable).
	 * @param itemPrice The price of the item (immutable).
	 */
	public Item(String itemName, double itemPrice)
	{
		this(itemName, itemPrice, 0);
	}
	
	/** Construct a new item with attribute itemName. The price is set to Double.NaN (not a number),
	 * and the stock is set to zero.
	 * @param itemName The name of the item (immutable).
	 */

	public Item(String itemName)
	{
		this(itemName, Double.NaN, 0); // they could initialize the price to 0 too--but this is more cool
	}
	
	/** Increase or decrease the current stock.
	 * 
	 * @param count The number to increase (positive) or decrease (negative) the current stock.
	 */
	public void changeQuantity(int count)
	{
		stock += count;
	}
	
	/** Return the current stock of the item.
	 * 
	 * @return The number of the item in stock.
	 */
	public int getStock()
	{
		return stock;
	}
	
	/** Return the current price of the item.
	 * 
	 * @return The price of the item.
	 */
	public double getPrice()
	{
		return price;
	}
	
	/** Return the name of the item.
	 * 
	 * @return The name of the item.
	 */
	public String getName()
	{
		return name;
	}
	
	/** Return a String describing the item.  The String includes
	 * the name, price (or "Not Assigned" if the price has not been set), and
	 * the quantity in stock.
	 * 
	 * @return A String describing the name, price, and quantity of the item in stock.
	 */
	public String toString()
	{
		if (!Double.isNaN(price))
			return name + " Price: " + DOLLARS.format(price) + " Stock: " + stock;
		return name + " Price: Not Assigned " + " Stock: " + stock; 
	}
	
	/** This method is used for testing.
	 * 
	 * @param args There are no command line arguments.
	 */
	public static void main(String[] args)
	{
		Item item = new Item("Mascara", 4.49, 5);
		System.out.println("Mascara, 4.49, 5: " + item); // also tests toString()
		
		item = new Item("Mascara", 4.49);
		System.out.println("Mascara, 4.49, 0: " + item);
		
		item = new Item("Mascara");
		System.out.println("Mascara, NaN, 0: " + item);
		
		item = new Item("Mascara", 4.49, 5);
		
		System.out.println("Mascara: " + item.getName());
		System.out.println("4.49: " + item.getPrice());
		System.out.println("5: " + item.getStock());

		item.changeQuantity(2);
		System.out.println("7: " + item.getStock());
		
		item.changeQuantity(-4);
		System.out.println("3: " + item.getStock());
	}
	
}
