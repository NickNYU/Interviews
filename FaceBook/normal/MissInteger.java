package normal;

/*
 * Array of size (n-m) with numbers from 1..n with m of them missing. Find one all of the missing numbers in O(log). Array is sorted. 
	Example: 
	n = 8 
	arr = [1,2,4,5,6,8] 
	m=2 
	Result has to be a set {3, 7}.
 */
import java.util.*;
import tools.AssortedMethod;

public class MissInteger {
	public static Set<Integer> findMissing(int[] arr) {
		Set<Integer> rs = new HashSet<Integer>();
		findMissingHelper(arr, 0, arr.length - 1, rs);
		return rs;
	}

	public static void findMissingHelper(int[] arr, int left, int right, Set<Integer> rs) {
		if (left > right)
			return;
		int mid = (left + right) >> 1;
		int median = (arr[left] + arr[right]) >> 1;
		if (mid > 0 && arr[mid] != arr[mid - 1] + 1)
			rs.add(arr[mid] - 1);
		if (mid < arr.length - 1 && arr[mid] != arr[mid + 1] - 1)
			rs.add(arr[mid] + 1);
		if (median == arr[mid]) {
			findMissingHelper(arr, left, mid - 1, rs);
			findMissingHelper(arr, mid + 1, right, rs);
		} else if (median < arr[mid]) {
			findMissingHelper(arr, left, mid - 1, rs);
		} else {
			findMissingHelper(arr, mid + 1, right, rs);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 5, 6, 8, 10 };
		Set<Integer> rs = findMissing(arr);
		AssortedMethod.printSet(rs);
	}
}
