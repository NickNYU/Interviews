package zenefits;

import java.util.*;

class GraphNode {
	public int val;
	public Set<GraphNode> neighbors;
	
	public GraphNode(int v) {
		this.val = v;
		neighbors = new HashSet<GraphNode> ();
	}
	
	@Override
	public int hashCode() {
		return this.val;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o.getClass() != GraphNode.class) {
			return false;
		}
		
		GraphNode node = (GraphNode) o;
		if(node.val != this.val)
			return false;
		
		return true;
	}
}
