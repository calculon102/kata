package de.pixelgerecht.kata;

import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Tests implementations for Problem 4:
 * <p>Write a function that given a list of non negative integers, arranges them such that they form the largest possible number.
 * For example, given [50, 2, 1, 9], the largest formed number is 95021.</p>
 * @author calculon102
 *
 */
@RunWith(Parameterized.class)
public class Problem4Test {

	private final long[] values;
	private final long expected;

	public Problem4Test(long[] values, long expected) {
		this.values = values;
		this.expected = expected;
	}

	@Parameters
	public static Collection<Object[]> generateData() {
		return Arrays.asList(new Object[][] {
			{ new long[] { 9l }, 9l },
			{ new long[] { 50l, 2l, 1l, 9l }, 95021 },
			{ new long[] { 1l, 2l, 9l, 50l }, 95021},
			{ new long[] { 5l, 50l, 56l }, 56550l},
			{ new long[] { 52l, 5l, 3l }, 5523l},
			{ new long[] { 9l, 990l, 90l, 99l, 9l }, 999999090l }
		});
	}

	@Test
	public void testBiggestNumbers() {
		Assert.assertThat(Problem4.createBiggestNumber(values), is(expected));
	}
}
