package de.pixelgerecht.kata;

import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Tests implementations for Problem 3:
 * <p>
 * Write a function that computes the list of the first 100 Fibonacci numbers. By definition, the first two numbers in the Fibonacci sequence are 0 and 1, and each subsequent number is the sum of the previous two. As an example, here are the first 10 Fibonnaci numbers: 0, 1, 1, 2, 3, 5, 8, 13, 21, and 34.
 * </p>
 * @author calculon102
 *
 */
@RunWith(Parameterized.class)
public class Problem3Test {

	private final int length;
	private final List<Long> expected;

	public Problem3Test(int length, List<Long> expected) {
		this.length = length;
		this.expected = expected;
	}

	@Parameters(name = "fibanocciSeries({0})")
	public static Collection<Object[]> generateData() {
		return Arrays.asList(new Object[][] {
			{ 0, Collections.emptyList() },
			{ 1, Collections.singletonList(0l) },
			{ 2, Arrays.asList(0l, 1l) },
			{ 3, Arrays.asList(0l, 1l, 1l) },
			{ 4, Arrays.asList(0l, 1l, 1l, 2l) },
			{ 29, Arrays.asList(0l, 1l, 1l, 2l, 3l, 5l, 8l, 13l, 21l, 34l, 55l, 89l, 144l, 233l, 377l, 610l, 987l, 1597l, 2584l, 4181l, 6765l, 10946l, 17711l, 28657l, 46368l, 75025l, 121393l, 196418l, 317811l) }
		});
	}

	@Test
	public void testFibanoccieSeries() {
		Assert.assertThat(Problem3.computeFibanocciSeries(length), equalTo(expected));
	}
}
