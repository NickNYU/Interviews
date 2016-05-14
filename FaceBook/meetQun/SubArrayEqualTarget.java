package meetQun;

import java.util.*;

// 也可以用hashset，就可以O(N)了
public class SubArrayEqualTarget {
	public static boolean isSubArrayEqualTarget(int[] arr, int target) {
		int[] sum = new int[arr.length];
		sum[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			sum[i] = sum[i - 1] + arr[i];
			if (sum[i] == target) {
				return true;
			}
			if (search(sum, 0, i - 1, sum[i] - target))
				return true;
		}
		System.out.println(Arrays.toString(sum));
		return false;
	}

	public static boolean isSubArrayEqualTargetII(int[] arr, int target) {
		Set<Integer> set = new HashSet<>();
		int curSum = 0;
		for (int i = 0; i < arr.length; i++) {
			curSum += arr[i];
			if (curSum == target)
				return true;
			else if (set.contains(curSum - target))
				return true;
			set.add(curSum);
		}
		return false;
	}

	public static boolean search(int[] sum, int left, int right, int target) {
		if (left > right)
			return false;
		int mid = (left + right) >> 1;
		if (sum[mid] > target)
			return search(sum, left, mid - 1, target);
		else if (sum[mid] < target)
			return search(sum, mid + 1, right, target);
		else
			return true;
	}

	public static void main(String[] args) {
		int[] arr = { -7, 1, -2, 3, -5, 4 };
		System.out.println(isSubArrayEqualTarget(arr, -4));
		System.out.println(isSubArrayEqualTargetII(arr, -4));
	}
}
