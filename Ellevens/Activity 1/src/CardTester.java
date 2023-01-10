package src;

/**
 * This is a class that tests the Card class.
 */
public class CardTester {
	/**
	 * The main method in this class checks the Card operations for consistency.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		Card card1 = new Card("King", "Spades", 2);
		Card card2 = new Card("Queen", "Diamonds", 7);
		Card card3 = new Card("Queen", "Diamonds", 7);
		System.out.println(card1.toString());
		System.out.println(card2.toString());
		System.out.println(card3.toString());
		System.out.println(card1.matches(card3));
		System.out.println(card2.matches(card3));
	}
}
