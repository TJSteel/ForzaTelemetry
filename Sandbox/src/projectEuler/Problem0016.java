package projectEuler;

import java.math.BigDecimal;

/* 215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 21000?
*/
public class Problem0016 {

	public static String problem0016() {
		String powStr = new BigDecimal(Math.pow(2, 1000)).toPlainString();

		int sum = 0;
		for (int i = 0; i < powStr.length(); i++) {
			sum += Integer.parseInt(powStr.substring(i, i + 1));
		}
		return "" + sum;
	}
}
//9,223,372,036,854,775,807