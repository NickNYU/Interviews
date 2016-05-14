package normal;

import java.util.Arrays;

public class ShortestPalindrome {
	public static int findShortest(String word) {
		if(word==null || word.length()==0){
			throw new NullPointerException();
		}
		int end = 0;
		for(int i=1;i<word.length();i++){
			if(isPalindrome(word,0,i)){
				end = i;
			}
		}
		return word.length() - end - 1;
	}
	
	public static boolean isPalindrome(String word, int left, int right){
		while(left < right) {
			if(word.charAt(left) != word.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}
	
	public static int getPalindrome(String s) {
		int n = s.length();
		int[] f = new int[2*n+1];
		
		StringBuffer sb = new StringBuffer();
		sb.append(s);
		sb.append('$');

		for (int i = 0; i < n; i++) {
			sb.append(s.charAt(n - 1 - i));
		}
		char[] current = sb.toString().toCharArray();
		//System.out.println(Arrays.toString(current));
		f[0] = 0;
		for (int i = 1; i < 2 * n + 1; i++) {
			int j = f[i - 1];
			//System.out.println(i+"->"+j);
			while (j > 0 && current[j] != current[i]) {
				j = f[j - 1];
				//System.out.println("current i: "+j+"current j: "+j);
			}
			if(current[i] == current[j]){
				//System.out.println("Here we find a equal"+i+"and"+j);
				j++;
			}
			f[i] = j;
		}
		//System.out.println(Arrays.toString(f));
		return n - f[2 * n];
	}
	
	public static int test(String word) {
		int n = word.length();
		int[] f = new int[2*n+1];
		f[0] = 0;
		char[] arr1 = word.toCharArray();
		char[] arr2 = word.toCharArray();
		reverse(arr1);
		String str = String.copyValueOf(arr1);
		str += "$";
		str += String.copyValueOf(arr2);
		char[] arr = str.toCharArray();
		System.out.println(str);
		for(int i = 1; i < 2*n+1; i++) {
			int j = f[i-1];
			while(j > 0 && arr[i] != arr[j])
				j = f[j-1];
			if(arr[i] == arr[j])
				j++;
			f[i] = j;
		}
		System.out.println(Arrays.toString(f));
		return f[2*n];
	}
	public static void reverse(char[] arr){
		//System.out.println(Arrays.toString(arr));
		int left = 0, right = arr.length-1;
		while(left < right){
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
		//System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args){
		System.out.println(findShortest("abcdefghijklmn"));
		System.out.println(getPalindrome("abcdefghijklmn"));
		System.out.println(test("abcdefghijklmn"));
	}
}
