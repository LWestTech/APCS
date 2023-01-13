/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

	/**
	 * The number of consecutive shuffle steps to be performed in each call
	 * to each sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 8;

	private static final int FLIP_COUNT = 8;

	/**
	 * The number of values to shuffle.
	 */
	private static final int VALUE_COUNT = 52;

	enum CoinState
	{
		HEADS, TAILS
	}

	/**
	 * Tests shuffling methods.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		System.out.println("Results of " + SHUFFLE_COUNT
						  + " consecutive perfect shuffles:");

		int[] values1 = new int[VALUE_COUNT];

		for (int i = 0; i < values1.length; i++) {
			values1[i] = i;
		}

		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			perfectShuffle(values1);
			System.out.print("  " + j + ":");

			for (int k = 0; k < values1.length; k++) {
				System.out.print(" " + values1[k]);
			}

			System.out.println();
		}

		System.out.println();

		System.out.println("Results of " + SHUFFLE_COUNT
						  + " consecutive efficient selection shuffles:");

		int[] values2 = new int[VALUE_COUNT];

		for (int i = 0; i < values2.length; i++) {
			values2[i] = i;
		}

		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k]);
			}

			System.out.println();
		}

		System.out.println();

		System.out.println("Results of " + FLIP_COUNT
						  + " consecutive flips:");

		CoinState coinState = CoinState.TAILS;
		for (int j = 1; j <= FLIP_COUNT; j++) {
			coinState = flip();
			System.out.print("  " + j + ": " + coinState);
			
			System.out.println();
		}

		System.out.println();

		System.out.print("permutation: ");
		System.out.println(arePermutations(values1, values2));

		System.out.println();

		int[] values3 = new int[VALUE_COUNT];

		for (int i = 0; i < values3.length; i++) {
			values3[i] = i - 3;
		}

		System.out.print("permutation: ");
		System.out.println(arePermutations(values3, values2));
	}


	/**
	 * Apply a "perfect shuffle" to the argument.
	 * The perfect shuffle algorithm splits the deck in half, then interleaves
	 * the cards in one half with the cards in the other.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void perfectShuffle(int[] values) {
		int[] shuffled = new int[52];

		int k = 0;
		for (int j = 0; j <= 25; j++)
		{
			shuffled[k] = values[j];
			k += 2;
		}

		k = 1;
		for (int j = 26; j <= 51; j++)
		{
			shuffled[k] = values[j];
			k += 2;
		}

		for (int i = 0; i < 51; i++) {
			values[i] = shuffled[i];
		}
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void selectionShuffle(int[] values) {
		for (int k = 51; k >= 1; k--)
		{
			int r = (int) (Math.random() * (k + 1));
			int otherCard = values[r];
			values[r] = values[k];
			values[k] = otherCard;
		}
	}

	public static CoinState flip()
	{
		return (Math.random() > (double)1/3)? CoinState.HEADS : CoinState.TAILS;
	}

	public static boolean arePermutations(int[] inArray1, int[] inArray2)
	{
		boolean output = true;

		for (int in1: inArray1)
		{
			boolean copyFound = false;
			for (int in2: inArray2)
			{
				if (in1 == in2)
				{
					copyFound = true;
					break;
				}
			}

			if (!copyFound)
			{
				output = false;
				break;
			}
		}		

		return output;
	}
}
