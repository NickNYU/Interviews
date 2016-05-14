package zenefits;

import java.util.*;

public class TicketSell {
	
	public static int maxProfit(int[] arr, int k) {
		int result = 0;
		Queue<Integer> queue = new PriorityQueue<Integer> (arr.length, new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		for(int val : arr)
			queue.offer(val);
		
		for(int i = 0; i < k; i++) {
			int val = queue.poll();
			result += val;
			queue.offer(val - 1);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = {2, 5};
		System.out.println(maxProfit(arr, 4));
	}
}
