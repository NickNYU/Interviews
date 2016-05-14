package zenefits;

import java.util.*;

public class SkipList {
	public SkipListEntry head;
	public SkipListEntry tail;
	
	public int size;
	
	public int maxLevel;
	
	public Random random;
	
	public SkipList() {
		
		SkipListEntry p1, p2;

	     /* -----------------------------------
	        Create an -oo and an +oo object
		----------------------------------- */
	     p1 = new SkipListEntry(SkipListEntry.negInf, null);
	     p2 = new SkipListEntry(SkipListEntry.posInf, null);


	     /* --------------------------------------
	        Link the -oo and +oo object together
		--------------------------------------- */
	     p1.next = p2;
	     p2.prev = p1;

	     /* --------------------------------------
	        Initialize "head" and "tail"
		--------------------------------------- */
	     head = p1;
	     tail = p2;

	     /* --------------------------------------
	        Other initializations
		--------------------------------------- */
	     size = 0;                   // No entries in Skip List
	     maxLevel = 0;		      	// Height is 0

	     random = new Random();	      // Make random object to simulate coin toss
	}
	
	/* ------------------------------------------------------
    findEntry(k): find the largest key x <= k
                  on the LOWEST level of the Skip List
    ------------------------------------------------------ */
	public SkipListEntry findEntry(String k) {
		SkipListEntry p;
		
		/* -----------------
        Start at "head"
        ----------------- */
		p = head;
		while(true) {
			/* ------------------------------------------------
	           Search RIGHT until you find a LARGER entry

	           E.g.: k = 34

	                     10 ---> 20 ---> 30 ---> 40
	                                      ^
	                                      |
	                                      p must stop here
			p.right.key = 40
	           ------------------------------------------------ */ 
			while(p.next.key != SkipListEntry.negInf && p.next.key.compareTo(k) <= 0) {
				p = p.next;
			}
			/* ---------------------------------
	           Go down one level if you can...
	           --------------------------------- */
			if(p.down != null) {
				p = p.down;
			} else {
				break;               // out of the cycle
			}
			
		}
		
		return p;
	}
	
	public Integer get(String k) {
		SkipListEntry p;
		
		p = findEntry(k);
		
		if(k.equals(p.key)) {
			return p.val;
		} else {
			return null;
		}
	}
	
	public Integer put(String k, Integer v) {
		SkipListEntry p;
		
		p = findEntry(k);
		
		/* ------------------------
        Check if key is found
        ------------------------ */
	     if ( k.equals(p.key) ) { // If key found, update the value and we are done...
	        Integer old = p.val;         // Remember the old value
	
	        p.val = v;                   // Update value
	
	        return(old);		       // Return the old value
	     }
		
	     /* -------------------------------------------------------------
	        Key k is not found, then p = floorEntry(k) (See: click here)

	        The rest of the code will insert a new entry (k,v)
	        ------------------------------------------------------------- */

	     SkipListEntry q = new SkipListEntry(k,v);       // Create a new entry with k and v   

	     /* --------------------------------------------------------------
	        Insert q into the lowest level after SkipListEntry p:

	                         p   put q here           p        q
	                         |     |                  |        |
			         V     V                  V        V        V
	        Lower level:    [ ] <------> [ ]    ==>  [ ] <--> [ ] <--> [ ]
	        --------------------------------------------------------------- */
	     q.prev = p;
	     q.next = p.next;
	     p.next.prev = q;
	     p.next = q;

	     /* -----------------------------------------------------
	        Make a "tower" of the entry e or RANDOM height
		----------------------------------------------------- */
		int currentLevel = 0;
		while(random.nextDouble() < 0.5) {	/* Coin toss */
			/* -------------------------------------------------------------------
			   Check if we need to increase the height of the -oo and +oo "pillars
			   ------------------------------------------------------------------- */
			if(currentLevel >= maxLevel) {
				addLayer();
			}
			/* ------------------------------------
	           Find first element with an UP-link
	           ------------------------------------ */
			while(p.up == null) {
				p = p.prev;
			}
			
			/* --------------------------------
			   Make p point to this UP element
			   -------------------------------- */
			p = p.up;
			
			SkipListEntry e;
	   		 
		   	e = new SkipListEntry(k, null);  // Don't need the value...
		   	
		   	/* ---------------------------------------
		   	   Initialize links of e
		   	   --------------------------------------- */
		   	e.prev = p;
		   	e.next = p.next;
		   	p.next.prev = e;
		   	p.next = e;
		   	
		   	e.down = q;
		   	q.up = e;
		   	
		   	// take it to the next layer
		   	q = e;
		   	
		   	currentLevel ++;
		}
		size ++;
		
		return null;
	}
	
	private void addLayer() {
		SkipListEntry p1, p2;

		   /* -----------------------------
		      Make the -oo and +oo entries
		      ---------------------------- */
		p1 = new SkipListEntry(SkipListEntry.negInf, null);        
		p2 = new SkipListEntry(SkipListEntry.posInf, null);

		   /* --------------------
		      Link them
		      -------------------- */
		p1.next = p2;
		p1.down  = head;

		p2.prev = p1;
		p2.down = tail;

		head.up = p1;
		tail.up = p2;

		   /* --------------------
		      Update head and tail
		      -------------------- */
		head = p1;
		tail = p2;

		maxLevel += 1;         // One more level...
	}
	
	public SkipListEntry remove(String k) {
		SkipListEntry p = findEntry(k);

		if (!p.key.equals(k))
		    return	null;     // Not found, don't remove

		   /* ------------------------------------------------------------
		      We are at level 0
		      Travel up the tower and link the left and right neighbors
		      ------------------------------------------------------------ */        
		while ( p != null )	{
		      p.prev.next = p.next;
		      p.next.prev = p.prev;
		      
		      p = p.up;
		}
		
		return p;
	}
}


class SkipListEntry {
	public String key;
	public Integer val;
	
	public SkipListEntry up;
	public SkipListEntry down;
	public SkipListEntry prev;
	public SkipListEntry next;
	
	public static String negInf = "-oo";  // -inf key value
    public static String posInf = "+oo";  // +inf key value
    
    public SkipListEntry (String key, Integer val) {
    	this.key = key;
    	this.val = val;
    }
}