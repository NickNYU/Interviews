package yiMuSanFenDi;

import java.util.*;

public class KthLargest {
	public static int kthLargest(int[] arr, int k) {
		if(arr.length == 0 || k < 1 || k > arr.length)	return -1;
		return kthLargest(arr, k, 0, arr.length-1);
	}
	
	public static int kthLargest(int[] arr, int k, int left, int right) {
		if(left > right)	return -1;
		int pivot = arr[left];
		int start = left + 1, end = right;
		while(start <= end) {
			if(arr[start] > pivot)	start++;
			else if(arr[end] <= pivot)	end--;
			else	swap(arr, start, end);
		}
		
		swap(arr, end, left);
		if(k == end+1)	return pivot;
		else if(k < end+1)	return kthLargest(arr, k, left, end-1);
		else	return kthLargest(arr, k, end+1, right);
	}
	
	public static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
	public static int getKthLargest(int[] arr, int k) {
		if(arr.length == 0 || k < 1 || k > arr.length)	return -1;
		Queue<Integer> queue = new PriorityQueue<Integer> (k, new Comparator<Integer> (){
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		for(int num : arr) {
			if(queue.size() < k || num >= queue.peek()) {
				queue.offer(num);
			}
		}
		return queue.poll();
	}
	
	public static void main(String[] args) {
		int[] arr ={3,4,1,2,5,5,5,6,7,8,9,10};
		System.out.println(kthLargest(arr, 10));
		System.out.println(getKthLargest(arr, 10));
	}
}
