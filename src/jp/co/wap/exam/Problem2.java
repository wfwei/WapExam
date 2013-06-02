package jp.co.wap.exam;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import jp.co.wap.exam.lib.Interval;

public class Problem2 {

	/* Time Complexity:O(NlogN) Space Complexity:O(1) Parameter is changed */
	public int getMaxWorkingTime(List<Interval> intervals) {

		if (intervals == null || intervals.size() == 0) {
			return 0;
		}

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
		final int[] dp = new int[max];

		int dpi = 1;
		for (Interval itv : intervals) {
			int bt = itv.getBeginMinuteUnit();
			int et = itv.getEndMinuteUnit();
			while (dpi <= et) {
				if (dp[dpi] < dp[dpi - 1])
					dp[dpi] = dp[dpi - 1];
				dpi++;
			}
			int lastn = bt > 0 ? dp[bt - 1] : 0;
			if (lastn + itv.getIntervalMinute() > dp[et])
				dp[et] = lastn + itv.getIntervalMinute();
		}

		return dp[dpi - 1];
	}

	/* Time Complexity:O(1)(Not so good in test) Space Complexity:O(N) */
	public int getMaxWorkingTime1(List<Interval> intervals) {

		if (intervals == null || intervals.size() == 0) {
			return 0;
		}

		HashMap<Integer, HashSet<Interval>> endTimeMap = new HashMap<Integer, HashSet<Interval>>(
				intervals.size());

		for (Interval itv : intervals) {
			if (!endTimeMap.containsKey(itv.getEndMinuteUnit()))
				endTimeMap.put(itv.getEndMinuteUnit(), new HashSet<Interval>());
			endTimeMap.get(itv.getEndMinuteUnit()).add(itv);
		}

		final int max = 24 * 60 + 1;
		final int[] dp = new int[max];

		for (int i = 1; i < dp.length; i++) {
			dp[i] = dp[i - 1];
			if (endTimeMap.containsKey(i)) {
				for (Interval itv : endTimeMap.get(i)) {

					int bt = itv.getBeginMinuteUnit();
					int et = itv.getEndMinuteUnit();
					int lastn = bt > 0 ? dp[bt - 1] : 0;

					if (lastn + itv.getIntervalMinute() > dp[et])
						dp[et] = lastn + itv.getIntervalMinute();
				}
			}
		}
		return dp[max - 1];
	}

}
