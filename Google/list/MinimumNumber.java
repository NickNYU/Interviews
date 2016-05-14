package list;

import tree.PrefixTree;
import java.util.*;

public class MinimumNumber {
	public static String getMinNumber(String[] numbers){
		PrefixTree prefix = new PrefixTree.Build().relative('0').build();
		for(String number : numbers){
			prefix.insert(number);
		}
		List<String> sequence = prefix.preOrderTraversal();
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<sequence.size(); i++){
			sb.append(sequence.get(i));
		}
		return sb.toString();
	}
	
	public static void main(String[] args){
		String[] numbers = {"54", "546", "548", "60", "543"};
		System.out.println(getMinNumber(numbers));
	}
}
