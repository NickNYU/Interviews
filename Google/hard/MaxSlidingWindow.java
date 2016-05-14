package hard;

import java.util.*;


// 给定一个数k，输出以k为window的最大值
// 要求O(n)的时间
public class MaxSlidingWindow {
	
	public static int[] maxSlidingWindow(int[] num, int k) {
		int[] result = new int[num.length - k + 1];
		Deque<Integer> queue = new ArrayDeque<Integer> ();
		
		for(int i = 0; i < k; i++) {
			while(!queue.isEmpty() && num[i] >= num[queue.peekLast()]) {
				queue.pollLast();
			}
			queue.addLast(i);
			System.out.println(queue.toString());
		}
		System.out.println("<1--------------------->");
		for(int i = k; i < num.length; i++) {
			result[i-k] = num[queue.peekFirst()];
			
			while(!queue.isEmpty() && num[i] >= num[queue.peekLast()]) 
				queue.pollLast();
			System.out.println(queue.toString());
			while(!queue.isEmpty() && queue.peekFirst() <= i-k)
				queue.pollFirst();
			System.out.println(queue.toString());
			
			queue.addLast(i);
			System.out.println(queue.toString());
			System.out.println(i+"<--------------------->");
		}
		result[num.length-k] = num[queue.pollFirst()];
		
		return	result;
	}

	public static void main(String[] args) {
		int[] num = new int[] {1, 2, 7, 5, 6, 2, 7, 1, 3, 4};
		
		int[] maxWindow = maxSlidingWindow(num, 3);
		
		System.out.println(Arrays.toString(maxWindow));
	}
}
