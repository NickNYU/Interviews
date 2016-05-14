package careerCup;

import java.util.Arrays;

public class ReverseWordInString {
	public static String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		char[] arr = s.toCharArray();
		// first of all, reverse the whole string
		reverse(arr, 0, arr.length - 1);
		// @param left : the left pointer of a word
		// @param right : the right pointer
		// @param offset : where we should start copy a new word
		int left = 0, right = 0, offset = 0;
		while (right < arr.length) {
			// escape the space
			while (left < arr.length && arr[left] == ' ') {
				left++;
			}
			if (left == arr.length)
				break;
			// find the whole word
			right = left;
			while (right < arr.length && arr[right] != ' ') {
				right++;
			}
			// now we begin to copy the word, however, before copy it, we need
			// reverse it
			reverse(arr, left, right - 1);
			// copy, left is begin and right-1 is the end
			for (int i = 0; i < right - left; i++) {
				arr[offset + i] = arr[left + i];
			}
			// redefine offset
			offset += right - left;
			if (offset < arr.length)
				arr[offset] = ' ';
			offset++;
			// reset left and right
			left = right;
		}
		// copy the effiency part of string
		offset -= 1;
		System.out.println(Arrays.toString(arr));
		// System.out.println(offset + " "+arr[offset]);
		char[] result = new char[offset];
		System.arraycopy(arr, 0, result, 0, offset);
		System.out.println(Arrays.toString(result));
		if (result[0] == ' ')
			return "";
		return new String(result);
	}

	private static void reverse(char[] arr, int left, int right) {
		while (left < right) {
			swap(arr, left++, right--);
		}
	}

	private static void swap(char[] arr, int left, int right) {
		char temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

	public static void main(String[] args) {
		String s = "  hello     world  ";
		System.out.println(reverseWords(s));
	}
}
