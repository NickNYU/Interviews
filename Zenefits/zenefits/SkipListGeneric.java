package zenefits;

import java.util.*;


public class SkipListGeneric <K extends Comparable <? super K>, V> {
	public ListNode<K, V> head;
	public ListNode<K, V> tail;
	
	public int size;
	public int maxLevel;
	
	public Random random;
	
	public SkipListGeneric() {
		head = new ListNode<K, V> (null, null);
		tail = new ListNode<K, V> (null, null);
		
		head.next = tail;
		tail.prev = head;
		
		size = 0;
		maxLevel = 0;
		
		random = new Random();
	}
	
	public ListNode findNode(K k) {
		ListNode<K, V> p;
		
		p = head;
		while(true) {
			while(p.next.key != null && p.next.key.compareTo(k) <= 0) {
				p = p.next;
			}
			
			if(p.down != null) {
				p = p.down;
			} else {
				break;
			}
		}
		return p;
	}
	
	public V get(K k) {
		ListNode<K, V> p = findNode(k);
		
		if(p.key.equals(k)) {
			return p.val;
		} else {
			return null;
		}
	}
	
	public V put(K k, V v) {
		ListNode<K, V> p = findNode(k);
		
		if(p.key.equals(k)) {
			V oldVal = p.val;
			p.val = v;
			return oldVal;
		}
		
		//
		ListNode<K, V> q = new ListNode<K, V> (k, v);
		q.next = p.next;
		p.next.prev = q;
		p.next = q;
		q.prev = p;
		
		int currentLevel = 0;
		while(random.nextDouble() < 0.5) {
			if(currentLevel >= maxLevel) {
				addLayer();
			}
			
			ListNode<K, V> e = new ListNode<K, V> (k, null);
			
			while(p.up == null) {
				p = p.prev;
			}
			
			p = p.up;
			
			e.next = p.next;
			p.next.prev = e;
			p.next = e;
			e.prev = p;
			
			e.down = q;
			q.up = e;
			
			q = e;
			currentLevel ++;
		}
		size ++;
		
		return null;
	}
	
	private void addLayer() {
		ListNode<K, V> p = new ListNode<K, V> (null, null);
		ListNode<K, V> q = new ListNode<K, V> (null, null);
		
		p.next = q;
		q.prev = p;
		
		p.down = head;
		head.up = p;
		head = p;
		
		q.down = tail;
		tail.up = q;
		tail = q;
		
		maxLevel ++;
	}
	
	public ListNode remove(K k) {
		ListNode<K, V> p = findNode(k);
		
		if(!p.key.equals(k)) {
			return null;
		}
		
		while(p != null) {
			p.prev.next = p.next;
			p.next.prev = p.prev;
			
			p = p.up;
		}
		
		return p;
	}
}


class ListNode<K, V> {
	public K key;
	public V val;
	public ListNode<K, V> up, down, next, prev;
	
	public ListNode (K i, V v) {
		this.key = (K) i;
		this.val = (V) v;
	}
	
	public ListNode() {
		
	}
}