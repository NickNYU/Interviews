package tree;

import java.util.*;


public class ReferenceForString {
	
	public static Map<String,String> findReference(String[] list){
		if(list==null || list.length==0)	return null;
		return null;
	}
	
	public static void main(String[] args){
		String[] list = {"zebra", "dog", "duck", "dove"};
		Map<String,String>	reference = findReference(list);
		for(String key : reference.keySet()){
			System.out.println(key+":   "+reference.get(key));
		}
	}
}
