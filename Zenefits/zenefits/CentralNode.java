package zenefits;

import java.util.*;

public class CentralNode {
	
	private static int centerNum = 0;
	private static int weight = Integer.MAX_VALUE;
	public static GraphNode centralNode(GraphNode[] graph) {
		Map<TrieNode, Integer> map = new HashMap<TrieNode, Integer> ();
		Set<Integer> visited = new HashSet<Integer> ();
		
		Map<Integer, TrieNode> tree = new HashMap<Integer, TrieNode> ();
		centerNum = 2;//new Random().nextInt(graph.length);
		TrieNode root = getTree(graph[centerNum], visited, tree);
		
		weight = getWeight(root, map);
		
		getCenter(root, map, graph.length, weight);
		
		//for(TrieNode node : map.keySet())
			//System.out.println(node.val + " has children numbers : " + map.get(node));
		return graph[centerNum];
	}
	
	public static void getCenter(TrieNode root, Map<TrieNode, Integer> map, int size, int sum) {
		
		if(root.children.size() == 0)	return;
		
		 // sum' = sum + unchildren - children - 1
		// unchildren = size - (children + 1)
		// sum' = sum + size - 2 * (children + 1)
		
		for(TrieNode child : root.children) {
			int sumChild = sum + size - 2 * (map.get(child) + 1);
			if(sumChild < weight) {
				weight = sumChild;
				centerNum = child.val;
			}
			getCenter(child, map, size, sumChild);
		}
	}
	
	public static TrieNode getTree(GraphNode node, Set<Integer> visited, Map<Integer, TrieNode> map) {
		if(visited.contains(node.val))	return null;
		TrieNode root = new TrieNode(node.val);
		map.put(root.val, root);
		visited.add(node.val);
		
		for(GraphNode neighbor : node.neighbors) {
			if(!visited.contains(neighbor.val)) {
				TrieNode child = getTree(neighbor, visited, map);
				if(child != null)	root.children.add(child);
			}
		}
		
		System.out.println(node.val + "     " + root.children.size());
		System.out.println("===================");
		
		return root;
	}
	
	public static int getWeight(TrieNode root, Map<TrieNode, Integer> map) {
		if(root.children.size() == 0) {
			map.put(root, 0);
			System.out.println("Right now is node +  " + root.val + "and it has  " + 0 + "children");
			System.out.println("-----------------------------");
			return 0;
		}
		
		int weight = 0, childrenNum = root.children.size();
		for(TrieNode child : root.children) {
			weight += getWeight(child, map);
			childrenNum += map.get(child);
		}
		map.put(root, childrenNum);
		
		System.out.println("Right now is node +  " + root.val + "and it has  " + childrenNum + "children");
		System.out.println("-----------------------------");
		
		return weight + childrenNum;
	}
	
	
	public static void main(String[] args) {
		GraphNode[] graph = prepare();
		System.out.println(centralNode(graph).val);
		System.out.println("Minimum Weight :  " + weight + "  Minimum Num" + centerNum);
	}
	
	public static GraphNode[] prepare1() {
		GraphNode[] graph = new GraphNode[3];
		for(int i = 0; i < graph.length; i++)
			graph[i] = new GraphNode(i);
		
		graph[1].neighbors.add(graph[2]);
		graph[1].neighbors.add(graph[0]);
		graph[0].neighbors.add(graph[1]);
		graph[2].neighbors.add(graph[1]);
		
		return graph;
	}
	public static GraphNode[] prepare() {
		GraphNode node1 = new GraphNode(1);
		GraphNode node2 = new GraphNode(2);
		GraphNode node3 = new GraphNode(3);
		GraphNode node4 = new GraphNode(4);
		GraphNode node5 = new GraphNode(5);
		GraphNode node6 = new GraphNode(6);
		GraphNode node7 = new GraphNode(7);
		GraphNode node8 = new GraphNode(8);
		GraphNode node9 = new GraphNode(9);
		GraphNode node10 = new GraphNode(10);
		GraphNode node11 = new GraphNode(11);
		
		node1.neighbors.add(node3);
		node2.neighbors.add(node3);
		node3.neighbors.add(node1);
		node3.neighbors.add(node2);
		node3.neighbors.add(node5);
		node4.neighbors.add(node5);
		node5.neighbors.add(node3);
		node5.neighbors.add(node4);
		node5.neighbors.add(node6);
		node5.neighbors.add(node8);
		node6.neighbors.add(node5);
		node7.neighbors.add(node8);
		node8.neighbors.add(node5);
		node8.neighbors.add(node7);
		node8.neighbors.add(node9);
		node8.neighbors.add(node11);
		node9.neighbors.add(node8);
		node9.neighbors.add(node10);
		node10.neighbors.add(node9);
		node11.neighbors.add(node8);
		
		
		GraphNode[] graph = new GraphNode[11];
		graph[0] = node1;
		graph[1] = node2;
		graph[2] = node3;
		graph[3] = node4;
		graph[4] = node5;
		graph[5] = node6;
		graph[6] = node7;
		graph[7] = node8;
		graph[8] = node9;
		graph[9] = node10;
		graph[10] = node11;
		
		return graph;
	}
}

