package zenefits;

import java.util.*;

public class BSTReverseInorderIterator {
	
	Stack<TreeNode> stack = new Stack<TreeNode> ();
	
	public BSTReverseInorderIterator (TreeNode root) {
		TreeNode current = root;
		while(current != null) {
			stack.push(current);
			current = current.right;
		}
	}
	
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	
	public TreeNode next() {
		if(!hasNext())	return null;
		
		TreeNode result = stack.pop();
		TreeNode current = result.left;
		while(current != null) {
			stack.push(current);
			current = current.right;
		}
		
		return result;
	}
}
