/**
 *	Recursive-function solution to coding-kata 02 of codekata.com, see
 *  http://codekata.com/kata/kata02-karate-chop/
 *
 *	For fun in C.
 *
 *  by Frank Großgasteiger <frank@grossgasteiger.de>, 04 Sept. 2016
 */

#include <assert.h>
#include <stdio.h>

#define NOT_FOUND -1


/** Simple assertion. If excpected != actual prints out message to stderr. */
void assert_equal(int expected, int actual);

/** Prints out the needle and haystack to stdout. */
int print_chop(int needle, int * haystack, int haystackSize);

/** Wraps the chop-algorithm within one function-call. Assumes a sorted haystack. */
int chop(int needle, int * haystack, int haystackSize);

/** Recursive function of chop-algorithm, called with parts of the haytack. 
  * Continues until haystackSize == 1 and will will then compare the single
  * left element to the needle. Return -1 if needle != haystack[0], the
  * indexBegin otherwise. */
int chop_recursive(int needle, int * haystack, int haystackSize, int indexBegin);


int main() {
	int array0[0];
	assert_equal(-1, chop(3, array0, 0));

	int array1[1] = {1};
	assert_equal(-1, chop(3, array1, 1));
	assert_equal(0,  chop(1, array1, 1));

	int array3[3] = {1, 3, 5};
	assert_equal(0,  chop(1, array3, 3));
	assert_equal(1,  chop(3, array3, 3));
	assert_equal(2,  chop(5, array3, 3));
	assert_equal(-1, chop(0, array3, 3));
	assert_equal(-1, chop(2, array3, 3));
	assert_equal(-1, chop(4, array3, 3));
	assert_equal(-1, chop(6, array3, 3));

	int array4[4] = {1, 3, 5, 7};
	assert_equal(0,  chop(1, array4, 4));
	assert_equal(1,  chop(3, array4, 4));
	assert_equal(2,  chop(5, array4, 4));
	assert_equal(3,  chop(7, array4, 4));
	assert_equal(-1, chop(0, array4, 4));
	assert_equal(-1, chop(2, array4, 4));
	assert_equal(-1, chop(4, array4, 4));
	assert_equal(-1, chop(6, array4, 4));
	assert_equal(-1, chop(8, array4, 4));
	
	return 0;
}


void assert_equal(int expected, int actual) {
	if (expected != actual) {
		fprintf(stderr, "FAILED ASSERTION! %i != %i\r\n", expected, actual);
	}
}


int print_chop(int needle, int * haystack, int haystackSize) {
	assert(haystack);
	assert(haystackSize >= 0);
	
	printf("Searching for %d in {", needle);
	for (int i = 0; i < haystackSize; i++) {
		printf("%d", haystack[i]);
		if (i + 1 < haystackSize) printf(", ");
	}
	printf("}. Index: ");
}


int chop(int needle, int* haystack, int haystackSize) {
	assert(haystack);
	assert(haystackSize >= 0);
		
	print_chop(needle, haystack, haystackSize);
	
	// Special-case: empty array.
	if (haystackSize == 0) {
		printf("%d\r\n", NOT_FOUND);
		return NOT_FOUND;
	}
	
	int found = chop_recursive(needle, haystack, haystackSize, 0);
	printf("%d\r\n", found);
			
	return found;
}


int chop_recursive(int needle, int* haystack, int haystackSize, int indexBegin) {
	assert(haystack);
	assert(haystackSize >= 0);
	assert(indexBegin >= 0);
	
	if (haystackSize == 1 && haystack[0] == needle) return indexBegin;
	if (haystackSize == 1 && haystack[0] != needle) return NOT_FOUND;
	
	int chop = haystackSize / 2;
	
	// Which half of the the haystack to test? Assuming a sorted array, the
	// last value of the first half is tested against the needle
	if (needle <= haystack[chop-1]) {
		return chop_recursive(needle, haystack, chop, indexBegin);
	}
	
	int* secondHalf = haystack + chop;
	int  secondHalfSize = chop + (haystackSize % 2);
	
	return chop_recursive(needle, secondHalf, secondHalfSize, indexBegin + chop);
}
