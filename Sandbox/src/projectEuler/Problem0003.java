package projectEuler;

import tjsteel.TjMath.Prime;

/* The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
*/
public class Problem0003 {
	public static String problem0003() {
		long num = 600851475143l;
		long i = Math.round(Math.sqrt(num) + 1);
		if (i % 2 == 0)
			i++;

		while (i > 0) {
			if (num % i == 0) {
				if (Prime.isPrime(i)) {
					return "" + i;
				}
			}
			i -= 2;
		}
		return "Not Found";
	}
}
