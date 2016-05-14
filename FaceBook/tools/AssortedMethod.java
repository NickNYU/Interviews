package tools;

import java.util.*;

public class AssortedMethod {
	public static void printList(ListNode head) {
		ListNode current = head;
		while (current != null && current.next != head) {
			System.out.print(current.val + "->  ");
			current = current.next;
		}
		if (current != null)
			System.out.print(current.val);
		System.out.println();
	}

	public static void printSet(Set<?> set) {
		Iterator<?> it = set.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + "  ");
		}
		System.out.println();
	}

	public static void printIntArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static TreeNode createTree(int[] arr, boolean isComplete) {
		TreeNode root = null;
		if (isComplete) {
			root = createCompleteTree(arr, 0, arr.length - 1);
		} else {
			root = createNonCompleteTree(arr, 0, arr.length - 1);
		}
		return root;
	}

	public static TreeNode createCompleteTree(int[] arr, int left, int right) {
		if (left > right)
			return null;
		int mid = (left + right) >> 1;
		TreeNode root = new TreeNode(arr[mid]);
		root.left = createCompleteTree(arr, left, mid - 1);
		root.right = createCompleteTree(arr, mid + 1, right);
		return root;
	}

	public static TreeNode createNonCompleteTree(int[] arr, int left, int right) {
		if (left > right)
			return null;
		else if (left == right)
			return new TreeNode(right);
		int quater = (left + right) / 4;
		TreeNode root = new TreeNode(arr[quater]);
		root.left = createNonCompleteTree(arr, left, quater - 1);
		root.right = createNonCompleteTree(arr, quater + 1, right);
		return root;
	}

	public static TreeNode createTreeWithString(String[] strs) {
		AssortedMethod.Wrap wrap = new AssortedMethod().new Wrap();
		wrap.index = 0;
		return helper(strs, wrap);
	}

	public static TreeNode helper(String[] strs, Wrap index) {
		if (strs[index.index].equals("#")) {
			return null;
		} else {
			TreeNode root = new TreeNode(Integer.parseInt(strs[index.index++]));
			root.left = helper(strs, index);
			root.right = helper(strs, index);
			return root;
		}
	}

	class Wrap {
		public int index;
	}

	public static ListNode generateCircle(int upper) {
		ListNode head = new ListNode(2);
		ListNode current = head;
		for (int i = 2; i <= upper; i++) {
			ListNode next = new ListNode(2 * i - 1);
			current.next = next;
			current = current.next;
		}
		current.next = head;
		return head;
	}

	public static ListNode generateListWithArray(int[] arr) {
		if (arr.length == 0)
			return null;
		ListNode head = new ListNode(arr[0]);
		ListNode current = head;
		for (int i = 1; i < arr.length; i++) {
			ListNode node = new ListNode(arr[i]);
			current.next = node;
			current = current.next;
		}
		return head;
	}
}
