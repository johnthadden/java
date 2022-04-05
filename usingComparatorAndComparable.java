// importing Comparator interface
import java.util.Comparator;

public class Main {
//method using Comparable, using bubble sort to be used on number object
	public static <E extends Comparable<E>> void sortFunction(E[] list) {
		bubbleSort(list, (item1, item2) -> ((Comparable<E>)item1).compareTo(item2));
	}

//method using Comparator, to be used on String object
	public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
		boolean condition = true;
		for(int i = 1; i < list.length && condition; i++) {
			condition = false;
			for (int k = 0; k < list.length - i; i++) {
				if (comparator.compare(list[k], list[k +1]) > 0) {
					E temp = list[k];
					list[k] = list[k + 1];
					list[k + 1] = temp;
					condition = true;
				}
			}
		}
	}
// main method, declaring both list objects and sorting them with sortFunction() and bubbleSort()
	public static void main(String[] args) {
		Integer[] numberList = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		sortFunction(numberList);

		for(int i = 0; i < numberList.length; i++) {
			System.out.print(numberList[i] + " ");
		}
		System.out.println();

		String[] stringList = {"Sometimes", "java", "is", "hard", "but", "it's",
		"fun", "when", "I", "get", "it", "."};
		bubbleSort(stringList, (word1, word2) -> word1.compareToIgnoreCase(word2));

		for (int i = 0; i < stringList.length; i++) {
			System.out.print(stringList[i] + " ");
		}
	}
}
