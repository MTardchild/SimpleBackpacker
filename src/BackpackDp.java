public class BackpackDp {

	// DON'T TOUCH!
	public static final int UNKNOWN = -1;

	public static int packDpAux(int sizes[], int values[], int spaceLeft, int currentItem, int[][] table) {

		int bestSum;

		/* Handle the base cases:
		 * a) We tested all items
		 * b) There are no items to begin with
		 * c) The backpack is full
		 * d) The backpack didn't have any space to begin with
		 */
		if (isBaseCase(spaceLeft, currentItem)) {
			bestSum = -1 /* TODO: Copy implementation from BackpackRec */;
		} else {
			/* Perform a table lookup and check whether we already know
			 * how to pack a backpack that has "leftSpace" space left 
			 * given "maxItem".
			 */
			// TODO: Implement

			// Case 1: Do not use current item, try item with next lower index
			int bestValue1 = tryOtherItem(sizes, values, currentItem, spaceLeft, table);

			// Case 2: Use current item and recurse with less space left
			int bestValue2 = packCurrentItem(sizes, values, spaceLeft, currentItem, table);

			// Return the better result from the two configurations we've just
			// tried
			bestSum = selectBetterResult(bestValue1, bestValue2);
		}

		// Remember the result
		// TODO: Implement

		return bestSum;
	}

	public static boolean isBaseCase(int spaceLeft, int currentItem) {

		// TODO: Copy implementation from BackpackRec
		return false;
	}

	public static int selectBetterResult(int value1, int value2) {

		// TODO: Copy implementation from BackpackRec
		return -1;
	}

	public static int tryOtherItem(
			int[] sizes, int[] values,
			int currentItem, int spaceLeft, int[][] table) {

		// TODO: Copy implementation from BackpackRec
		return -1;
	}

	public static int packCurrentItem(
			int[] sizes, int[] values,
			int spaceLeft, int currentItem, int[][] table) {

		// TODO: Copy implementation from BackpackRec
		return -1;
	}

	public static int packDp(int sizes[], int values[], int size) {

		// Start with the last item
		// TODO: Set to correct index!
		int lastItem = -1;

		int[][] table = prepareLookupTable(sizes, size);

		/* Compute the value of the backpack that achieves
		 * the highest combined item value.
		 */
		return packDpAux(sizes, values, size, lastItem, table);
	}

	public static int[][] prepareLookupTable(int[] sizes, int size) {
		/* Create table and fill it with UNKNOWN
		 * Remember to set correct dimensions! Consider the
		 * base case of an empty backpack as well!
		 */
		// TODO: Implement
		return null;
	}

	public static void main(String args[]) {

		// TODO: Play around with different item sets and backpack sizes

		int maxItem = 4;
		int sizes[] = new int[maxItem];
		int values[] = new int[maxItem];

		// Item 0 with size 2 and value 1
		sizes[0] = 2;
		values[0] = 1;

		// Item 1 with size 3 and value 1
		sizes[1] = 3;
		values[1] = 1;

		// Item 2 with size 2 and value 2
		sizes[2] = 2;
		values[2] = 2;

		// Item 3 with size 2 and value 2
		sizes[3] = 2;
		values[3] = 2;

		test1(sizes, values);
		test2(sizes, values);
		test3(sizes, values);
	}

	public static void test1(int[] sizes, int[] values) {
		int initialBackpackSize = 6;

		// This configuration should yield a maximum value of 5:
		// Item 3 + Item 2 + Item 0 -> Value 2 + 2 + 1 = 5

		// Since every item can be added to the backpack only once,
		// the following result IS NOT POSSIBLE:
		// Item 2 + Item 2 + Item 2 -> Value 2 + 2 + 2 = 6

		int bestValue = packDp(sizes, values, initialBackpackSize);
		if (bestValue == 5) {
			System.out.println("At best the values in the backpack amount to:  " + bestValue);
		}
		else {
			System.out.println("(1) FAILURE");
		}
	}

	public static void test2(int[] sizes, int[] values) {
		int initialSize = 17;
		if (BackpackDp.prepareLookupTable(sizes, initialSize) == null)
			System.out.println("(2) FAILURE");
	}

	public static void test3(int[] sizes, int[] values) {
		if (BackpackDp.packDpAux(sizes, values, 10, -1, new int[0][0]) > 0)
			System.out.println("(3) FAILURE");
	}

	// DON'T TOUCH
	public static void useInterface(int[] sizes, int[] values) {
		packDpAux(sizes, values, 0, 2, null);
		isBaseCase(1, 1);
		tryOtherItem(sizes, values, 2, 5, null);
		packCurrentItem(sizes, values, 2, 5, null);
		selectBetterResult(5, 4);
	}
}
