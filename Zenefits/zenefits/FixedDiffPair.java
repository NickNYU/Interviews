package zenefits;

import java.util.*;

public class FixedDiffPair {
	
	public static void main(String[] args) {
		int[] arr = {3, 1, 4, 2, 5, 7, 10, 10, 12, 14};
		System.out.println(fixedDiffPair(arr, 3));
	}
	
	public static int fixedDiffPair(int[] arr, int diff) {
		if(arr == null || arr.length < 2)
			return 0;
		
		Arrays.sort(arr);
		int left = 0, right = 1;
		int count = 0;
		
		while(right < arr.length) {
			if(arr[right] - arr[left] < diff) {
				right ++;
			} else if(arr[right] - arr[left] > diff) {
				left ++;
			} else {
				count ++;
				System.out.println(arr[left] + "   " + arr[right]);
				if(arr[left] == arr[left+1]) {
					left ++;
					continue;
				}
				if(arr[right] == arr[right+1]) {
					right ++;
					continue;
				}
				right ++;
			}
		}
		
		return count;
	}

}
