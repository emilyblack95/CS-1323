import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
//TODO: PUT MY NAME
//Emily Black   
public class GoFish 
{
	public static int STARTING_HAND_SIZE = 7;
	//TODO: MAKE SURE TO READ INSTRUCTIONS
	public static void main(String[] args) 
	{
		ArrayList<Integer> deck = new ArrayList<Integer>();   //TODO: create deck, set it to creatDeck method, ask user if they want to play game
		deck = GoFish.createDeck();   //creates a shuffled deck of cards
		Collections.shuffle(deck);   //shuffles the deck up   
		Scanner input = new Scanner(System.in);
		System.out.println("Do you want to play a full game of Go Fish?");
		String answer = input.nextLine();
		if(answer.equalsIgnoreCase("yes"));       //if they want to play, run through the method playOneGame
		{
			GoFish.playOneGame(deck, input); 
		}
		if(answer.equalsIgnoreCase("no"));   //if they don't want to play, say goodbye to them! :D
		{
			System.out.println("Goodbye!");
		}
		
	}
	
	//TODO: MAKE THE PROGRAM WORK
	public static void playOneGame(ArrayList<Integer> pool, Scanner input)   //doesnt return, call in another method
	{
		ArrayList<Integer> computer = new ArrayList<Integer>();
		ArrayList<Integer> person = new ArrayList<Integer>();
		ArrayList<Integer> computerPile = new ArrayList<Integer> ();
		ArrayList<Integer> personPile = new ArrayList<Integer>();
		dealHands(pool, computer, person);  
		showCards(person);
		
		// Play the game
		while (computerPile.size() + personPile.size() < 52 || !pool.isEmpty())
		{
			// Let the person play first
			// show the person their cards
			if (!person.isEmpty())
			{
				System.out.println("What card do you want?");
				int card = input.nextInt();
				playOneTurn(card, person, computer, personPile, computerPile, pool);
				
			}
			else
			{
				int newCard = pool.remove(0); //assuming they draw from the top
				person.add(newCard);      //adds new random shuffled card to chooser's hand
			}
			
			showGameState(person, computerPile, personPile);
			
			// Now it is the computer's turn
			// Randomly choose a card
			if (!computer.isEmpty())
			{
				int card = computer.get((int)(Math.random()*computer.size()));	
				System.out.println("Do you have any "  + card + "'s ?");
				playOneTurn(card, computer, person, computerPile, personPile, pool);
				
			}
			else if (!pool.isEmpty())
			{
				int newCard = pool.remove(0); //assuming the computer draws from the top
				computer.add(newCard);      //adds new random shuffled card to computer's hand
			}
			
			showGameState(person, computerPile, personPile);
		}
		
		if((person.size() == 0 || computer.size() == 0) || (pool.size() == 0) && (personPile.size() > computerPile.size()))
		{
			System.out.println("YOU WON! YOU BEAT THE COMPUTER!");
		}
		else if((person.size() == 0 || computer.size() == 0) || (pool.size() == 0) && (personPile.size() < computerPile.size()))
		{
			System.out.println("YOU LOST! THE COMPUTER BEAT YOU!");
		}
		else
		{
			System.out.println("YOU AND THE COMPUTER TIED!");
		}
		
	}
	public static void showGameState(ArrayList<Integer> person, ArrayList<Integer> computerPile,
			ArrayList<Integer> personPile)         //doesnt return, call in another method
	{
		System.out.println("Here are your cards:");
		showCards(person);
		System.out.println("Here is your pile:");
		showCards(personPile);
		System.out.println("Here is my pile:");
		showCards(computerPile);
	}
	
	public static void playOneTurn(int card, ArrayList<Integer> chooser, ArrayList<Integer> chosen,
			ArrayList<Integer> chooserPile, ArrayList<Integer> chosenPile, ArrayList<Integer> pool)       //doesnt return, call in it a method
	{
		if (chosen.contains(card))
		{
			card = chosen.remove(card);
			chooser.add(card);
			if(Collections.frequency(chooser, card) == 4)  //if they have 4 elements of the same card they asked for
			{
				GoFish.transferCards(card, chooserPile, chooser);   //takes from chooser, and puts it in chooserPile
			}
		}
		else
		{
			System.out.println("Go fish!");
			
			int newCard = pool.remove(0); //assuming they draw from the top
			chooser.add(newCard);      //adds new random shuffled card to chooser's hands
			if(Collections.frequency(chooser, newCard) == 4)  
			{
				GoFish.transferCards(newCard, chooserPile, chooser);   //takes from chooser, and puts it in chooserPile
			}
			
		}
	}
	public static void transferCards(int card, ArrayList<Integer> destination, ArrayList<Integer> source) //doesnt return, call in another method

	{
		while (source.contains(card))
		{
			destination.add(card);
			source.remove(new Integer(card)); // this is that tricky thing from the handout
		}
	}
	public static void dealHands(ArrayList<Integer> deck, ArrayList<Integer> hand1, ArrayList<Integer> hand2) //doesnt return, call in another method
	{
		int card;
		for(int i = 0; i < 7; i++)   //ADDS 7 CARDS TO COMPUTERS HAND
		{
			card = deck.remove(i);
			hand1.add(card);
		}
		for(int i = 0; i < 7; i++)       //ADDS 7 CARDS TO PLAYERS HAND
		{
			card = deck.remove(i);
			hand2.add(card);
		}
	}
	public static ArrayList<Integer> createDeck() //returns something, call in main method
	{
		ArrayList<Integer> deck = new ArrayList<Integer>(); 
		int count = 0;
		while(count < 52)   
		{
			deck.add(count, count%13+1);
			count++;
		}
		return deck;
	}
	public static void showCards(ArrayList<Integer> cards) //doesnt return, call in another method
	{
		Collections.sort(cards);
		
		for (Integer i: cards)
		{
			System.out.print(i + " ");
		}
		System.out.println();
	}
    ////TODO: MAKE SURE EVERYTHING LOOKS NICE
}
