package projectEuler;

import tjsteel.TjMath.Prime;

/* By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * 
 * What is the 10,001st prime number?
*/
public class Problem0007 {
	public static String problem0007() {
		return ""+Prime.getNthPrime(10001);
	}
}

