package normal;
/*
* An atm can only dispense values of $1, $5, $20, and $50. Return the number 
* of unique ways that a $ amount of X can be tendered.
* ($1, $5) is distinct from ($5, $1)

* Input: 4 Output: 1
* Input: 6 Output: 3
* Input: 100 Output: 954515231698
*/

public class CoinProblem {
	public static long tellMoneyCombinations(int money) {
		long[] f = new long[money+1];
		f[0] = f[1] = 1;
		for(int i = 2; i < money+1; i++) {
			f[i] = f[i-1];
			if(i > 5)	f[i] += f[i-5];
			if(i > 20)	f[i] += f[i-20];
			if(i > 50)	f[i] += f[i-50];
		}
		return f[money];
	}
	
	public static int normalMoney(int money) {
		return 1;
	}
}
