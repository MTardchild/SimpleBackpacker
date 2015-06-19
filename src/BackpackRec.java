public class BackpackRec {

	public static int packRecAux(int sizes[], int values[], int spaceLeft, int currentItem, int[][] LookUpTable) {

		if (currentItem < 0) {
			return 0;
		}

		if (sizes[currentItem] > spaceLeft) {
			return packRecAux(sizes, values, spaceLeft, currentItem-1, LookUpTable);
		}

		return Math.max(packRecAux(sizes, values, spaceLeft, currentItem-1, LookUpTable), 
						packRecAux(sizes, values, spaceLeft-sizes[currentItem], currentItem-1, LookUpTable)+values[currentItem]);
	}

	public static int packRec(int sizes[], int values[], int size) {
		int LastItem = sizes.length-1;
		int[][] LookUpTable = prepareLookupTable(sizes, size);

		return packRecAux(sizes, values, size, LastItem, LookUpTable);
	}
	
	public static int[][] prepareLookupTable (int[] sizes, int size) {
		
		int[][] LookUpTable = new int[1][size];
		return LookUpTable;
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
		
		maxItem = 20;
		int BackpackSize = 23;
		int BigSizes[] = new int[maxItem];
		int BigValues[] = new int[maxItem];
		
		for (int i = 0; i < maxItem; i++) {
			BigSizes[i] = (int)(Math.random()*10+2);
			BigValues[i] = (int)(Math.random()*10+1);
		}
		System.out.println("(3) Backpack Size: " + BackpackSize + ", Amount of Items: " + maxItem 
							+ ", Backpack Value: " + packRec(BigSizes, BigValues, BackpackSize));
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
			System.out.println("(1) At best the values in the backpack amount to:  " + bestValue);
		}
		else {
			System.out.println("(1) FAILURE!");
		}
	}
	
	public static void test2(int[] sizes, int[] values) {
		int initialBackpackSize = 4;
		int bestValue = packRec(sizes, values, initialBackpackSize);
		if (bestValue == 4) {
			System.out.println("(2) SUCCESS!");
		}
		else {
			System.out.println("(2) FAILURE!");
		}
	}
}
