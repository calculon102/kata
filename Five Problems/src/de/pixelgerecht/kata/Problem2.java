package de.pixelgerecht.kata;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function that combines two lists by alternatingly taking elements.
 * For example: given the two lists [a, b, c] and [1, 2, 3], the function should return [a, 1, b, 2, c, 3].
 * @author calculon102
 *
 */
public final class Problem2 {

	public static List<? extends Object> combine(List<? extends Object> list1, List<? extends Object> list2) {

		final List<Object> result = new ArrayList<>(list1.size() + list2.size());

		if (list1.isEmpty()) {
			return list2;
		}

		if (list2.isEmpty()) {
			return list1;
		}

		final List<? extends Object> biggerList = list1.size() >= list2.size() ? list1 : list2;
		final List<? extends Object> smallerList  = list1.size() >= list2.size() ? list2 : list1;

		for (int i = 0; i < biggerList.size(); i++) {
			result.add(biggerList.get(i));
			if (smallerList.size() >= i) {
				result.add(smallerList.get(i));
			}
		}

		return result;
	}

}
