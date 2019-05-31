package projectEuler;

/* The following iterative sequence is defined for the set of positive integers:
 *
 *
 * n -> n/2 (n is even)
 * n -> 3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13, we generate the following sequence:
 *
 * 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 *
 * NOTE: Once the chain starts the terms are allowed to go above one million.
*/
public class Problem0014 {
	public static String problem0014() {
		int startingNumber = 0;
		int maxTerms = 0;
		long currentNumber;
		int currentTerms = 0;

		for (int i = 1; i <= 1000000; i++) {
			currentTerms = 1;
			currentNumber = i;

			while (currentNumber != 1) {
				if ((currentNumber % 2) == 0) {
					currentNumber /= 2;
				} else {
					currentNumber *= 3;
					currentNumber++;
				}
				currentTerms++;
			}

			if (currentTerms > maxTerms) {
				startingNumber = i;
				maxTerms = currentTerms;
			}
		}
		return "" + startingNumber;
	}
}