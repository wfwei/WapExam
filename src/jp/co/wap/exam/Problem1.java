package jp.co.wap.exam;

import java.util.List;
import java.util.PriorityQueue;
import jp.co.wap.exam.lib.Interval;

public class Problem1 {

	public int getMaxIntervalOverlapCount(List<Interval> intervals) {
		if (intervals == null || intervals.size() == 0) {
			return 0;
		}
		int maxCount = 0, curCount = 0;
		PriorityQueue<TimePoint> timePointQueue = new PriorityQueue<TimePoint>();
		for (Interval interval : intervals) {
			// insert sequence is important
			timePointQueue.add(new TimePoint(interval.getBeginMinuteUnit(),
					true));
			timePointQueue
					.add(new TimePoint(interval.getEndMinuteUnit(), false));
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
		return maxCount + 1;
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
			return 0;
		}

		public String toString() {
			return String.format("[%s, %s]", timeStamp, start);
		}

		public boolean isStart() {
			return start;
		}

	}
}
