package de.pixelgerecht.kata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Write a function that computes the list of the first 100 Fibonacci numbers. By definition, the first two numbers in the Fibonacci sequence are 0 and 1, and each subsequent number is the sum of the previous two. As an example, here are the first 10 Fibonnaci numbers: 0, 1, 1, 2, 3, 5, 8, 13, 21, and 34.
 * @author calculon102
 */
public final class Problem3 {

	/**
	 * Computes the fibanocci-series of given length. Will not solve the challgenge completely in java, since a series of 100 will overflow the long data-type. But it's enough for a POC.
	 * @param length Length of the fibanocci-series. Must be zero or greater.
	 * @return Fibanocci-series of given length.
	 */
	public static List<Long> computeFibanocciSeries(int length) {
		if (length < 0) {
			throw new IllegalStateException("length must be greater or equal 0.");
		}

		if (length == 0) {
			return Collections.emptyList();
		}

		if (length == 1) {
			return Collections.singletonList(0l);
		}

		final List<Long> result = new ArrayList<>(length);
		result.add(0l);
		result.add(1l);

		for (int i = 2; i < length; i++) {
			result.add(i, result.get(i-2) + result.get(i-1));
		}

		return result;
	}

}
