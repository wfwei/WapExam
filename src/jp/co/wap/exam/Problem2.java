package jp.co.wap.exam;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import jp.co.wap.exam.lib.Interval;

public class Problem2 {

	public int getMaxWorkingTime(List<Interval> intervals) {
		
		if(intervals == null || intervals.size()==0){
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

	public int getMaxWorkingTime2(List<Interval> intervals) {
		
		if(intervals == null || intervals.size()==0){
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
		int[] dp = new int[max];
		int maxn = 0;

		for (int i = 1; i < dp.length; i++) {
			if (endTimeMap.containsKey(i)) {
				for (Interval itv : endTimeMap.get(i)) {

					int bt = itv.getBeginMinuteUnit();
					int et = itv.getEndMinuteUnit();

					int lastn = bt > 0 ? dp[bt - 1] : 0;

					if (lastn + itv.getIntervalMinute() > dp[et])
						dp[et] = lastn + itv.getIntervalMinute();
					if (dp[et] > maxn)
						maxn = dp[et];
				}
			} else
				dp[i] = dp[i - 1];
		}

		return maxn;
	}

}
