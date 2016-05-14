package tree;

import java.util.Arrays;

public class QuickSort {
	
	public static void quickSort(int[] arr, int left, int right) {
		if(left >= right)	return;
		int q = partition(arr, 0, right);
		quickSort(arr, left, q-1);
		quickSort(arr, q+1, right);
	}
	
	public static int partition (int[] arr, int left, int right) {
		int x = arr[right];
		int i = -1;
		for(int j = left; j < right; j++) {
			if(arr[j] <= x) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i+1, right);
		return i+1;
	}
	
	public static int partition2 (int[] arr, int left, int right) {
		int x = arr[right];
		int i = -1;
		for(int j = left; j < right; j++) {
			if(arr[j] > x) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i+1, right);
		return i+1;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static int kthSmallestElement(int[] arr, int left, int right, int k) {
		if(left == right) {
			return arr[left];
		}
		int q = partition(arr, left, right);
		int pivot = q - left + 1;
		if(pivot == k) {
			return arr[q];
		} else if(k < pivot) {
			return kthSmallestElement(arr, left, q-1, k);
		} else {
			return kthSmallestElement(arr, q+1, right, k-pivot);
		}
	}
	
	public static int kthLargestElement(int[] arr, int left, int right, int k) {
		if(left == right) {
			return arr[left];
		}
		int q = partition2(arr, left, right);
		int pivot = q - left + 1;
		if(pivot == k) {
			return arr[q];
		} else if(k < pivot) {
			return kthLargestElement(arr, left, q-1, k);
		} else {
			return kthLargestElement(arr, q+1, right, k-pivot);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,8,9,10,7};
		//System.out.println(Arrays.toString(arr));
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
		//System.out.println(kthSmallestElement(arr, 0, arr.length-1, 1));
		System.out.println(kthLargestElement(arr, 0, arr.length-1, 1));
	}
}
