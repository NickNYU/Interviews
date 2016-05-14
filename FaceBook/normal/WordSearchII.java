package normal;

import java.util.*;

public class WordSearchII {
	private TreeNode root = new TreeNode('\0');

	public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
		// write your code here
		// Map<String,List<String>> map = new HashMap<String,List<String>> ();
		// for(List<String> lists : map.values()){
		//
		// }
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				buildPath(board, i, j, root, visited);
			}
		}
		ArrayList<String> result = new ArrayList<String>();
		find(words, root, result);
		return result;
	}

	public void buildPath(char[][] board, int row, int col, TreeNode node, boolean[][] visited) {
		if (row < 0 || row > board.length - 1)
			return;
		if (col < 0 || col > board[0].length - 1)
			return;
		if (visited[row][col])
			return;
		visited[row][col] = true;
		int index = board[row][col] - 'a';
		TreeNode nextnode = null;
		if (node.children[index] != null) {
			nextnode = node.children[index];
		} else {
			nextnode = new TreeNode(board[row][col]);
			node.children[index] = nextnode;
		}
		buildPath(board, row + 1, col, nextnode, visited);
		buildPath(board, row - 1, col, nextnode, visited);
		buildPath(board, row, col + 1, nextnode, visited);
		buildPath(board, row, col - 1, nextnode, visited);
		visited[row][col] = false;
	}

	public void find(ArrayList<String> words, TreeNode node, ArrayList<String> result) {
		for (String word : words) {
			if (exist(word, node, 0)) {
				result.add(word);
			}
		}
	}

	public boolean exist(String word, TreeNode node, int index) {
		if (index == word.length())
			return true;
		char letter = word.charAt(index);
		int position = letter - 'a';
		if (node.children[position] == null)
			return false;
		return exist(word, node.children[position], index + 1);
	}

	public static void main(String[] args) {
		WordSearchII search = new WordSearchII();
		String[] arr = { "dog", "dad", "dgdg", "can", "again" };
		ArrayList<String> words = new ArrayList<String>();
		for (String word : arr) {
			words.add(word);
		}
		char[][] board = { { 'd', 'o', 'a', 'f' }, { 'a', 'g', 'a', 'i' }, { 'd', 'c', 'a', 'n' } };
		ArrayList<String> result = search.wordSearchII(board, words);
		System.out.println(result.toString());
	}
}

class TreeNode {
	public char letter;
	public TreeNode[] children;

	public TreeNode(char c) {
		this.letter = c;
		children = new TreeNode[26];
	}
	/*
	 * public void buildPath(char[][] board, int row, int col, TreeNode node,
	 * boolean[][] visited) { if(row < 0 || row > board.length-1) return; if(col
	 * < 0 || col > board[0].length-1) return; if(visited[row][col]) return;
	 * visited[row][col] = true; int index = (int)(board[row][col]-'a');
	 * TreeNode nextnode = null; if(node.children[index] != null) { nextnode =
	 * node.children[index]; } else { nextnode = new TreeNode(board[row][col]);
	 * node.children[index] = nextnode; }
	 * buildPath(board,row+1,col,nextnode,visited);
	 * buildPath(board,row-1,col,nextnode,visited);
	 * buildPath(board,row,col+1,nextnode,visited);
	 * buildPath(board,row,col-1,nextnode,visited); visited[row][col] = false; }
	 */
}
