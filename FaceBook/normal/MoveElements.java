package normal;

import tools.AssortedMethod;

public class MoveElements {
	public static void moveElement(int[] arr) {
		int right = arr.length - 1;
		while (right >= 0 && arr[right] == 0)
			right--;
		if (right < 0)
			return;
		int index = 0;
		while (index < right) {
			if (arr[index] == 0) {
				swap(arr, index, right);
				while (right >= 0 && arr[right] == 0)
					right--;
				index++;
			} else {
				index++;
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, -5, 0, 0, 9, -8, 102, -130, 0, 0, 0, 0, 140, 0, 0 };
		AssortedMethod.printIntArray(arr);
		moveElement(arr);
		AssortedMethod.printIntArray(arr);
	}
}
