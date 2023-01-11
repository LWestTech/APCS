import java.util.ArrayList;

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] ranks1 = {"King", "Queen"};
		String[] suits1 = {"Diamonds", "Spades"};
		int[] values1 = {2,1};
		Deck deck1 = new Deck(ranks1, suits1, values1);
		System.out.println(deck1.toString());

		String[] ranks2 = {"Queen", "King"};
		String[] suits2 = {"Diamonds", "Spades"};
		int[] values2 = {2,1};
		Deck deck2 = new Deck(ranks2, suits2, values2);
		System.out.println(deck2.toString());

		String[] ranks3 = {};
		String[] suits3 = {};
		int[] values3 = {};
		Deck deck3 = new Deck(ranks3, suits3, values3);
		System.out.println(deck3.toString());

		// -----------------------------------

		System.out.println(deck1.isEmpty());
		System.out.println(deck2.isEmpty());
		System.out.println(deck3.isEmpty());

		System.out.println(deck1.size());
		System.out.println(deck2.size());
		System.out.println(deck3.size());

		deck1.deal();
		deck2.deal();
		deck3.deal();

		System.out.println(deck1.size());
		System.out.println(deck2.size());
		System.out.println(deck3.size());
	}
}
