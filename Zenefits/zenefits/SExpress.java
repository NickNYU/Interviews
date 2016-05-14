package zenefits;

import java.util.*;

/*
 * Error Code      Type of error
E1                 More than 2 children
E2                 Duplicate Edges
E3                 Cycle present. 1point 3acres 璁哄潧
E4                 Multiple roots
E5                 Any other error   */

public class SExpress {
	
	
	
	public static String constructSExpression(String s) {
        boolean[][] graph = new boolean[26][26];
        Set<Character> set = new HashSet<Character>();
        boolean E2 = false;
        int numOfEdges = 0;
        for (int i = 1; i < s.length(); i += 6) {
                int x = s.charAt(i) - 'A';
                int y = s.charAt(i + 2) - 'A';
                if (graph[x][y]) {
                        E2 = true;
                }
                graph[x][y] = true;
                set.add(s.charAt(i));
                set.add(s.charAt(i + 2));
                numOfEdges++;
        }
        
        boolean E1 = false;
        for (int i = 0; i < 26; i++) {
                int count = 0;
                for (int j = 0; j < 26; j++) {
                        if (graph[i][j]) {
                                count++;
                        }
                }
                if (count > 2) {
                        return "E1";
                }
        }
        if(E2) return "E2";

        int numOfRoots = 0;
        char root = ' ';
        
        // jkljlkjkllllllllllllllllllllllllllllll
        System.out.println(set);
        
        for (Character c : set) {
                for (int i = 0; i < 26; i++) {
                        if (graph[i][c - 'A']) {
                                break;
                        }
                        if (i == 25) {
                                numOfRoots++;
                                root = c;
                                boolean[] visited = new boolean[26];
                                if (detectCycle(c, graph, visited)) {
                                        return "E3";
                                }
                        }
                }
        }
        if (numOfRoots == 0) return "E3";
        if (numOfRoots > 1) return "E4";

        return getSexpression(root, graph);

	}

	private static boolean detectCycle(char c, boolean[][] graph, boolean[] visited) {
        if (visited[c - 'A']) return true;

        visited[c - 'A'] = true;
        for (int i = 0; i < 26; i++) {
                if (graph[c -'A'][i]) {
                        if (detectCycle((char)('A' + i), graph, visited)) {
                                return true;
                        }
                }
        }
        return false;
	}

	private static String getSexpression(char root, boolean[][] graph) {

        String left = "";
        String right = "";
        for (int i = 0; i < 26; i++) {
                if (graph[root - 'A'][i]) {
                        left = getSexpression((char)('A' + i), graph);
                        for (int j = i + 1; j < 26; j++) { 
                                if (graph[root - 'A'][j]) {
                                        right = getSexpression((char)('A' + j), graph);
                                        break;
                                }
                        }
                        break;
                }
        }


        return "(" + root + left + right + ")";

	}
	
	public static void main(String[] args) {
		String[] s = {"(A,B) (A,C) (B,G) (C,H) (E,F) (B,D) (C,E)",
				"(B,D) (D,E) (A,B) (C,F) (E,G) (A,C)",
				"(A,B) (A,C) (B,D) (D,C)",
				"(H,A) (B,D) (D,E) (A,B) (C,F) (E,G) (A,C)"};
		for(String str : s) {
			System.out.println(constructSExpression(str));
			System.out.println("-------------------------");
		}
	}
}
