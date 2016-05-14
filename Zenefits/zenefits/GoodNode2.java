package zenefits;

import java.util.*;

public class GoodNode2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = Integer.parseInt(in.nextLine());
		Map<Integer, Node> map = new HashMap<Integer, Node> ();
		int count = 1;
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(in.nextLine());
			buildGraph(map, count, num);
			count ++;
		}
		
		System.out.println(miniModify(map, N));
	}
	
	private static void buildGraph(Map<Integer, Node> map, int count, int num) {
		Node base = null, neighbor = null;
		
		if(map.containsKey(count)) {
			base = map.get(count);
		} else {
			base = new Node(count);
			map.put(count, base);
		}
		
		if(map.containsKey(num)) {
			neighbor = map.get(num);
		} else {
			neighbor = new Node(num);
			map.put(num, neighbor);
		}
		
		if(base != null) {
			base.neighbor = neighbor;
		}
	}
	
	private static int result = 0;
	private static int miniModify(Map<Integer, Node> map, int n) {
		Set<Integer> visited = new HashSet<Integer> ();
		for(int i = 1; i < n+1; i++) {
			if(!visited.contains(i)) {
				result ++;
				dfs(map, i, visited);
			}
		}
		return result;
	}
	
	private static void dfs(Map<Integer, Node> map, int val, Set<Integer> visited) {
		if(visited.contains(val))	return;
		
		visited.add(val);
		
		Node node = map.get(val).neighbor;
		if(node.val == 1)	result --;
		dfs(map, node.val, visited);
		
	}
}

class Node {
	public int val;
	public Node neighbor;
	
	public Node(int v) {
		this.val = v;
	}
	
	@Override
	public int hashCode() {
		return val;
	}
	
	@Override
	public boolean equals(Object n) {
		if(!(n instanceof Node))	return false;
		return this.val == ((Node) n).val;
	}
}
