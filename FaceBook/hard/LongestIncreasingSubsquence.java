package hard;

import java.util.Arrays;

public class LongestIncreasingSubsquence {
	public static int normalLIS(int[] num) {
		if (num == null || num.length == 0)
			return 0;
		int[] f = new int[num.length];
		Arrays.fill(f, 1);
		int result = 1;
		for (int i = 1; i < num.length; i++) {
			for (int j = 0; j < i; j++) {
				if (num[i] > num[j]) {
					f[i] = Math.max(f[i], f[j] + 1);
					result = Math.max(f[i], result);
				}
			}
		}
		return result;
	}

	public static int advancedLIS(int[] nums) {
		int[] c = new int[nums.length + 1];
		int size = 1;
		c[1] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < c[1]) {
				c[1] = nums[i];
			} else if (nums[i] > c[size]) {
				c[size + 1] = nums[i];
				size++;
			} else {
				int k = search(c, 1, size, nums[i]);
				if (nums[i] < c[k])
					c[k] = nums[i];
			}
		}
		return size;
	}

	public static int search(int[] arr, int left, int right, int target) {
		if (left > right)
			return left;
		int mid = (left + right) >> 1;
		if (arr[mid] == target)
			return mid;
		else if (arr[mid] > target)
			return search(arr, left, mid - 1, target);
		else
			return search(arr, mid + 1, right, target);
	}

	public static int[] getDP(int[] num) {
		int[] f = new int[num.length];
		Arrays.fill(f, 1);
		for (int i = 1; i < num.length; i++) {
			for (int j = 0; j < i; j++) {
				if (num[i] > num[j]) {
					f[i] = Math.max(f[i], f[j] + 1);
				}
			}
		}
		return f;
	}

	public static int[] longestIncreasingSq(int[] num) {
		if (num == null || num.length == 0)
			return null;
		int[] process = getDP(num);
		int len = 1, start = 0;
		for (int i = 0; i < process.length; i++) {
			if (process[i] > len) {
				start = i;
				len = process[i];
			}
		}
		int[] result = new int[len];
		for (int i = start; i >= 0 && len > 0; i--) {
			if (process[i] == len) {
				result[len - 1] = num[i];
				len--;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// int[] arr1 = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15,
		// 1};
		// int[] arr2 = {7, 0, 9, 2, 8, 4, 1};
		// int[] arr3 = {9, 11, 2, 13, 7, 15};
		// int[] arr4 = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		int[] arr5 = { 1, 2, 9, 4, 7, 3, 11, 8, 14, 6 };
		// int[] arr = {1, 9, 8, 7, 6, 5, 2, 3, 4};
		System.out.println(normalLIS(arr5));
		System.out.println(advancedLIS(arr5));
		System.out.println(Arrays.toString(longestIncreasingSq(arr5)));
	}
}
