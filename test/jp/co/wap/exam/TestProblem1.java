package jp.co.wap.exam;

import java.util.ArrayList;
import java.util.List;
import jp.co.wap.exam.lib.Interval;

public class TestProblem1 {

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval("06:00", "09:00"));
		intervals.add(new Interval("08:00", "12:00"));
		intervals.add(new Interval("11:00", "13:30"));

		int count = new Problem1().getMaxIntervalOverlapCount(intervals);
		System.out.println(count);
	}
}
