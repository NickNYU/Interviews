package inferInterview;

/**
 * @author Chen
 * 
 * By using topology sort to solve this problem, it's a typically DFS
 * 
 * So, the Time Complexity should be O(n), n is the number of graph nodes
 * 
 * Please input the number of lines first, in other word, it's an integer value
 */
import java.util.*;

public class Main {
	//@Field : set is to store the nodes that we have (the cities we have)
	private Set<GraphNode> set = new HashSet<GraphNode> ();
	
	public static void main(String[] args) {
        Main flys = new Main();
        flys.readIn();
        List<String> path = flys.findPath();
        System.out.println("After sort, the result should be : ");
        for(int i = 0; i < path.size()-1; i++) {
        	System.out.println(path.get(i) + " " + path.get(i+1));
        }
    }
	
	// @Method : read from stdin, convert every line into graph nodes
	public void readIn() {
		// @Field : map is used to store the graph node, we don't want to create duplicate nodes
		Map<String, GraphNode> map = new HashMap<String, GraphNode> ();
		Scanner in = null;
		try {
			in = new Scanner(System.in);
			System.out.println("Please type in the lines you are going to input");
			int t = 0;
			try{
				t = Integer.parseInt(in.nextLine());
			} catch (Exception e) {
				System.out.println("Input Error, Please input the number of lines first");
			}
			System.out.println("Begin to input pair of city names");
			while(t-- > 0) {
				String line = in.nextLine();
				// every line is a pair of string (city names)
				String[] pair = line.split(" ");
				GraphNode departure = null, destination = null;
				// if we already created the node before, we pick up from the map
				// otherwise, we create new one, then store the reference of the object in dictionary
				if(map.containsKey(pair[0])) {
					departure = map.get(pair[0]);
				} else {
					departure = new GraphNode(pair[0]);
					map.put(pair[0], departure);
				}
				if(map.containsKey(pair[1])) {
					destination = map.get(pair[1]);
				} else {
					destination = new GraphNode(pair[1]);
					map.put(pair[1], destination);
				}
				// To build the graph, we consider the destination is a neighbor node
				departure.neighbors.add(destination);
				//
				this.set.add(departure);
				this.set.add(destination);
			} 
			
		} catch(Exception e) {
			System.out.println("Input Error, Please input in pairs separated by space");
		} finally {
			in.close();
		}
		//System.out.println(this.set.toString());
	}
	
	// Topology Sort
	public List<String> findPath() {
		// stack to store the path
		Stack<GraphNode> path = new Stack<GraphNode> ();
		// visited is used to escape duplicate visit
		Set<GraphNode> visited = new HashSet<GraphNode> ();
		for(GraphNode current : this.set) {
			if(!visited.contains(current)) {
				dfs(current, path, visited);
			}
		}
		return convertToList(path);
	}
	
	private List<String> convertToList(Stack<GraphNode> stack) {
		List<String> result = new ArrayList<String> ();
		while(!stack.isEmpty()) {
			//System.out.println(stack.peek().city);
			result.add(stack.pop().city);
		}
		return result;
	}
	
	private void dfs(GraphNode node, Stack<GraphNode> stack, Set<GraphNode> visited) {
		//if(visited.contains(node))	return;
		visited.add(node);
		for(GraphNode neighbor : node.neighbors) {
			if(!visited.contains(neighbor))
				dfs(neighbor, stack, visited);
		}
		stack.push(node);
	}
}
