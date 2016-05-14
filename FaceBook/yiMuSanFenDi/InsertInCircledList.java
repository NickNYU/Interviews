package yiMuSanFenDi;

import tools.ListNode;
import tools.AssortedMethod;

public class InsertInCircledList {
	// there are three cases : smaller than head, bigger than tail, normally in
	// the middle
	public static ListNode insertInSortedCircle(ListNode head, int val) {
		ListNode node = new ListNode(val);
		node.next = node;
		if (head == null)
			return node;
		ListNode current = head;
		if (val < head.val) {
			while (current.next != head)
				current = current.next;
			current.next = node;
			node.next = head;
			return node;
		} else {
			while (current.next.val <= val && current.next != head) {
				// System.out.println(current.val + ": " + val);
				current = current.next;
			}
			ListNode temp = current.next;
			current.next = node;
			node.next = temp;
			return head;
		}
	}

	public static ListNode insertInSortedCircleII(ListNode head, int val) {
		ListNode node = new ListNode(val);
		node.next = node;
		// case 1 : null list
		if (head == null)
			return node;
		// case 2 : node is right after head
		head = breakListCircle(head);
		if (val < head.val) {
			node.next = head;
			head = node;
			return circleList(head);
		} else {
			ListNode current = head, prev = null;
			while (current != null && current.val <= val) {
				prev = current;
				current = current.next;
			}
			prev.next = node;
			node.next = current;
			return circleList(head);
		}
	}

	public static ListNode breakListCircle(ListNode head) {
		ListNode smallest = head, current = head.next, tail = null, prev = head;
		while (current != head) {
			if (current.val < smallest.val) {
				tail = prev;
				smallest = current;
			}
			prev = current;
			current = current.next;
		}
		if (tail != null)
			tail.next = null;
		else
			prev.next = null;
		// AssortedMethod.printList(smallest);
		return smallest;
	}

	public static ListNode circleList(ListNode head) {
		ListNode current = head;
		while (current.next != null)
			current = current.next;
		current.next = head;
		return head;
	}

	public static ListNode insertNode(ListNode head, int val) {
		ListNode a = new ListNode(val);
		if (head == null) {
			a.next = a;
			return a;
		}
		ListNode cur = head;
		while (cur.next != head && !(a.val >= cur.val && a.val < cur.next.val)) {
			cur = cur.next;
		}
		ListNode c = cur.next;
		cur.next = a;
		a.next = c;
		if (a.next == head)
			head = a.val > head.val ? head : a;
		return head;
	}

	public static void main(String[] args) {
		ListNode head = AssortedMethod.generateCircle(6);
		// head = insertInSortedCircle(head, 6);
		// AssortedMethod.printList(head);
		// head = head.next.next;
		AssortedMethod.printList(head);
		head = insertNode(head, 1);
		AssortedMethod.printList(head);
	}
}
