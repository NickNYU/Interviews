package hard;

import tools.TreeNode;

public class DeleteNodeInTree {
	public static TreeNode removeNode(TreeNode root, int value) {
		// write your code here
		if (root == null)
			return root;
		if (root.val > value) {
			root.left = removeNode(root.left, value);
		} else if (root.val < value) {
			root.right = removeNode(root.right, value);
		} else {
			// case 1 : no child
			if (root.left == null && root.right == null) {
				root = null;
				// case 2 : one child
			} else if (root.left == null) {
				root = root.right;
			} else if (root.right == null) {
				root = root.left;
				// case 3 : two children
			} else {
				TreeNode min = findMin(root.right);
				root.val = min.val;
				root.right = removeNode(root.right, min.val);
			}
		}
		return root;
	}

	public static TreeNode findMin(TreeNode root) {
		if (root.left != null)
			return findMin(root.left);
		else
			return root;
	}
}
