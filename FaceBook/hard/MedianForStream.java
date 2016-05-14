package hard;

import java.util.*;

public class MedianForStream {
	public static int[] Median(int[] input) {
		int[] median = new int[input.length];
		Queue<Integer> minHeap = new PriorityQueue<Integer> ();
		Queue<Integer> maxHeap = new PriorityQueue<Integer> (input.length, new Comparator<Integer> () {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		for(int i = 0; i < input.length; i++) {
			int current = input[i];
			if(i%2 == 0) {
				if(!minHeap.isEmpty() && minHeap.peek() < current) {
					minHeap.offer(current);
					current = minHeap.poll();
				}
				maxHeap.offer(current);
			} else {
				if(maxHeap.peek() > current) {
					maxHeap.offer(current);
					current = maxHeap.poll();
				}
				minHeap.offer(current);
			}
			System.out.println(i+"th:");
			System.out.println(maxHeap.toString());
			System.out.println(minHeap.toString());
			median[i] = maxHeap.peek();
		}
		return median;
	}
	
	public static void main(String[] args) {
		int[] input = {1,5,3,2,4,10,9,8,4};
		System.out.println(Arrays.toString(Median(input)));
	}
}
