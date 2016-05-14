package hard;

import java.util.*;

public class MaxCycleLength {
	public static int maxCycleLength(int[] arr) {
		if(arr == null || arr.length == 0)	return 0;
		int result = 0, current = 0;
		int[] time = new int[arr.length];
		Arrays.fill(time,-1);
		
		for(int i = 0; i < arr.length; i++) {
			if(time[i] < 0) {
				int j = i;
                while(j < arr.length && time[j] < 0) {
                	time[j] = current++;
                	j = arr[j];
                }
                if (j != arr.length && time[j] >= time[i]) {
                	result = Math.max(result, current - time[j]);
                }
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,0,4,6,7,8,9,10,5};
		//           0 1 2 3 4 5 6 7 8 9 10
		System.out.println(maxCycleLength(arr));
	}
}
