package mitbbs;

/*
 * 1 + b + 2 = b + 3

或者 （x ＋ 1）＊ 3 ＋ 2 *（2x + 5） 化简成7x + 13 

*/
public class SimplefyFunction {
	
	public static String simplifyFunction(String fun) {
		int left = 0, right = 0;
		while(left < fun.length()) {
			while(right < fun.length() && !isCompute(fun.charAt(right))) {
				right ++;
			}
		}
		return "";
	}
	
	public static boolean isCompute(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}
}

class Res {
	public int x;
	public int num;
	public Res(int x, int num) {
		this.x = x;
		this.num = num;
	}
}
