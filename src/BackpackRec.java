public class BackpackRec {

	public static int packRecAux(int sizes[], int values[], int spaceLeft, int currentItem) {

		if (currentItem < 0) {
			return 0;
		}

		if (sizes[currentItem] > spaceLeft) {
			return packRecAux(sizes, values, spaceLeft, currentItem-1);
		}

		return Math.max(packRecAux(sizes, values, spaceLeft, currentItem-1), packRecAux(sizes, values, spaceLeft-sizes[currentItem], currentItem-1)+values[currentItem]);
	}

	public static int packRec(int sizes[], int values[], int size) {
		int lastItem = sizes.length-1;

		return packRecAux(sizes, values, size, lastItem);
	}

	public static void main(String args[]) {
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

		int bestValue = packRec(sizes, values, initialBackpackSize);
		if (bestValue == 5) {
			System.out.println("At best the values in the backpack amount to:  " + bestValue);
		}
		else {
			System.out.println("(1) FAILURE!");
		}
	}

	public static void test2(int[] sizes, int[] values) {
		if (packRecAux(sizes, values, 0, 2) > 0) {
			System.out.println("(2) FAILURE!");
		} else {
			System.out.println("(2) SUCCESS!");
		}
	}
	
	public static void test3(int[] sizes, int[] values) {
		int initialBackpackSize = 4;
		int bestValue = packRec(sizes, values, initialBackpackSize);
		if (bestValue == 4) {
			System.out.println("(3) SUCCESS!");
		}
		else {
			System.out.println("(3) FAILURE!");
		}
	}
}
