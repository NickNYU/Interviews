package yiMuSanFenDi;

import java.util.Stack;

public class TopologySort {
	private Stack<Integer> reversePost;
	private boolean[] marked;
	public TopologySort(Digraph G) {
		reversePost = new Stack<Integer> ();
		marked = new boolean[G.V()];
		for(int v = 0; v < G.V(); v++) {
			if(!marked[v])	dfs(G, v);
		}
	}
	
	public void dfs(Digraph G, int v) {
		marked[v] = true;
		for(int w : G.adj(v)) {
			if(!marked[w])	dfs(G, w);
		}
		reversePost.push(v);
	}
	
	public Iterable<Integer> reversePost() {
		return reversePost;
	}
}
