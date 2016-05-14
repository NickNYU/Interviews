package Bloomberg;

public class DoubleReverse {
	public static double revDouble(double d) {
	    int intPart = (int) d;
//	    double remain = d - intPart;
//	    int digitRight = 0;
//	    int digitLeft = 0;
	    int left = 0;
	    while (intPart > 0) {
		    System.out.println(intPart);
	      int tmp = intPart % 10;
	      left = left * 10 + tmp;
	      intPart = intPart / 10;
	    }
	    /*double epsilon = 0.0000000001;
	    while ((remain - (int) remain) > epsilon) {
	      remain *= 10;
	      digitRight++;
	    }
	    int right = 0;
	    int r = (int) remain;
	    while (r > 0) {
	      int tmp = r % 10;
	      right = right * 10 + tmp;
	      r = r / 10;
	    }*/
	    //double res = left + (double) right / Math.pow(10, digitRight);
	    return left;
	}
	
	public static void main(String[] args){
		System.out.println("1" + revDouble(456.123));
	}
}
