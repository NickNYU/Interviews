package tools;

import java.util.*;


public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode (int v){
		this.val = v;
		left = null;
		right = null;
	}
	
	public static void printTree(TreeNode root){
		List<List<Integer>> levelorder = new ArrayList<List<Integer>> ();
		levelOrder(root,levelorder,0);
		//int total = (int)Math.pow(2,levelorder.size())*2;
		for(int i=0; i<levelorder.size(); i++){
			List<Integer> list = levelorder.get(i);
			System.out.println(list.toString());
		}
	}
	
	@Override
	public String toString() {
		return String.valueOf(val);
	}
	
	public static void levelOrder(TreeNode root, List<List<Integer>> list, int level){
		if(root == null)	return;
		if(level == list.size()){
			list.add(new ArrayList<Integer> ());
		}
		list.get(level).add(root.val);
		levelOrder(root.left,list,level+1);
		levelOrder(root.right,list,level+1);
	}
}
