package de.pixelgerecht.kata;

import static org.hamcrest.CoreMatchers.is;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Tests implementations for Problem 1:
 * <p>
 * Write three functions that compute the sum of the numbers in a given list using a for-loop, a while-loop, and recursion.
 * </p>
 * @author calculon102
 *
 */
@RunWith(Parameterized.class)
public class Problem1Test {
	private final List<Long> summands;
	private final long expected;

	public Problem1Test(List<Long> summands, long expected) {
		this.summands = summands;
		this.expected = expected;
	}

	@Parameters(name = "add({0})={1}")
	public static Collection<Object[]> generateData() {
		return Arrays.asList(new Object[][] {
			{ Arrays.asList() , 0 },
			{ Arrays.asList(0l) , 0 },
			{ Arrays.asList(1l, -1l),  0 },
			{ Arrays.asList(0l, 1l),  1 },
			{ Arrays.asList(1l, 1l),  2 },
			{ Arrays.asList(1l, 0l),  1 },
			{ Arrays.asList(1l, 1l, 1l),  3 },
			{ Arrays.asList(1l, 1l, 0l),  2 },
			{ Arrays.asList(0l, 1l, 1l),  2 },
			{ Arrays.asList(1l, -1l, 1l),  1 },
			{ Arrays.asList(100l, 10l, 1l),  111 },
			{ Arrays.asList(-1l, -1l, -1l),  -3 }
		});
	}

	@Test
	public void testForLoop() {
		Assert.assertThat(Problem1.sumWithForLoop(summands), is(expected));
	}

	@Test
	public void testWhileLoop() {
		Assert.assertThat(Problem1.sumWithWhileLoop(summands), is(expected));
	}

	@Test
	public void testRecursion() {
		Assert.assertThat(Problem1.sumWithRecursion(summands), is(expected));
	}
}
