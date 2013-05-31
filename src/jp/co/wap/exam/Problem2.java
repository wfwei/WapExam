package jp.co.wap.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import jp.co.wap.exam.lib.Interval;

public class Problem2 {

	public int getMaxWorkingTime(List<Interval> intervals) {

		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				if (a.getEndMinuteUnit() > b.getEndMinuteUnit())
					return 1;
				else if (a.getEndMinuteUnit() < b.getEndMinuteUnit())
					return -1;
				else
					return 0;
			}
		});

		final int max = 24 * 60 + 1;
		int[] dp = new int[max];
		int maxn = 0;

		for (int i = 0, ptr = 0; i < dp.length && ptr < intervals.size();) {
			Interval itv = intervals.get(ptr);
			if (itv.getEndMinuteUnit() == i) {

				int bt = itv.getBeginMinuteUnit();
				int et = itv.getEndMinuteUnit();
				int lastn = 0;
				if (bt > 0)
					lastn = dp[bt - 1];
				if (lastn + itv.getIntervalMinute() > dp[et])
					dp[et] = lastn + itv.getIntervalMinute();
				if (dp[et] > maxn)
					maxn = dp[et];
				ptr++;
			} else {
				if (i > 0 && dp[i] < dp[i - 1])
					dp[i] = dp[i - 1];
				i++;
			}
		}

		return maxn;
	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval("08:00", "09:00"));
		intervals.add(new Interval("06:00", "08:30"));
		intervals.add(new Interval("09:00", "11:00"));
		intervals.add(new Interval("12:30", "14:00"));
		intervals.add(new Interval("10:30", "14:00"));
		intervals.add(new Interval("09:00", "11:30"));

		int count = new Problem2().getMaxWorkingTime(intervals);
		System.out.println(count);
	}

}
