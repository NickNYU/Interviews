package zenefits;

import java.util.*;

class TrieNode {
	public int val;
	public Set<TrieNode> children;
	
	public TrieNode(int v) {
		this.val = v;
		children = new HashSet<TrieNode> ();
	}
}
