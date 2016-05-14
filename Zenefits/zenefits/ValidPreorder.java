package zenefits;

public class ValidPreorder {

	public static boolean isValidPreorder(int[] arr) {
		// 1. find the first node that is larger than root, is the right child (root of the right sub tree)
		
		return isValidPreorder(arr, 0, arr.length - 1);
	}
	
	public static boolean isValidPreorder(int[] arr, int left, int right) {
		
		if(left >= right)	return true;
		
		int index = left + 1;
		
		while(index <= right && arr[index] < arr[left]) {
			index ++;
		}
		
		// dont have a right tree
		if(index > right)
			return isValidPreorder(arr, left+1, right);
		
		// every node in right sub tree should be larger than root
		for(int i = index; i <= right; i++)
			if(arr[left] > arr[i])
				return false;
		
		boolean leftSubTree = isValidPreorder(arr, left+1, index-1);
		boolean rightSubTree = isValidPreorder(arr, index, right);
		
		return leftSubTree && rightSubTree;
	}
	
	public static void main(String[] args) {
		int[] arr = {3, 4, 5, 1, 2};
		System.out.println(isValidPreorder(arr));
	}
}
