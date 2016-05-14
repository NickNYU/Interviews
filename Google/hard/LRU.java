package hard;

import java.util.*;

public class LRU {
	private Node head;
	private Node tail;
	private Map<Integer,Node> map;
	private static LRU instance;
	
	private LRU(){
		head = null;
		tail = null;
		map = new HashMap<Integer,Node> ();
	}
	
	public static LRU getInstance(){
		if(instance == null){
			synchronized(LRU.class){
				if(instance == null){
					instance = new LRU();
				}
			}
		}
		return instance;
	}
	
	public int get(int key){
		synchronized(this){
			if(!map.containsKey(key))	return -1;
			Node node = map.get(key);
			remove(node);
			insert(node);
			return node.val;
		}
	}
	
	public void set(int key, int val) {
		synchronized(this) {
			
		}
	}
	
	private void remove(Node node){
		if(node.prev != null)	node.prev.next = node.next;
		if(node.next != null)	node.next.prev = node.prev;
		if(node == head)	head = node.next;
		if(node == tail)	tail = node.prev;
	}
	
	private void insert(Node node){
		if(head == null)	head = node;
		else{
			node.next = head;
			head.prev = node;
			node = head;
		}
		if(tail == null)	tail = node;
	}
}

class Node{
	public int key;
	public int val;
	public Node prev;
	public Node next;
	public Node(int k, int v){
		this.key = k;
		this.val = v;
		prev = null;
		next = null;
	}
}