package normal;

import java.util.*;

public class MostCloesetPoint {
	public static List<Point> findMostCloseset(List<Point> points, int k) {
		List<Point> result = new ArrayList<Point>();
		Map<Double, List<Point>> map = new TreeMap<>();
		for (Point point : points) {
			double distance = Math.pow(point.x - 5, 2) + Math.pow(point.y - 5, 2);
			if (!map.containsKey(distance))
				map.put(distance, new ArrayList<Point>());
			map.get(distance).add(point);
		}
		int count = 0;
		for (double key : map.keySet()) {
			for (Point point : map.get(key)) {
				result.add(point);
				count++;
				if (count == k)
					return result;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<Point> points = Arrays.asList(new Point(-2, -4), new Point(0, 0), new Point(10, 15), new Point(5, 6),
				new Point(7, 8), new Point(-10, -30), new Point(4, 9));
		System.out.println(findMostCloseset(points, 2).toString());
	}
}

class Point {
	public int x;
	public int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "" + this.x + " " + this.y;
	}
}
