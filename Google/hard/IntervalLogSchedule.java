package hard;

import java.util.*;

public class IntervalLogSchedule {
	public static long highestRamUsed (List<LogEntry> logs) {
		List<Log> newLogs = convertToLog(logs);
		Collections.sort(newLogs, new Comparator<Log> (){
			@Override
			public int compare(Log l1, Log l2) {
				if(l1.time > l2.time) {
					return 1;
				} else if(l1.time < l2.time) {
					return -1;
				} else {
					if(l1.isStart && !l2.isStart) {
						return -1;
					} else if(!l1.isStart && l2.isStart) {
						return 1;
					} else {
						return 0;
					}
				}
			}
		});
		long result = 0, local = 0;
		
		for(Log log : newLogs) {
			if(log.isStart) {
				local += log.ramUsed;
				result = Math.max(result, local);
			} else {
				local -= log.ramUsed;
			}
		}
		return result;
	}
	
	public static List<Log> convertToLog (List<LogEntry> logs) {
		List<Log> result = new ArrayList<Log> ();
		for(LogEntry log : logs) {
			Log startLog = new Log(log.startTime, true, log.id, log.ramUsed);
			Log endLog = new Log(log.endTime, false, log.id, log.ramUsed);
			result.add(startLog);
			result.add(endLog);
		}
		return result;
	}
	
	public static void main(String[] args) {
		List<LogEntry> logs = Arrays.asList(new LogEntry(1,3,"0",3), new LogEntry(9,11,"1",5), 
				new LogEntry(6,6,"2",1), new LogEntry(5,7,"3",1), new LogEntry(2,10,"4",2), new LogEntry(4,8,"5",1));
		System.out.println(highestRamUsed(logs));
	}
}

class LogEntry {
	public long startTime;
	public long endTime;
	public String id;
	public long ramUsed;
	public LogEntry (long start, long end, String id, long ram) {
		this.startTime = start;
		this.endTime = end;
		this.id = id;
		this.ramUsed = ram;
	}
}

class Log {
	public long time;
	public boolean isStart;
	public String id;
	public long ramUsed;
	
	public Log(long time, boolean start, String id, long ramUsed) {
		this.time = time;
		this.isStart = start;
		this.id = id;
		this.ramUsed = ramUsed;
	}
}