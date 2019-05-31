package projectEuler;

/* The sum of the squares of the first ten natural numbers is,
 * 
 * 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 * 
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 - 385 = 2640.
 * 
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
*/
public class Problem0006 {
	public static String problem0006() {
		int sumOfSquare = 0;
		int squareOfSum = 0;
		
		for (int i = 1; i <= 100; i++) {
			sumOfSquare += (int)Math.pow(i, 2);
			squareOfSum += i;
		}
		squareOfSum = (int)Math.pow(squareOfSum, 2);
		
		return ""+(squareOfSum - sumOfSquare);		
	}
}
