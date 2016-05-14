package zenefits;

import java.util.*;

public class BSTInorderIterator {
	Stack<TreeNode> stack = new Stack<TreeNode> ();
	
	public BSTInorderIterator(TreeNode root) {
		TreeNode current = root;
		while(current != null) {
			stack.push(current);
			current = current.left;
		}
	}
	
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	
	public TreeNode next() {
		if(!hasNext())	return null;
		
		TreeNode result = stack.pop();
		TreeNode current = result.right;
		while(current != null) {
			stack.push(current);
			current = current.left;
		}
		
		return result;
	}
}
