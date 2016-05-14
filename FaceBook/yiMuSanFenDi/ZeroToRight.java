package yiMuSanFenDi;

/*
 * 第一题是给一个数组，里面有整数，还有0，要求把所有非零元素移动到数组的左边，0移动到数组的右边，然后返回新数组的长度，
 * 比如[1, 0, 3, 2, 0] ==> [1, 3, 2, 0, 0]，不需要保证原来的顺序。
 * Follow Up是如果不需要保存0，减少数组的读写次数。
 * */
import java.util.*;

public class ZeroToRight {
	public static void zeroToRight(int[] arr) {
		if (arr == null || arr.length == 0)
			return;
		int left = 0, right = arr.length - 1;
		while (left < right) {
			if (arr[left] != 0)
				left++;
			else if (arr[right] == 0)
				right--;
			else
				swap(arr, left, right);
		}
	}

	public static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

	public static void zeroToRight2(int[] arr) {
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				if (i != index)
					arr[index] = arr[i];
				index++;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 0, 3, 2, 0, 4, 5, 0, 0, 0, 0, 10 };
		zeroToRight(arr);
		System.out.println(Arrays.toString(arr));
	}
}
