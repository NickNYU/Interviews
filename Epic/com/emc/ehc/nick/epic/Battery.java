package com.emc.ehc.nick.epic;
import java.util.ArrayList;



public class Battery {
	public static ArrayList<ArrayList<Integer>> combination(int n, int[] arr) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		combination(n, arr, result, res);
		return result;
	}
	
	static void combination(int n, int[] arr, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> res) {
		if (n == 0) {
			result.add(new ArrayList<Integer>(res));
			return;
		}
		if (n < 0) return;
		// 没有去重
		for (int i : arr) {
			res.add(i);
			combination(n - i, arr, result, res);
			res.remove(res.size() - 1);
		}
	}
	
private final Character m_value = 'a';
    
    @Override
	public String toString() { return "" + m_value; }
	
	public static void main(String[] args) {
		
		String[] list = {"", "a1", "22\t1", "9\na"};
		for(String word : list) {
			if(word.matches("^([0-9]+)$")) {
				System.out.println(word);
			}
		}
		System.out.println("word");
	}
	
	
	
}
