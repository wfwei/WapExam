package jp.co.wap.exam;

import java.util.ArrayList;
import java.util.List;

import jp.co.wap.exam.lib.Interval;

public class TestProblem2 {

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
