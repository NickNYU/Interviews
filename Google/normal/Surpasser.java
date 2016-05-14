package normal;

import java.util.*;

public class Surpasser {
	public static int surPasser(int[] arr) {
		Stack<Integer> stack = new Stack<Integer> ();
		int index = 0, result = 0;
		while(index < arr.length) {
			//System.out.println(index);
			if(stack.isEmpty() || arr[index] <= arr[stack.peek()]) {
				stack.push(index++);
			} else {
				stack.pop();
				int len = stack.isEmpty() ? index : index - stack.peek()-1;
				result = Math.max(result, len);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 7, 1, 2, 3, 23, 14, 6, 9};
		System.out.println("Length of Array" + arr.length + "-> SurPasser: "+surPasser(arr));
	}
}
