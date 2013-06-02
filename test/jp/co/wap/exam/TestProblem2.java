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
	public void testGetMaxIntervalOverlapCount() {
		intervals.add(new Interval("08:00", "09:00"));
		intervals.add(new Interval("06:00", "08:30"));
		intervals.add(new Interval("09:00", "11:00"));
		intervals.add(new Interval("12:30", "14:00"));
		intervals.add(new Interval("10:30", "14:00"));
		intervals.add(new Interval("09:00", "11:30"));
		assertEquals("result:", 390,
				new Problem2().getMaxWorkingTime(intervals));
		assertEquals("result:", 390,
				new Problem2().getMaxWorkingTime2(intervals));
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
				new Problem2().getMaxWorkingTime2(intervals));
	}

	@Test
	public void testGetMaxIntervalOverlapCount2() {
		intervals.add(new Interval("08:00", "08:00"));
		intervals.add(new Interval("08:30", "08:30"));
		assertEquals("result:", 0, new Problem2().getMaxWorkingTime(intervals));
		assertEquals("result:", 0, new Problem2().getMaxWorkingTime2(intervals));
	}

}
