package projectEuler;

/* 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * 
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
*/
public class Problem0005 {
	public static String problem0005() {
		boolean divisibleByAll = true;

		int i = 20;
		
		while (true) {
			for (int j = 1; j <=20; j++) {
				if (i % j != 0) {
					divisibleByAll = false;
					j = 21;
				}
			}
			if (divisibleByAll) {
				return ""+i;
			}
			divisibleByAll = true;
			i+=20;
		}
	}
}
