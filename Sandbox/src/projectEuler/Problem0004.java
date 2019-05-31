package projectEuler;

import tjsteel.TjMath.Palindrome;

/* A palindromic number reads the same both ways. 
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
*/
public class Problem0004 {
	public static String problem0004() {

		int largest = 0;
		for (int i = 999; i > 0; i--) {
			for (int j = 999; j > 0; j--) {
				if (Palindrome.isPalindrome("" + (i * j))) {
					largest = ((i * j) > largest) ? (i * j) : largest;
				}
			}

		}
		return "" + largest;
	}
}
