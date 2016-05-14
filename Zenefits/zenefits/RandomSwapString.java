package zenefits;

import java.util.*;

public class RandomSwapString {
	
	public static void main(String[] args) {
		String word = "you are beautiful";
		System.out.println(randomSwap(word));
	}
	
	public static String randomSwap(String word) {
		char[] arr = word.toCharArray();
		
		int left = 0, right = 0;
		
		while(right < arr.length) {
			while(right < arr.length && arr[right] != ' ')
				right ++;
			swapCharacters(arr, left + 1, right - 2);
			left = right + 1;
			right = left;
		}
		
		return new String(arr);
	}
	
	public static void swapCharacters(char[] arr, int left, int right) {
		if(right - left < 1)	return;
		
		Random random = new Random();
		for(int i = right; i >= left; i--) {
			int j = random.nextInt(right - left + 1) + left;
			swap(arr, j, i);
		}
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void swapCharactersRandom(char[] arr, int left, int right) {
		if(right - left < 1)	return;
		
		Random random = new Random();
		random.nextInt();
		
		int n = right - left;
		for(int i = n; i > 0; i--) {
			int index = random.nextInt(i + 1) + left;
		      // Simple swap
		    swap(arr, i + left, index);
		}
	}
	
	public static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
