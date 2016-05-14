package zenefits;

import java.util.*;

public class GoodNode {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = Integer.parseInt(in.nextLine());
		Map<Integer, Integer> map = new HashMap<Integer, Integer> ();
		int count = 1;
		for(int i = 0; i < N; i++) {
			String line = in.nextLine();
			storeNode(map, line, count);
			count ++;
		}
		
		System.out.println(miniModify(map, N));
	}
	
	private static void storeNode(Map<Integer, Integer> map, String line, int count) {
		int val = Integer.parseInt(line);
		map.put(count, val);
	}
	
	private static int miniModify(Map<Integer, Integer> map, int N) {
		Map<Integer, Set<Integer>> link = new HashMap<Integer, Set<Integer>> ();
		
		for(int key : map.keySet()) {
			int val = map.get(key);
			if(link.containsKey(val)) {
				link.get(val).add(key);
			} else {
				boolean breakout = false;
				for(int k : link.keySet()) {
					if(link.get(k).contains(val)) {
						link.get(k).add(key);
						breakout = true;
						break;
					}
				}
				if(breakout)	continue;
				link.put(val, new HashSet<Integer> ());
				link.get(val).add(key);
			}
		}
		
		return link.size() - 1;
	}
}
