package jp.co.wap.exam;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import jp.co.wap.exam.lib.Interval;

public class TestProblem2 {

	List<Interval> intervals = new ArrayList<Interval>();

	@Before
	public void overhead() {
		// intervals.clear();
	}

	@Test
	public void testCase00() {
		for (int i = 0; i < 10; i++) {
			intervals.clear();
			for (int j = 0; j < 9000; j++) {
				int hour1 = (int) Math.random() * 24, hour2 = (int) Math
						.random() * 24;
				int min1 = (int) Math.random() * 60, min2 = (int) Math.random() * 60;
				if (hour1 > hour2) {
					hour1 ^= hour2;
					hour2 ^= hour2;
					hour1 ^= hour2;
				}
				if (hour1 == hour2 && min1 > min2) {
					min1 ^= min2;
					min2 ^= min2;
					min1 ^= min2;
				}
				intervals.add(new Interval(String.format("%02d:%02d", hour1,
						min1), String.format("%02d:%02d", hour2, min2)));
			}
			new Problem2().getMaxWorkingTime(intervals);
		}
	}

	@Test
	public void testCase01() {
		for (int i = 0; i < 10; i++) {
			intervals.clear();
			for (int j = 0; j < 9000; j++) {
				int hour1 = (int) Math.random() * 24, hour2 = (int) Math
						.random() * 24;
				int min1 = (int) Math.random() * 60, min2 = (int) Math.random() * 60;
				if (hour1 > hour2) {
					hour1 ^= hour2;
					hour2 ^= hour2;
					hour1 ^= hour2;
				}
				if (hour1 == hour2 && min1 > min2) {
					min1 ^= min2;
					min2 ^= min2;
					min1 ^= min2;
				}
				intervals.add(new Interval(String.format("%02d:%02d", hour1,
						min1), String.format("%02d:%02d", hour2, min2)));
			}
			new Problem2().getMaxWorkingTime1(intervals);
		}
	}

	@Test
	public void testGetMaxIntervalOverlapCount1() {
		intervals.add(new Interval("08:00", "09:00"));
		intervals.add(new Interval("10:30", "14:00"));
		intervals.add(new Interval("08:30", "13:30"));
		intervals.add(new Interval("14:00", "15:30"));
		assertEquals("result:", 390,
				new Problem2().getMaxWorkingTime(intervals));
		assertEquals("result:", 390,
				new Problem2().getMaxWorkingTime1(intervals));
	}

	@Test
	public void testGetMaxIntervalOverlapCount2() {
		intervals.add(new Interval("08:00", "08:00"));
		intervals.add(new Interval("08:30", "08:30"));
		assertEquals("result:", 0, new Problem2().getMaxWorkingTime(intervals));
		assertEquals("result:", 0, new Problem2().getMaxWorkingTime1(intervals));
	}

}
