package yiMuSanFenDi;
/*
 * 第二道题是一个二分题目，题目相当于给定一个[0, 0, 0, 0, 0, 1, 1, 1, 1, 1]这样的数组，要求找到第一个1的位置。
 * Follow Up是如何减少check mid的次数*/
public class FirstNonZero {
	public static int firstNonZero(int[] arr) {
		return firstNonZero(arr, 0, arr.length-1);
	}
	
	public static int firstNonZero(int[] arr, int left, int right) {
		if(left > right)	return left;
		int mid = (left + right) >> 1;
		if(arr[mid] == 0)	return firstNonZero(arr, mid+1, right);
		else	return firstNonZero(arr, left, mid-1);
	}
	
	public static void main(String[] args) {
		int[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
		System.out.println(firstNonZero(arr));
		int n = -9;
		System.out.println(-(~n));
	}
}
