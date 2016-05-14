package tree;

import tools.TreeNode;
import tools.AssociatedMethod;

import java.util.*;

public class CloseM {
	
	public static List<TreeNode> findM(TreeNode root, int n, int key){
		List<TreeNode> result = new ArrayList<TreeNode> ();
		if(root == null)	return result;
		
		Queue<TreeNode> queue = new PriorityQueue<TreeNode> (n,new Comparator<TreeNode> (){
			
			@Override
			public int compare(TreeNode o1, TreeNode o2) {
				// TODO Auto-generated method stub
				int val1 = Math.abs(o1.val - key);
				int val2 = Math.abs(o2.val - key);
				if(val1 < val2){
					return 1;
				}else if(val1 > val2){
					return -1;
				}else{
					return 0;
				}
			}
		});
		goThrough(root,queue,n,key);
		while(!queue.isEmpty()){
			result.add(queue.poll());
		}
		return result;
	}
	
	public static void goThrough(TreeNode root, Queue<TreeNode> queue, int n, int key){
		if(root == null)	return;
		if(queue.size() < n){
			queue.offer(root);
		}else{
			int val = queue.peek().val;
			if(Math.abs(val - key) > Math.abs(root.val - key)){
				queue.poll();
				queue.offer(root);
			}
		}
		goThrough(root.left, queue, n, key);
		goThrough(root.right,queue, n, key);
	}
	
	public static void main(String[] args){
		TreeNode root = AssociatedMethod.generateTree(50);
		TreeNode.printTree(root);
		List<TreeNode> list = findM(root, 5, 10);
		for(TreeNode node : list){
			System.out.print(node.val+"  ");
		}
	}
}
