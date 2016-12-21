public class Driver 
{
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
