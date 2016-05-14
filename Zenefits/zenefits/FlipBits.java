package zenefits;

import java.util.*;

public class FlipBits {
	
	public static int maxOnes(int[] arr) {
		int[][] f = new int[arr.length][arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			f[i][i] = arr[i] == 1 ? -1 : 1;
			for(int j = i+1; j < arr.length; j++) {
				if(arr[j] == 1) {
					f[i][j] = f[i][j-1] - 1;
				} else {
					f[i][j] = f[i][j-1] + 1;
				}
			}
		}
		
		int row = 0, col = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = i; j < arr.length; j++) {
				if(f[row][col] < f[i][j]) {
					row = i;
					col = j;
				}
			}
		}
		
		for(int i = row; i <= col; i++)
			arr[i] = arr[i] == 1 ? 0 : 1;
		
		int result = 0;
		for(int i = 0; i < arr.length; i++)
			if(arr[i] == 1)	
				result ++;
		System.out.println(Arrays.toString(arr));
		
		return result;
	}
	
	// 遇到0加1，遇到1减1  如果总体 < 0 就重置
	public static int maxOnes2(int[] arr) {
		int total = 0, max = 0, end = 0;
		int ones = 0;
		int local_start = 0, global_start = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) {
				total += 1;
			} else {
				ones ++;
				total -= 1;
			}
			
			if(total > max) {
				max = total;
				end = i;
				global_start = local_start;
			}
			if(total < 0) {
				total = 0;
				local_start = i+1;
			}
		}
		
		for(int i = global_start; i <= end; i++) 
			arr[i] = arr[i] == 1 ? 0 : 1;
		
		System.out.println(global_start + "   " + end);
		int result = 0;
		for(int i = 0; i < arr.length; i++)
			if(arr[i] == 1)	
				result ++;
		System.out.println(Arrays.toString(arr));
		
		return ones + max;
	}
	
	public static int maxOnes3(int[] arr) {
		
		int ones = 0;
		int total = 0, index = 0, length = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) {
				total += 1;
			} else {
				ones ++;
				total -= 1;
			}
			length ++;
			if(total < 0) {
				total = 0;
				index = i+1;
				length = 0;
			}
		}
		
		// x0 + x1 = length;
		// x0 - x1 = total;
		// x = x - x1 + x0 = x + x0 - x1 = x - total
		return ones + total;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		
		//System.out.println(maxOnes(arr));
		System.out.println(maxOnes2(arr));
		//System.out.println(maxOnes3(arr));
	}
}
