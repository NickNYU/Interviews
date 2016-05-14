package yiMuSanFenDi;

public class IntersectionOfTwoSortedArray {
	public static int intersectionOfArrays(int[] arr1, int[] arr2) {
		if(arr1.length == 0 || arr2.length == 0)	return -1;
		int index1 = 0, index2 = 0;
		while(index1 < arr1.length && index2 < arr2.length) {
			if(arr1[index1] < arr2[index2]) {
				index1 ++;
			} else if(arr1[index1] > arr2[index2]) {
				index2 ++;
			} else {
				return arr1[index1];
			}
		}
		return -1;
	}
	
	public static int intersectionII(int[] arr1, int[] arr2) {
		for(int i = 0; i < arr2.length; i++) {
			if(search(arr1, arr2[i]))
				return arr2[i];
		}
		return -1;
	}
	
	public static boolean search(int[] arr, int target) {
		return search(arr, target, 0, arr.length-1);
	}
	
	public static boolean search(int[] arr, int target, int left, int right) {
		if(left > right)	return false;
		int mid = (left + right) >> 1;
		if(arr[mid] == target)	return true;
		else if(arr[mid] > target)	return search(arr, target, left, mid-1);
		else	return search(arr, target, mid+1, right);
	}
	public static void main(String[] args) {
		int[] arr1 = {1,2,3,4,5,6,7,8,9,10,14,20,30,31,50};
		int[] arr2 = {21,24,29,30,40,50,60,70,80};
		System.out.println(intersectionOfArrays(arr1, arr2));
		System.out.println(intersectionII(arr1, arr2));
	}
}
