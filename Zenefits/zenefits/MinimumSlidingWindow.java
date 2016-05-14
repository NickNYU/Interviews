package zenefits;

import java.util.*;

public class MinimumSlidingWindow {
	
	public static int[] maxSlidingWindow(int A[], int k) {
		int[] B = new int[A.length];
		int n = A.length;
		Deque<Integer> Q = new LinkedList<Integer> ();
		for (int i = 0; i < k; i++) {
			while (!Q.isEmpty() && A[i] >= A[Q.peekLast()])
				Q.pollLast();
		    Q.offerLast(i);
		}
		for (int i = k; i < n; i++) {
		  	B[i-k] = A[Q.peekFirst()];
		  	while (!Q.isEmpty() && A[i] >= A[Q.peekLast()])
		  		Q.pollLast();
		  	while (!Q.isEmpty() && Q.peekFirst() <= i-k)
		  		Q.pollFirst();
		  	Q.offerLast(i);
		 }
		 for(int i = n-k; i < B.length; i++)
			  B[i] = A[Q.peekFirst()];
		  
		 return B;
	}
	
	public static int[] minimumSlidingWindow(int[] arr, int k) {
		int[] result = new int[arr.length];
		
		Deque<Integer> queue = new LinkedList<Integer> ();
		
		for(int i = 0; i < k && i < arr.length; i++) {
			while(!queue.isEmpty() && arr[i] >= arr[queue.peekLast()])
				queue.pollLast();
			queue.offerLast(i);
		}
		
		for(int i = k; i < arr.length; i++) {
			result[i - k] = arr[queue.peekFirst()];
			
			while(!queue.isEmpty() && arr[i] >= arr[queue.peekLast()])
				queue.pollLast();
			
			while(!queue.isEmpty() && queue.peekFirst() <= i - k)
				queue.pollFirst();
			
			queue.offerLast(i);
		}
		
		for(int i = arr.length - k; i < arr.length; i++)
			result[i] = arr[queue.peekFirst()];
		
		return result;
		
	}
	
	public static int countDigitOne(int n) {
        int count = 0;
        if(n == Integer.MIN_VALUE)  n = Integer.MAX_VALUE;
        n = Math.abs(n);
        while(n > 0) {
            if((n % 10) == 1) 
                count ++;
            n /= 10;
        }
        return count;
    }
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 7, 3, 4, 2, 9};
		int[] nums = {1, -1};
		System.out.println(Arrays.toString(minimumSlidingWindow(nums, 1)));
		System.out.println(countDigitOne(-1));
	}
}


class ArrayNode {
	public int val;
	public int max;
	
	public ArrayNode(int v, int m) {
		this.val = v;
		this.max = m;
	}
}