package inferInterview;

import java.util.*;

class GraphNode {
	public String city;
	List<GraphNode> neighbors;
	
	public GraphNode(String city) {
		this.city = city;
		neighbors = new ArrayList<GraphNode> ();
	}
	
	public GraphNode(GraphNode node) {
		this.city = node.city;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GraphNode other = (GraphNode) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return this.city;
	}
}
