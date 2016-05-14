package careerCup;

/*
 * Array size is (n-m), there are m missing numbers from 1 - n
 * find them in O(lg n)
 * Array is sorted
 * For example :
 * [1, 3, 5, 7] , 7
 * return {2, 4, 6}
 */
import java.util.*;

public class MissingNumbers {
	public static List<Integer> findMissingNumbers(int[] arr, int n) {
		List<Integer> result = new ArrayList<Integer>();
		int lower = arr[0] - 1, upper = arr[arr.length - 1] + 1;
		int m = n - arr.length;
		// case 1 : fill the numbers before or after arr size
		while (lower > 0) {
			result.add(lower--);
			m--;
		}
		while (upper <= n) {
			result.add(upper++);
			m--;
		}
		// case 2 : find inside array
		findHelper(arr, 0, arr.length - 1, m, result);
		return result;
	}

	public static void findHelper(int[] arr, int left, int right, int m, List<Integer> result) {
		if (left > right || m == 0)
			return;
		int mid = (left + right) >> 1;
		if (left + 1 == right) {
			for (int i = arr[left] + 1; i < arr[right]; i++) {
				result.add(i);
				m--;
			}
			return;
		}
		// right
		findHelper(arr, left, mid, (arr[mid] - arr[left] + 1) - (mid - left), result);
		// left
		findHelper(arr, mid, right, (arr[right] - arr[mid] + 1) - (right - mid), result);
	}

	public static void main(String[] args) {
		int[] arr = { 3, 5, 7, 9, 10, 14, 18, 20, 21, 22, 23, 30 };
		List<Integer> missingNumbers = findMissingNumbers(arr, 30);
		Collections.sort(missingNumbers);
		System.out.println(missingNumbers.toString());
	}
}
