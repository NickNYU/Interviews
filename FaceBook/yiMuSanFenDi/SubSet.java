package yiMuSanFenDi;

import java.util.*;

public class SubSet {
	public static boolean isSubset(int[] arr1, int[] arr2) {
		if (arr1 == null || arr1.length == 0)
			return arr2.length == 0;
		Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		for (int num : arr1) {
			if (map1.containsKey(num)) {
				map1.put(num, map1.get(num) + 1);
			} else {
				map1.put(num, 1);
			}
		}
		for (int num : arr2) {
			if (map2.containsKey(num)) {
				map2.put(num, map2.get(num) + 1);
			} else {
				map2.put(num, 1);
			}
			if (!map1.containsKey(num) || map1.get(num) < map2.get(num))
				return false;
		}
		return true;
	}

	public static boolean isSubset2(int[] arr1, int[] arr2) {
		if (arr1 == null || arr1.length == 0)
			return arr2.length == 0;
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int index1 = 0, index2 = 0;
		while (index1 < arr1.length && index2 < arr2.length) {
			if (arr1[index1] < arr2[index2]) {
				index1++;
			} else if (arr1[index1] == arr2[index2]) {
				index1++;
				index2++;
			} else {
				return false;
			}
		}
		return index2 == arr2.length;
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4, 5, 6, 7, 10, 11 };
		int[] arr2 = { 2, 3, 11, 12 };
		System.out.println(isSubset(arr1, arr2));
		System.out.println(isSubset2(arr1, arr2));
	}
}
