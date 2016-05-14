package hard;

/*
 * Given an integer array with no duplicates. A max tree building on this array is defined as follow:

		The root is the maximum number in the array
		The left subtree and right subtree are the max trees of the subarray divided by the root number.
 * 
 * 思路： O(n)的时间复杂度，用一个 stack 放树的节点， 每次有新的进来， 我们一直pop到空或者peek 大于 current node为止
 * 如果是第一种情况，那就说明目前最大，就是root， 那刚才那个最大的时之前出现过的（等于在现在的左端） 所以是左子树
 * 如果是第二种情况，那就说明目前不是最大的，那么stack顶比现在还大，现在的树节点就是peek的右子树，现在的左子树还是刚刚pop出去的
 */
import tools.TreeNode;
import java.util.*;

public class MaxTree {
	
	public static TreeNode generateMaxTree(int[] arr) {
		Stack<TreeNode> stack = new Stack<TreeNode> ();
        for(int num : arr) {
           TreeNode current = new TreeNode(num);
           if (!stack.isEmpty()) {
               TreeNode left = stack.peek();
               // find the smaller one than current one
               while(!stack.isEmpty() && stack.peek().val < num) {
                   left = stack.pop();
               }
    
               if (stack.isEmpty())
                   current.left = left;
               else{
                   current.left = stack.peek().right;
                   stack.peek().right = current;
               }
           }
               
           stack.push(current);
        }
        TreeNode root = stack.pop();
        while(!stack.isEmpty()) {
        	root = stack.pop();
        }
        return root;
	}
	
	public static void main(String[] args) {
		int[] arr = {2, 5, 6, 0, 3, 1};
		TreeNode root = generateMaxTree(arr);
		TreeNode.printTree(root);
	}
}
