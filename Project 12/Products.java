import java.text.DecimalFormat;
/**
 * 
 * @author Emily
 * @version 1.0
 */
public class Products 
{
	private String name;  //Dont put in mutator methods
	private double price; //Dont put in mutator methods
	private int quantity;  //Put in mutator methods
	private static DecimalFormat dollars = new DecimalFormat("$0.00");  //Description NOT actual price.
	
	
	
	/** This is the default constructor. It sets the parameters to NULL.
	 * 
	 * @param String name: The name of the product.
	 * @param double price: The price of the product.
	 * @param int quantity: The quantity of the product.
	 */
	public Products(String name, double price, int quantity)
	{
		this.name=name;
		this.price=price;
		this.quantity=quantity;
	}
	
	
	/** This is an accessor method, which returns the name of the product.
	 * 
	 * @returns name of the product.
	 */
	public String getName()
	{
		return name;
	}
	
	
	
	/** This is an accessor method, which returns the name and price of the product.
	 * 
	 * @returns name and the price of the product.
	 */
	public String getNameAndPrice()
	{
		return name + " " + String.valueOf(dollars.format(price)); //Calls the String class method "valueOf"
	}
	
	
	
	/** This is an accessor method, which returns the name, price and quanity of the product.
	 * 
	 * @returns name, price, and quantity of the product.
	 */
	public String toString()
	{
		return name + " " + String.valueOf(dollars.format(price)) + " " + String.valueOf(quantity);
	}
	
	
	
	/** This is a mutator method, which changes the quantity of the specific product.
	 * 
	 * @param int quantity: sets the argument of quantity to the instance data of quantity.
	 */
	public void setQuantity(int quantity)
	{
		this.quantity=quantity; 
	}
	
	
	public static void main(String [] args)
	{
		Products productDescription = new Products("Toilet Paper", 2.36, 15);   //These arguments fit the default constructor's parameters! :0
		System.out.println(productDescription.getName()); //Prints out accessor method
		System.out.println(productDescription.getNameAndPrice()); //Prints out accessor method
		System.out.println(productDescription.toString());
		productDescription.setQuantity(35);
		System.out.println(productDescription);
	}
}
