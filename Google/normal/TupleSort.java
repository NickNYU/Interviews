package normal;

import java.util.*;

public class TupleSort {
	private static Comparator<Tuple2> c1;

	public static Tuple2[] sort(Tuple1[] input) {
		int n = input.length;
		Tuple2[] result = new Tuple2[n*2];
		c1 = new Comparator<Tuple2> () {
			@Override
			public int compare(Tuple2 t1, Tuple2 t2) {
				return t1.val - t2.val;
			}
		};
		Queue<Tuple2> queue = new PriorityQueue<Tuple2> (4,c1);
		queue.offer(new Tuple2(input[0].id, input[0].left));
		queue.offer(new Tuple2(input[0].id, input[0].right));
		
		for(int i = 1; i < input.length; i++) {
			queue.offer(new Tuple2(input[i].id, input[i].left));
			queue.offer(new Tuple2(input[i].id, input[i].right));
			result[(i-1)*2] = queue.poll();
			result[(i-1)*2+1] = queue.poll();
		}
		result[input.length*2-2] = queue.poll();
		result[input.length*2-1] = queue.poll();
		
		return result;
	}
	
	public static void main(String[] args) {
		Tuple1[] input = { new Tuple1("a", 1, 10),new Tuple1("a", 2, 12),new Tuple1("a", 3, 11), new Tuple1("b", 4, 5), new Tuple1("c", 7, 8)};
		
		Tuple2[] output = sort(input);
		System.out.println(Arrays.toString(output));
		String str = "k//1";
		String[] test = str.split("/+");
		System.out.println(Arrays.toString(test));
	}
}

class Tuple1 {
	public String id;
	public int left;
	public int right;
	public Tuple1(String id, int left, int right) {
		this.id = id;
		this.left = left;
		this.right = right;
	}
	@Override
	public String toString() {
		return id + " " + String.valueOf(left) + " " + String.valueOf(right);
	}
}

class Tuple2 {
	public String id;
	public int val;
	public Tuple2(String id, int val) {
		this.id = id;
		this.val = val;
	}
	@Override
	public String toString() {
		return id + " " + String.valueOf(val);
	}
}