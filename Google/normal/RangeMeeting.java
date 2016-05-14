package normal;

import java.util.*;

class Interval{
	public int start;
	public int end;
	public Interval(int left, int right){
		this.start = left;
		this.end = right;
	}
	public Interval(){}
	@Override
	public String toString(){
		return String.format("<%d,%d>",start,end);
	}
}

public class RangeMeeting {
	
	public static List<Interval> getRanged (Interval[] person1, Interval[] person2) throws Exception {
		if(person1 == null || person2 == null) {
			throw new Exception("null pointer");
		}
		List<Interval> result = new ArrayList<Interval> ();
		List<Interval> meet1 = new ArrayList<Interval> ();
		List<Interval> meet2 = new ArrayList<Interval> ();
		
		for(int i=0;i<person1.length-1;i++){
			int start = person1[i].end;
			int end = person1[i+1].start;
			//System.out.println(start+"  "+end);
			if(start >= end)	continue;	
			Interval interval = new Interval(start,end);
			//System.out.println(interval);
			meet1.add(interval);
		}
		
		for(int i=0;i<person2.length-1;i++){
			int start = person2[i].end;
			int end = person2[i+1].start;
			if(start >= end)	continue;	
			Interval interval = new Interval(start,end);
			//System.out.println(interval);
			meet2.add(interval);
		}
		
		for(Interval meeting1 : meet1){
			for(Interval meeting2 : meet2){
				if(meeting1.end <= meeting2.start || meeting1.start >= meeting2.end){
					continue;
				}
				Interval meetTime = join(meeting1, meeting2);
				result.add(meetTime);
			}
		}
		return result;
	}
	
	public static Interval join(Interval interval1, Interval interval2){
		//System.out.println(interval1+"  "+interval2);
		int start = Math.max(interval1.start, interval2.start);
		int end = Math.min(interval1.end, interval2.end);
		return new Interval(start,end);
	}
	
	public static List<Interval> getRanged2(Interval[] person1, Interval[] person2){
		return null;
	}
	
	public static Interval[] arrayToInterval(int[][] arr){
		Interval[] intervals = new Interval[arr.length];
		for(int i = 0; i < arr.length; i++){
			intervals[i] = new Interval(arr[i][0],arr[i][1]);
		}
		return intervals;
	}
	
	public static void main(String[] args){
		int[][] arr1 = {
				{1,5}, 
				{10, 14},
				{19,20},
				{21,24}
		};
		
		int[][] arr2 = {
				{3,5}, 
				{12,15},
				{18, 21},
				{23, 24}
		};
		
		Interval[] person1 = arrayToInterval(arr1);
		Interval[] person2 = arrayToInterval(arr2);
		
		try{
			List<Interval> meetingTime = getRanged(person1, person2);
			for(Interval meet : meetingTime){
				System.out.println(meet);
			}
		} catch(Exception e){
			System.out.println(e);
		}
	}
}
