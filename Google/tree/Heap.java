package tree;

import java.util.Arrays;

public class Heap {

	public static void buildMaxHeap(int[] arr) {
		for(int i = arr.length/2; i >= 0; i--) {
			heapify(arr, i, arr.length);
		}
	}
	
	public static void heapify(int[] arr, int i, int size) {
		int left = (i<<1) + 1;
		int right = (i<<1) + 2;
		int largest = i;
		if(left < size && arr[left] > arr[i]) {
			largest = left;
		}
		if(right < size && arr[right] > arr[largest]) {
			largest = right;
		}
		if(largest != i) {
			swap(arr, i, largest);
			heapify(arr, largest, size);
		}
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void heapSort(int[] arr) {
		buildMaxHeap(arr);
		System.out.println(Arrays.toString(arr));
		int size = arr.length;
		for(int i = arr.length-1; i > 0; i--) {
			swap(arr, i, 0);
			System.out.println("front : "+Arrays.toString(arr));
			heapify(arr, 0, --size);
			System.out.println("end :   "+Arrays.toString(arr));
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {3,2,1,4,5};
		heapSort(arr);
		//System.out.println(Arrays.toString(arr));
	}
}
