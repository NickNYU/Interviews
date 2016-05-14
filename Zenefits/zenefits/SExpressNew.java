package zenefits;

import java.util.*;

/*
 * Error Code      Type of error
E1                 More than 2 children
E2                 Duplicate Edges
E3                 Cycle present. 
E4                 Multiple roots
E5                 Any other error   */

public class SExpressNew {
	// if n nodes, then only n-1 edges
	public static String getSExpress(String line) {
		
		Set<Character> set = new HashSet<Character> ();
		boolean[][] graph = new boolean[26][26];
		
		boolean E2 = false;
		for(int i = 1; i < line.length(); i += 6) {
			char parent = line.charAt(i);
			char child = line.charAt(i+2);
			// duplicate
			if(graph[parent-'A'][child-'A'])	E2 = true;
			
			// more than 2 children
			int numOfChildren = 0;
			graph[parent-'A'][child-'A'] = true;
			for(int j = 0; j < 26; j++) {
				if(graph[parent-'A'][j])	numOfChildren ++;
			}
			if(numOfChildren > 2)	return "E1";
			
			set.add(parent);
			set.add(child);
		}
		
		if(E2)	return "E2";
		
		// part 2 : go through and judge E3, E4
		int rootNum = 0;
		boolean E4 = false;
		char root = 'A';
		
		for(char node : set) {
			for(int i = 0; i < 26; i++) {
				if(graph[i][node-'A'])	
					break;
				// if can't even find a parent for 'node', it's a root
				if(i == 25) {
					root = node;
					rootNum ++;
					if(rootNum > 1)	E4 = true;
					boolean[] visited = new boolean[26];
					if(detectCycle(node, graph, visited))
						return "E3";
				}
			}
			
		}
		
		if(rootNum == 0)	return "E3";
		if(E4)	return "E4";
		
		// part 3 : multi parent
		for(int i = 0; i < 26; i++) {
			int numOfParent = 0;
			for(int j = 0; j < 26; j++) {
				if(graph[j][i])	
					numOfParent ++;
			}
			if(numOfParent > 1)	return "E5";
		}
		return getExpression(root, graph);
	}
	
	public static String getExpression(char root, boolean[][] graph) {
		String left = "", right = "";
		for(int i = 0; i < 26; i++) {
			// first child, lower char ganranteed
			if(graph[root-'A'][i]) {
				left = getExpression((char)('A' + i), graph);
				for(int j = i+1; j < 26; j++) {
					if(graph[root-'A'][j]) {
						right = getExpression((char)('A' + j), graph);
						break;
					}
				}
				break;
			}
		}
		
		return "(" + root + left + right + ")";
	}
	
	public static boolean detectCycle(char node, boolean[][] graph, boolean[] visited) {
		if(visited[node-'A'])	return true;
		
		visited[node-'A'] = true;
		for(int i = 0; i < 26; i++) {
			if(graph[node-'A'][i])
				if(detectCycle((char)('A' + i), graph, visited))
					return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		String[] s = {"(A,B) (A,C) (B,G) (C,H) (E,F) (B,D) (C,E)",
				"(B,D) (D,E) (A,B) (C,F) (E,G) (A,C)",
				"(A,B) (A,C) (B,D) (D,C)",
				"(H,A) (B,D) (D,E) (A,B) (C,F) (E,G) (A,C) (H,I)",
				"(A,B) (A,C) (B,D) (C,D)"};
		for(String str : s) {
			System.out.println(getSExpress(str));
			System.out.println("-------------------------");
		}
	}
}
