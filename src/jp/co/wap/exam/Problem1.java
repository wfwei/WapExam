package jp.co.wap.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import jp.co.wap.exam.lib.Interval;

public class Problem1 {

	/* collection.sort edition */
	public int getMaxIntervalOverlapCount(List<Interval> intervals) {
		if (intervals == null || intervals.size() == 0) {
			return 0;
		}
		List<TimePoint> timePoints = new ArrayList<TimePoint>();
		for (Interval interval : intervals) {
			timePoints.add(new TimePoint(interval.getBeginMinuteUnit(), true));
			timePoints.add(new TimePoint(interval.getEndMinuteUnit(), false));
		}

		Collections.sort(timePoints);

		int maxCount = 0, curCount = 0;
		for (TimePoint tp : timePoints) {
			if (tp.isStart())
				curCount++;
			else
				curCount--;
			if (curCount > maxCount)
				maxCount++;
		}
		return maxCount;
	}

	/* priority queue edition, a little slower */
	public int getMaxIntervalOverlapCount1(List<Interval> intervals) {
		if (intervals == null || intervals.size() == 0) {
			return 0;
		}
		int maxCount = 0, curCount = 0;
		PriorityQueue<TimePoint> timePointQueue = new PriorityQueue<TimePoint>();
		for (Interval interval : intervals) {
			timePointQueue
					.add(new TimePoint(interval.getEndMinuteUnit(), false));
			timePointQueue.add(new TimePoint(interval.getBeginMinuteUnit(),
					true));
		}
		while (!timePointQueue.isEmpty()) {
			TimePoint tp = timePointQueue.poll();
			if (tp.isStart())
				curCount++;
			else
				curCount--;
			if (curCount > maxCount)
				maxCount++;
		}
		return maxCount;
	}

	private static class TimePoint implements Comparable<TimePoint> {
		private final int timeStamp;
		private final boolean start;

		public TimePoint(int ts, boolean st) {
			this.timeStamp = ts;
			this.start = st;
		}

		@Override
		public int compareTo(TimePoint other) {
			if (this.timeStamp > other.timeStamp)
				return 1;
			else if (this.timeStamp < other.timeStamp)
				return -1;
			else if (!this.start)
				return 1;
			return -1;
		}

		public String toString() {
			return String.format("[%s, %s]", timeStamp, start);
		}

		public boolean isStart() {
			return start;
		}

	}
}
