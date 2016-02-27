package de.pixelgerecht.kata;

import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import de.pixelgerecht.kata.Problem5.OrderedTerm;

/**
 * Tests implementations for Problem 5:
 * <p>Write a program that outputs all possibilities to put + or - or nothing between the numbers 1, 2, ..., 9 (in this order) such that the result is always 100. For example: 1 + 2 + 34 – 5 + 67 – 8 + 9 = 100.</p>
 * <p>This test could also be parametrized for different expected results and operator counts.</p>
 * @author calculon102
 *
 */
public class Problem5Test {

	/** The expected terms for a operator-size of 8 with a number count from 1 to 9 and an exprected resutl of 100. */
	private final List<String> expectedTerms = Arrays.asList(
			"1+2+3-4+5+6+78+9",
			"1+2+34-5+67-8+9",
			"1+23-4+5+6+78-9",
			"1+23-4+56+7+8+9",
			"12+3+4+5-6-7+89",
			"12+3-4+5+67+8+9",
			"12-3-4+5-6+7+89",
			"123+4-5+67-89",
			"123+45-67+8-9",
			"123-4-5-6-7+8-9",
			"123-45-67+89");


	@Test
	public void testTermCreationWithBruteForce() {
		final List<OrderedTerm> results = Problem5.findTermsBruteForce(100);
		Assert.assertThat(expectedTerms.size(), is(results.size()));

		for (OrderedTerm result : results) {
			Assert.assertTrue("Term " + result.getTerm() + " is not part of the expected results!", expectedTerms.contains(result.getTerm()));
		}
	}

	@Test
	public void testTermCreationWithRecursion() {
		final List<OrderedTerm> results = Problem5.findTermsRecursive(100, 8);
		Assert.assertThat(expectedTerms.size(), is(results.size()));

		for (OrderedTerm result : results) {
			Assert.assertTrue("Term " + result.getTerm() + " is not part of the expected results!", expectedTerms.contains(result.getTerm()));
		}
	}
}
