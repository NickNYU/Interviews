package yiMuSanFenDi;

public class Fibonacci {
	public static int fibonacciI(int n) {
		if(n < 0)	return 0;
		if(n < 2)	return n;
		int[] f = new int[n+1];
		f[0] = 0;
		f[1] = 1;
		for(int i = 2; i < n+1; i++)
			f[i] = f[i-1] + f[i-2];
		return f[n];
	}
	
	public static int fibonacciII(int n) {
		if(n < 0)	return 0;
		if(n < 2)	return n;
		int prev = 0, current = 1;
		for(int i = 2; i <= n; i++) {
			int temp = current;
			current += prev;
			prev = temp;
		}
		return current;
	}
	// time : O(2^n)	Space : O(2^n)
	public static int fibonacciIII(int n) {
		if(n < 0)	return 0;
		if(n < 2)	return n;
		return fibonacciIII(n-1) + fibonacciIII(n-2);
	}
	
	public static void main(String[] args) {
		System.out.println(fibonacciIII(24));
		System.out.println(fibonacciII(12));
		System.out.println(fibonacciI(12));
	}
}
