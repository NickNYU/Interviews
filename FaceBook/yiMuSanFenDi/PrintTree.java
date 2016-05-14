package yiMuSanFenDi;
/*
 * 
 * 1：print all path from root to leaf
 * 
 * */
import tools.TreeNode;
import tools.AssortedMethod;
import java.util.*;

public class PrintTree {
	public static void printTree(TreeNode root) {
		List<TreeNode> path = new ArrayList<TreeNode> ();
		printPath(root, path);
	}
	
	public static void printPath(TreeNode root, List<TreeNode> path) {
		if(root == null)	return;
		path.add(root);
		if(root.left == null && root.right == null) {
			for(TreeNode node : path)	
				System.out.print(node.val+" -> ");
			System.out.println("");
		}
		if(root.left != null) {
			printPath(root.left, path);
		}
		if(root.right != null) {
			printPath(root.right, path);
		}
		path.remove(path.size()-1);
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = AssortedMethod.createTree(arr, true);
		printTree(root);
	}
}
