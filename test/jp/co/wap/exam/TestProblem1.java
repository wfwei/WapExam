package jp.co.wap.exam;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import jp.co.wap.exam.lib.Interval;

public class TestProblem1 {

	List<Interval> intervals = new ArrayList<Interval>();

	@BeforeClass
	public static void bf() {
		System.out.println("test on Problem1");
	}

	@Before
	public void overhead() {
		// intervals.clear();
	}

	@Test
	public void testCase0() {
		intervals.add(new Interval("06:00", "09:00"));
		intervals.add(new Interval("08:00", "12:00"));
		intervals.add(new Interval("11:00", "13:30"));
		assertEquals("result:", 2,
				new Problem1().getMaxIntervalOverlapCount(intervals));
	}

	@Test
	public void testCase1() {
		intervals.add(new Interval("00:00", "08:00"));
		assertEquals("result:", 1,
				new Problem1().getMaxIntervalOverlapCount(intervals));
	}
	
	@Test
	public void testCase2() {
		intervals.add(new Interval("00:00", "08:00"));
		intervals.add(new Interval("08:00", "12:00"));
		assertEquals("result:", 2,
				new Problem1().getMaxIntervalOverlapCount(intervals));
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
			new Problem1().getMaxIntervalOverlapCount(intervals);
		}
	}
	
	@Test
	public void testCase02() {
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
			new Problem1().getMaxIntervalOverlapCount1(intervals);
		}
	}
}
