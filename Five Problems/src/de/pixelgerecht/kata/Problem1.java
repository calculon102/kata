package de.pixelgerecht.kata;

import java.util.ArrayList;
import java.util.List;

/**
 * Write three functions that compute the sum of the numbers in a given list using a for-loop, a while-loop, and recursion.
 * @author calculon102
 */
public final class Problem1 {

	public static long sumWithForLoop(List<Long> summands) {
		long result = 0;
		for (Long summand : summands) {
			result += summand;
		}
		return result;
	}


	public static long sumWithWhileLoop(List<Long> summands) {
		long result = 0;
		int index = 0;

		while (index < summands.size()) {
			result += summands.get(index);
			index += 1;
		}

		return result;
	}

	public static long sumWithRecursion(List<Long> summands) {
		return sumWithRecursionImpl(summands, 0);
	}


	private static long sumWithRecursionImpl(List<Long> summands, long summand) {
		if (summands.isEmpty()) {
			return summand;
		}

		long newSummand = summand + summands.get(0);

		final List<Long> newSummands = new ArrayList<>(summands);
		newSummands.remove(0);

		return sumWithRecursionImpl(newSummands, newSummand);
	}
}
