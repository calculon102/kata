package de.pixelgerecht.kata;

import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Tests implementations for Problem 2:
 * <p>
 * Write a function that combines two lists by alternatingly taking elements. For example: given the two lists [a, b, c] and [1, 2, 3], the function should return [a, 1, b, 2, c, 3].
 * </p>
 * @author calculon102
 *
 */
@RunWith(Parameterized.class)
public class Problem2Test {
	private final List<? extends Object> list1;
	private final List<? extends Object> list2;
	private final List<? extends Object> expected;

	public Problem2Test(List<? extends Object> list1, List<? extends Object> list2, List<? extends Object> expected) {
		this.list1 = list1;
		this.list2 = list2;
		this.expected = expected;
	}

	@Parameters(name = "combine({0}, {1})={2}")
	public static Collection<Object[]> generateData() {
		return Arrays.asList(new Object[][] {
			{ Arrays.asList(), Arrays.asList(1, 2, 3) , Arrays.asList(1, 2, 3) },
			{ Arrays.asList("a", "b", "c"), Arrays.asList() , Arrays.asList("a", "b", "c") },
			{ Arrays.asList("a", "b", "c"), Arrays.asList(1, 2, 3) , Arrays.asList("a", 1, "b", 2, "c", 3) }
		});
	}

	@Test
	public void testCombination() {
		Assert.assertThat(Problem2.combine(list1, list2), equalTo(expected));
	}
}
