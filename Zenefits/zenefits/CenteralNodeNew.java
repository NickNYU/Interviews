package zenefits;

import java.util.*;

public class CenteralNodeNew {
	
	public static GraphNode getCentralNodeNaive(GraphNode[] graph) {
		GraphNode central = null;
		int sum = Integer.MAX_VALUE;
		Set<Integer> visited = new HashSet<Integer> ();
		for(GraphNode node : graph) {
			
			int currentSum = BFS(node, 0, visited);
			if(currentSum < sum) {
				sum = currentSum;
				central = node;
			}
			visited.clear();
		}
		
		System.out.println(sum);
		return central;
	}
	
	public static int BFS(GraphNode node, int degree, Set<Integer> visited) {
		if(visited.contains(node.val))	return 0;
		visited.add(node.val);
		
		int sum = degree;
		for(GraphNode neighbor : node.neighbors) {
			sum += BFS(neighbor, degree+1, visited);
		}
		
		return sum;
	}
	
	
	// 1. build tree, set randomly node as root
	// 2. calculate the weight of the tree
	// 3. go through the tree, calculate weight of the tree for every node as the root
	public static GraphNode getCentralNode(GraphNode[] graph) {
		//part 1
		int rootIndex = new Random().nextInt(graph.length); // 0 ~ n-1
		Set<Integer> visited = new HashSet<Integer> ();
		TrieNode root = buildTrie(graph[rootIndex], visited);
		// part 2
		Map<TrieNode, Integer> map = new HashMap<TrieNode, Integer> ();
		int weight = getWeight(root, map);
		// part 3
		Recorder record = new Recorder();
		record.sum = weight;
		record.node = root;
		findCentral(root, record, map, weight);
		System.out.println(record.sum);
		return graph[record.node.val];
	}
	
	public static TrieNode buildTrie(GraphNode node, Set<Integer> visited) {
		if(visited.contains(node.val))	return null;
		
		visited.add(node.val);
		TrieNode root = new TrieNode(node.val);
		for(GraphNode neighbor : node.neighbors) {
			TrieNode child = buildTrie(neighbor, visited);
			if(child != null)	root.children.add(child);
		}
		
		return root;
	}
	
	public static int getWeight(TrieNode root, Map<TrieNode, Integer> map) {
		if(root.children.size() == 0) {
			map.put(root, 0);
			return 0;
		}
		
		int sum = 0, numOfDescendant = root.children.size();
		for(TrieNode child : root.children) {
			sum += getWeight(child, map);
			numOfDescendant += map.get(child);
		}
		map.put(root, numOfDescendant);
		
		return sum + numOfDescendant;
	}
	
	public static void findCentral(TrieNode root, Recorder record, Map<TrieNode, Integer> map, int sum) {
		int size = map.size();
		for(TrieNode child : root.children) {
			int descendant = map.get(child);
			int currentSum = sum + size - 2 * (descendant + 1);
			if(currentSum < record.sum) {
				record.sum = currentSum;
				record.node = child;
			}
			
			findCentral(child, record, map, currentSum);
		}
	}
	
	public static void main(String[] args) {
		GraphNode[] graph = prepare2();
		System.out.println(getCentralNodeNaive(graph).val);
		System.out.println("----------------------------");
		System.out.println(getCentralNode(graph).val);
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
	
	public static GraphNode[] prepare2() {
		GraphNode[] graph = new GraphNode[3];
		for(int i = 0; i < graph.length; i++)
			graph[i] = new GraphNode(i);
		graph[0].neighbors.add(graph[1]);
		graph[2].neighbors.add(graph[1]);
		graph[1].neighbors.add(graph[0]);
		graph[1].neighbors.add(graph[2]);
		return graph;
	}
}

class Recorder {
	TrieNode node = null;
	int sum = Integer.MAX_VALUE;
	
}
