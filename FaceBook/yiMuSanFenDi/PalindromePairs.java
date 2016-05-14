package yiMuSanFenDi;

import java.util.*;

public class PalindromePairs {
	public static List<String[]> palindromePair(List<String> strs) {
		List<String[]> result = new ArrayList<String[]> ();
		Set<String> dict = new HashSet<String> ();
		dict.addAll(strs);
		getPairs(result, dict);
		return result;
	}
	
	public static void getPairs(List<String[]> result, Set<String> dict) {
		for(String word : dict) {
			List<String> leftPossible = getLeftPossible(word);
			List<String> rightPossible = getRightPossible(word);
			for(String left : leftPossible) {
				if(dict.contains(left)) {
					String[] pair = {word, left};
					result.add(pair);
				}
			}
			for(String right : rightPossible) {
				if(dict.contains(right)) {
					String[] pair = {word, right};
					result.add(pair);
				}
			}
		}
	}
	
	public static List<String> getLeftPossible(String word) {
		List<String> result = new ArrayList<String> ();
		for(int i = 0; i < word.length()-1; i++) {
			if(isPalindrome(word, 0, i)) {
				String reverse = new StringBuffer(word.substring(i+1)).reverse().toString();
				result.add(reverse);
			}
		}
		return result;
	}
	
	public static List<String> getRightPossible(String word) {
		List<String> result = new ArrayList<String> ();
		word = new StringBuffer(word).reverse().toString();
		for(int i = 0; i < word.length()-1; i++) {
			if(isPalindrome(word, 0, i)) {
				String reverse = word.substring(i+1);
				result.add(reverse);
			}
		}
		result.add(word);
		return result;
	}
	
	public static boolean isPalindrome(String s, int left, int right) {
		while(left < right) {
			if(s.charAt(left++) != s.charAt(right--))	return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		List<String> strs = Arrays.asList("abb", "a", "bba", "abcc", "ba");
		List<String[]> pairs = palindromePair(strs);
		for(String[] pair : pairs) {
			System.out.println(Arrays.toString(pair));
		}
	}
}
