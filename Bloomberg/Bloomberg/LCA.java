package Bloomberg;

import tools.AssociatedMethod;
import tools.TreeNode;

public class LCA {
	
	public static TreeNode ancester(TreeNode root, TreeNode node1, TreeNode node2){
		wrap ancester = new wrap();
		ancester.node = root;
		ancesterHelper(root,node1,node2,ancester);
		return ancester.node;
	}
	public static boolean isFather(TreeNode node1, TreeNode node2){
		if(node1 == node2)	return true;
		if(node1 == null || node2 == null)	return false;
		return isFather(node1.left,node2)||isFather(node1.right,node2);
	}
	public static void ancesterHelper(TreeNode root,TreeNode node1,TreeNode node2,wrap ancester){
		if(root==null||node1==null||node2==null)	return;
		if(root!=null&&isFather(root,node1)&&isFather(root,node2)){
			ancester.node = root;
			ancesterHelper(root.left,node1,node2,ancester);
			ancesterHelper(root.right,node1,node2,ancester);
		}
	}
	
	public static void main(String[] args){
		TreeNode root = AssociatedMethod.generateTree(10);
		TreeNode node1 = root.left.left.left.right;
		TreeNode node2 = root.left.right.right.left.right.left;
		TreeNode node = ancester(root,node1,node2);
		System.out.println(node.val);
		//System.out.println(root);
	}
}

class wrap{
	public TreeNode node;
}
