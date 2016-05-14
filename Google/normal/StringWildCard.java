package normal;

import java.util.*;
public class StringWildCard {
	public static List<String> findValidMatch(String digits){
		if(digits == null || digits.length()==0){
			throw new IllegalArgumentException();
		}
		List<String> result = new ArrayList<String> ();
		StringBuffer sb = new StringBuffer();
		findHelper(digits,result,sb,0);
		return result;
	}
	public static void findHelper(String digits, List<String> result, StringBuffer sb, int start){
		if(start==digits.length()){
			result.add(sb.toString());
			return;
		}else{
			if(digits.charAt(start) == '?'){
				sb.append(0);
				findHelper(digits,result,sb,start+1);
				sb.deleteCharAt(sb.length()-1);
				sb.append(1);
				findHelper(digits,result,sb,start+1);
				sb.deleteCharAt(sb.length()-1);
			}else{
				sb.append(digits.charAt(start));
				findHelper(digits,result,sb,start+1);
				sb.deleteCharAt(sb.length()-1);
			}
		}
	}
	
	public static void main(String[] args){
		String wildCard = "1?00?101";
		List<String> result = findValidMatch(wildCard);
		for(String word : result){
			System.out.println(word);
		}
	}
}
