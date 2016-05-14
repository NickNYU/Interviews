package com.emc.ehc.nick.epic;

public class ValidPhoneNumber {
	/*
	 * Print all valid phone numbers of length n subject to following constraints: 
	 * 1.If a number contains a 4, it should start with 4 
     * 2.No two consecutive digits can be same 
     * 3.Three digits (e.g. 7,2,9) will be entirely disallowed, take as input
	 */
	public static void print(int n) {
		int[] valid = {0, 1, 3, 4, 5, 6, 8};
		StringBuffer sb = new StringBuffer();
		print(valid, sb, n);
	}
	
	static void print(int[] valid, StringBuffer sb, int n) {
		if(n==0){
			System.out.println(sb.toString());
			return;
		}
		for(int i : valid){
			if(sb.length()>0){
				if(sb.charAt(sb.length()-1)==(i+'0')||(sb.charAt(0)!='4'&&i==4))
					continue;
			}
			sb.append(i);
			print(valid,sb,n-1);
			sb.deleteCharAt(sb.length()-1);
		}
	}
	
	public static void main(String[] args) {
		print(3);
	}
}
