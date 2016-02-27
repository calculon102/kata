package de.pixelgerecht.kata;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Challenge</h1>
 * <p>Write a program that outputs all possibilities to put + or - or nothing between the numbers 1, 2, ..., 9 (in this order) such that the result is always 100. For example: 1 + 2 + 34 – 5 + 67 – 8 + 9 = 100.</p>
 * <h1>Solution</h1>
 * <p>Brute force and recursion in two seperate methods.</p>
 * @author calculon102
 */
public class Problem5 {

	/**
	 * Find all combinations of numbers from 1-9 in that order with any combination of
	 * known operatores from Operators that results in given parameter.
	 * First proof-of-concept, but without variable parameter count.
	 * @param expected result to expect from combination
	 * @return All combinations that result in given expected value.
	 */
	public static List<OrderedTerm> findTermsBruteForce(final long expected) {
		final List<OrderedTerm> results = new ArrayList<>();

		final Operator[] ops = new Operator[8];

		for (Operator op0 : Operator.values()) {
			ops[0] = op0;
			for (Operator op1 : Operator.values()) {
				ops[1] = op1;
				for (Operator op2 : Operator.values()) {
					ops[2] = op2;
					for (Operator op3 : Operator.values()) {
						ops[3] = op3;
						for (Operator op4 : Operator.values()) {
							ops[4] = op4;
							for (Operator op5 : Operator.values()) {
								ops[5] = op5;
								for (Operator op6 : Operator.values()) {
									ops[6] = op6;
									for (Operator op7 : Operator.values()) {
										ops[7] = op7;
										final OrderedTerm term = new OrderedTerm(ops);
										if (term.getResult() == expected) {
											System.out.println(term);
											results.add(term);
										}
									}
								}
							}
						}
					}
				}
			}
		}

		return results;
	}

	/**
	 * Find all combinations of numbers from 1 to operators+1 in that order with any combination of
	 * known operatores from Operators that results in given parameter
	 * @param expected result to expect from combination
	 * @param operators count of operators to use. I.e., when using eight operators, the term will use number from 1 to 9.
	 * @return All combinations that result in given expected value.
	 */
	public static List<OrderedTerm> findTermsRecursive(final long expected, final int operators) {
		final List<OrderedTerm> results = new ArrayList<>();
		final Operator[] ops = new Operator[operators];

		findHundredResolutionsRecursiveImpl(expected, operators, ops, 0, results);

		return results;
	}

	/**
	 * Implementents the functional, recursive approach..
	 * @param expected result to expect from combination
	 * @param operators count of operators to use. I.e., when using eight operators, the term will use number from 1 to 9.
	 * @param ops Array of operators with length from parameter operators.
	 * @param depth Current depth of recursion, correspondent of index of array ops, which this recurision-depth is respondible for iterating.
	 * @param results Here are the results collected.
	 */
	private static void findHundredResolutionsRecursiveImpl(final long expected, final int operators, Operator[] ops, final int depth, List<OrderedTerm> results) {
		for (Operator op : Operator.values()) {
			ops[depth] = op;
			if (depth + 1 < operators) {
				findHundredResolutionsRecursiveImpl(expected, operators, ops, depth + 1, results);
			} else {
				final OrderedTerm term = new OrderedTerm(ops);
				if (term.getResult() == expected) {
					System.out.println(term);
					results.add(term);
				}
			}
		}
	}


	/**
	 * Representing operators and their strings.
	 * @author calculon102
	 */
	private enum Operator {
		/** Sum the two numbers left and right. */
		PLUS("+"),
		/** Minus the right operator from the left. */
		MINUS("-"),
		/** Merge both numbers left and right to a single one. */
		MERGE("");

		private final String rep;

		Operator(String rep) {
			this.rep = rep;
		}

		@Override
		public String toString() {
			return this.rep;
		}
	};

	/**
	 * Represents a term from 1 to (number of given operators) + 1, where the operators
	 * are inserted between the numbers. Computes the result.
	 * @author calculon102
	 */
	static class OrderedTerm
	{
		private final String term;
		private final long result;

		public OrderedTerm(final Operator[] ops) {
			term = createTerm(ops);
			result = calulateResult(term);
		}

		public String getTerm() {
			return term;
		}

		public long getResult() {
			return result;
		}

		@Override
		public String toString() {
			return term + "=" + result;
		}

		private static String createTerm(final Operator[] ops) {
			final StringBuilder term = new StringBuilder();
			term.append("1");

			for (int i = 0; i < ops.length; i++) {
				term.append(ops[i].toString()).append(String.valueOf(i+2));
			}

			return term.toString();
		}

		private static long calulateResult(String term) {
			long result = 0;

			final String[] positives = term.toString().split("\\+");
			for (String positive : positives) {
				final String[] negatives = positive.split("-");
				result += Long.valueOf(negatives[0]);

				for (int i = 1; i < negatives.length; i++) {
					result -= Long.valueOf(negatives[i]);
				}
			}

			return result;
		}
	}

}
