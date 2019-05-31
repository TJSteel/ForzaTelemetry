package projectEuler;

import tjsteel.TjMath.Prime;

/* The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * 
 * Find the sum of all the primes below two million.
*/
public class Problem0010 {
	public static String problem0010() {
		int prime = 3;
		long answer = 2;
		int maxPrime = 1999999;

		while (prime <= maxPrime) {
			if (Prime.isPrime(prime)) {
				answer += prime;
			}
			prime += 2;
		}

		return "" + answer;
	}
}