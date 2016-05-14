package heap;

import java.lang.reflect.Array;

public class Heap<T extends Comparable<T> > {
	private T[] heap = null;
	private int position;
	
	public Heap (Class<T> c, int size) {
		@SuppressWarnings("unchecked")
		T[] a = (T[]) Array.newInstance(c, size);
		heap = a;
	}
	
	public int size(){
		return heap.length;
	}
	
	public boolean offer(T t) {
		if(t == null)	throw new NullPointerException();
		if(position == heap.length-1)	return false;
		if(position == 0){
			heap[0] = t;
		} else {
		}
		return true;
	}
	
	public void shiftUp(int k) {
		T tmp = heap[k];
		int child;

	    for(; 2*k <= size(); k = child) {
	    	child = 2*k;
	    	
	    	if(child != size() && heap[child].compareTo(heap[child + 1]) > 0) 
	    		child++;
	
	    	if(tmp.compareTo(heap[child]) > 0)  
	    		heap[k] = heap[child];
	    	else
	            break;
	   }
	      heap[k] = tmp;
	}
}
