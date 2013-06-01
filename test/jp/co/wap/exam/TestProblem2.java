package jp.co.wap.exam;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import jp.co.wap.exam.lib.Interval;

public class TestProblem2 {

	List<Interval> intervals = new ArrayList<Interval>();

	@BeforeClass
	public static void bf() {
		System.out.println("test on Problem2");
	}

	@Before
	public void overhead() {
		// intervals.clear();
	}

	@Test
	public void testGetMaxIntervalOverlapCount() {
		intervals.add(new Interval("08:00", "09:00"));
		intervals.add(new Interval("06:00", "08:30"));
		intervals.add(new Interval("09:00", "11:00"));
		intervals.add(new Interval("12:30", "14:00"));
		intervals.add(new Interval("10:30", "14:00"));
		intervals.add(new Interval("09:00", "11:30"));
		assertEquals("result:", 390,
				new Problem2().getMaxWorkingTime(intervals));
	}

	@Test
	public void testGetMaxIntervalOverlapCount2() {
		intervals.add(new Interval("08:00", "08:00"));
		intervals.add(new Interval("08:30", "08:30"));
		assertEquals("result:", 0, new Problem2().getMaxWorkingTime(intervals));
	}

}
