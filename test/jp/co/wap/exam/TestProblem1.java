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
	public void testGetMaxIntervalOverlapCount() {
		intervals.add(new Interval("06:00", "09:00"));
		intervals.add(new Interval("08:00", "12:00"));
		intervals.add(new Interval("11:00", "13:30"));
		assertEquals("result:", 3,
				new Problem1().getMaxIntervalOverlapCount(intervals));
	}

	@Test
	public void testGetMaxIntervalOverlapCount2() {
		intervals.add(new Interval("00:00", "08:00"));
		intervals.add(new Interval("08:00", "12:00"));
		assertEquals("result:", 2,
				new Problem1().getMaxIntervalOverlapCount(intervals));
	}
}
