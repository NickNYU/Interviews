package yiMuSanFenDi;

import tools.ListNode;
import tools.AssortedMethod;

public class LinedListPalindrome {
	public static boolean isListPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;
		ListNode slow = head, fast = head;
		ListNode prev = null;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = null;
		ListNode l2 = reverse(slow);
		ListNode l1 = head;
		while (l1 != null) {
			if (l1.val != l2.val)
				return false;
			l1 = l1.next;
			l2 = l2.next;
		}
		return true;
	}

	public static ListNode reverse(ListNode head) {
		ListNode l1 = head, l2 = head.next, l3 = null;
		while (l2 != null) {
			l3 = l2.next;
			l2.next = l1;
			l1 = l2;
			l2 = l3;
		}
		head.next = null;
		return l1;
	}

	public static void test() {
		int[] arr1 = { 1, 2, 3, 4, 5, 6 };
		int[] arr2 = {};
		int[] arr3 = { 2, 1, 2 };
		int[] arr4 = { 2, 1, 3, 3, 1, 2 };
		System.out.println(isListPalindrome(AssortedMethod.generateListWithArray(arr1)));
		System.out.println(isListPalindrome(AssortedMethod.generateListWithArray(arr2)));
		System.out.println(isListPalindrome(AssortedMethod.generateListWithArray(arr3)));
		System.out.println(isListPalindrome(AssortedMethod.generateListWithArray(arr4)));
	}

	public static void main(String[] args) {
		test();
	}
}
