package yiMuSanFenDi;

public class DivideTwoInteger {
	public static int divide(int dividend, int divisor) {
        long p = Math.abs((long)dividend);
        long q = Math.abs((long)divisor);
        
        long ret = 0;
        while (p >= q) {
            int counter = 0;
            while (p >= (q << counter)) {
                counter++;
                if(counter > 31)	return Integer.MAX_VALUE;
            }
            ret += 1 << (counter - 1);
            p -= q << (counter - 1);
        }
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
            return (int)ret;
        else
            return (int)-ret;
    }
	
	public static void main(String[] args) {
		int dividend = Integer.MIN_VALUE, divisor = -1;
		System.out.println(dividend < 0);
		System.out.println(divide(dividend, divisor));
	}
}
