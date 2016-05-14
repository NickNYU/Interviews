package com.emc.ehc.nick.epic;
import java.util.*;

public class phoneText {
	private static Hashtable<Character,String> pads = new Hashtable<Character,String> ();
	private static StringBuffer sb = new StringBuffer();
	public static void inilize(){
		pads.put('1', "1");
		pads.put('2', "abc2");
		pads.put('3', "def3");
		pads.put('4', "ghi4");
		pads.put('6', "jkl6");
	}

	public static void print(String enter){
		int count;
		while(!enter.isEmpty()){
			count =1;
			char c = enter.charAt(0);
			if(c!='0'&&c!='5'&&c!='#'){
				while(enter.length()>count&&enter.charAt(count)==c){
					count++;
				}
				String out = pads.get(c);
				char output = out.charAt((count-1)%out.length());
				sb.append(output);
			}
			enter = enter.substring(count);
		}
		System.out.println(sb.toString());
		sb.setLength(0);
	}
	
	public static void main(String []argc){
		String s1 = "22#222";
		String s2 = "225";
		inilize();
		print(s1);
		print(s2);
	}
}
