package de.pixelgerecht.kata;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <h1>Challenge</h1>
 * <p>Write a function that given a list of non negative integers, arranges them such that they form the largest possible number.
 * For example, given [50, 2, 1, 9], the largest formed number is 95021.</p>
 * <h1>Solution</h1>
 * <p>Define a specific data-type which instances compare-behaviour satifies the spec.</p>
 * @author calculon102
 */
public final class Problem4 {

	/**
	 * Combines given values in an order, that the biggest possible value is created.
	 * Only works for long-value-range as proof-of-concept.
	 * @param values values to combine.
	 * @return biggest possible value.
	 */
	public static long createBiggestNumber(long ... values) {
		final LexicalNumber[] parts = new LexicalNumber[values.length];
		for (int i = 0; i < values.length; i++) {
			parts[i] = new LexicalNumber(values[i]);
		}
		return LexicalNumber.concat(parts);
	}

	/**
	 * Represpents a part of a possible bigger number, where the comparison enables
	 * a sort where these parts are leading which would create the biggest number
	 * if the parts are connected.
	 * @author calculon102
	 */
	private static final class LexicalNumber implements Comparable<LexicalNumber>
	{
		private final String lexical;

		public LexicalNumber(long number) {
			this.lexical = String.valueOf(number);
		}

		@Override
		public int compareTo(LexicalNumber o) {
			return (lexical + o.lexical).compareTo(o.lexical + lexical) * -1;
		}

		@Override
		public String toString() {
			return lexical;
		}

		/**
		 * Combines all given parts to a bigger number.
		 * @param parts Parts to combine.
		 * @return Combination of all parts. Beware of long-overflow!
		 */
		public static long concat(LexicalNumber... parts) {
			if (parts == null || parts.length == 0) {
				throw new IllegalArgumentException("Give a least one part!");
			}

			final List<LexicalNumber> partsList = Arrays.asList(parts);
			Collections.sort(partsList);

			final StringBuilder result = new StringBuilder();
			for (LexicalNumber part : partsList) {
				result.append(part.lexical);
			}

			return Long.valueOf(result.toString());
		}
	}
}
