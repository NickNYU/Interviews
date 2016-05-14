package tree;

import java.util.*;

public class PrefixTree {
	public TreeNode root = new TreeNode('\0');
	private final char relative;
	public PrefixTree(Build builder){
		relative = builder.fakeRelative;
	}
	
	public static class Build{
		private char fakeRelative;
		public Build relative(char c){
			fakeRelative = c;
			return this;
		}
		public PrefixTree build(){
			return new PrefixTree(this);
		}
	}
	
	public void insert(String word){
		char[] arr = word.toCharArray();
		TreeNode node = root;
		for(int i=0;i<arr.length;i++){
			int index = arr[i]-relative;
			if(node.children[index] == null){
				node.children[index] = new TreeNode(arr[i]);
			}
			node = node.children[index];
		}
		node.isWord = true;
		node.word = word;
	}
	
	public boolean find(String word){
		char[] arr = word.toCharArray();
		TreeNode node = root;
		for(char c : arr){
			int index = c - relative;
			if(node.children[index] == null){
				return false;
			}
			node = node.children[index];
		}
		return node.isWord;
	}
	
	public List<String> preOrderTraversal(){
		List<String> result = new ArrayList<String> ();
		Stack<TreeNode> stack = new Stack<TreeNode> ();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			if(node.isWord){
				result.add(node.word);
			}
			for(int i=node.children.length-1;i>=0;i--){
				TreeNode successor = node.children[i];
				if(successor != null)	stack.push(successor);
			}
		}
		return result;
	}
}

class TreeNode{
	char letter;
	TreeNode[] children;
	boolean isWord;
	String word;
	
	public TreeNode(char l){
		this.letter = l;
		children = new TreeNode[26];
		isWord = false;
	}
}