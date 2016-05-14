package careerCup;

/*
 * All segment point is on circle x^2 + y^2 = 1
 * find the largest set of segment that no one is intersect
 * */
import java.util.*;

public class IntersectSegment {
	public Set<Segment> largestSetOfSegment(Segment[] segments) {
		Set<Segment> set = new HashSet<Segment>();
		for (int i = 0; i < segments.length; i++) {
			for (int j = i + 1; j < segments.length; j++) {
			}
		}
		return set;
	}

	public boolean isIntersect(Segment s1, Segment s2) {
		// case 1 : have at least one point in common
		if (s1.x1 == s2.x1 && s1.y1 == s2.y1)
			return true;
		if (s1.x2 == s2.x2 && s1.y2 == s2.y2)
			return true;
		// case 2 : s1.x1 > s2.x1 but s1.x2 < s2.x2
		if (s1.x1 < s2.x1 && s1.x2 > s2.x2)
			return true;
		if (s1.x1 > s2.x1 && s1.x2 < s2.x2)
			return true;
		if (s1.x1 < s2.x2 && s1.x2 > s2.x1)
			return true;
		if (s1.x1 > s2.x2 && s1.x2 < s2.x1)
			return true;
		return false;
	}
}

class Segment {
	public double x1;
	public double y1;
	public double x2;
	public double y2;

	public Segment(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Segment)) {
			return false;
		} else if (obj == this) {
			return true;
		}
		Segment s = (Segment) obj;
		if (s.x1 == this.x1 && s.y1 == this.y1 && s.x2 == this.x2 && s.y2 == this.y2)
			return true;
		return false;
	}

	@Override
	public int hashCode() {
		return (int) (x1 * 1000 + y1 * 100 + x2 * 10 + y2);
	}
}
