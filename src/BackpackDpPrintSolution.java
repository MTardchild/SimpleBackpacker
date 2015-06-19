import java.util.LinkedList;
import java.util.List;

public class BackpackDpPrintSolution {

	// DON'T TOUCH!
	public static final int UNKNOWN = -1;

	public static final List<Integer> packed = new LinkedList<>();
	public static final List<Integer> notPacked = new LinkedList<>();

	public static void main(String args[]) {
		test1();
		test2();
	}

	public static void test1() {
		int initialBackpackSize = 6;

		int itemCount = 4;
		int sizes[] = new int[itemCount];
		int values[] = new int[itemCount];

		// Item 0 with size 2 and value 1
		sizes[0] = 3;
		values[0] = 1;

		// Item 1 with size 3 and value 1
		sizes[1] = 2;
		values[1] = 2;

		// Item 2 with size 2 and value 2
		sizes[2] = 2;
		values[2] = 2;

		// Item 3 with size 2 and value 2
		sizes[3] = 2;
		values[3] = 1;

		int[][] table = new int[][] {
				{ 0, UNKNOWN, 0, UNKNOWN, 1, UNKNOWN, 1 },
				{ UNKNOWN, UNKNOWN, 2, UNKNOWN, 2, UNKNOWN, 3 },
				{ UNKNOWN, UNKNOWN, UNKNOWN, UNKNOWN, 4, UNKNOWN, 4 },
				{ UNKNOWN, UNKNOWN, UNKNOWN, UNKNOWN, UNKNOWN, UNKNOWN, 5 }
		};

		// This configuration should yield a maximum value of 5:
		// Item 3 + Item 2 + Item 1 -> Value 1 + 2 + 2 = 5

		printTable(initialBackpackSize, table, sizes, values);

		System.out.println();
		packed.clear();
		notPacked.clear();
		printSolution(initialBackpackSize, table, sizes, values);

		int packedValue = 0;
		for (int i : packed)
			packedValue += values[i];
		if (packedValue != 5)
			System.out.println("FAILED!");
	}

	public static void test2() {
		int initialBackpackSize = 5;

		int itemCount = 1;
		int sizes[] = new int[itemCount];
		int values[] = new int[itemCount];

		sizes[0] = 5;
		values[0] = 1;

		int[][] table = new int[][] {
				{ UNKNOWN, UNKNOWN, UNKNOWN, UNKNOWN, UNKNOWN, 1 }
		};

		printTable(initialBackpackSize, table, sizes, values);

		System.out.println();
		packed.clear();
		notPacked.clear();
		printSolution(initialBackpackSize, table, sizes, values);

		int packedValue = 0;
		for (int i : packed)
			packedValue += values[i];
		if (packedValue != 1)
			System.out.println("FAILED!");
	}

	public static void printSolution(int initialBackpackSize, int[][] table, int[] sizes, int[] values) {

		/* TODO: Implement
		 * 
		 * IMPORTANT: You MUST use notPacking() and packing() to indicate which 
		 * items will or will not be part of the optimally packed backpack.
		 */
	}

	public static void printTable(int initialBackpackSize, int[][] table, int[] sizes, int[] values) {
		System.out.println();
		System.out.print("    Rucksackgroessen -> ");
		for (int j = 0; j <= initialBackpackSize; ++j) {
			System.out.print(String.format("%4d", j));
		}
		System.out.println();
		System.out.println("----------------------------------------------------");
		for (int itemIndex = 0; itemIndex < sizes.length; ++itemIndex) {
			System.out.print(String.format("Item #%2d (v =%2d, s =%2d):", itemIndex, values[itemIndex], sizes[itemIndex]));
			for (int backpackSize = 0; backpackSize <= initialBackpackSize; ++backpackSize) {
				int cell = table[itemIndex][backpackSize];
				System.out.print((cell == UNKNOWN) ? "   ?" : String.format("%4d", cell));
			}
			System.out.println();
		}
	}

	public static void notPacking(int itemIndex, int itemValue, int itemSize) {
		notPacked.add(itemIndex);
		System.out.println(String.format("Not packing item # %2d (v =%2d, s =%2d)", itemIndex, itemValue, itemSize));
	}

	public static void packing(int itemIndex, int itemValue, int itemSize) {
		packed.add(itemIndex);
		System.out.println(String.format("Packing item # %2d (v =%2d, s =%2d)", itemIndex, itemValue, itemSize));
	}
}
