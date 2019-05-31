package projectEuler;

/* If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * 
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 * 
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters 
 * and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
*/

public class Problem0017 {
	public static String problem0017() {
		StringBuffer str = new StringBuffer();
		for (int i = 1; i <= 1000; i++) {
			str.append(getWrittenNumber(i));
		}
		System.out.println(str);
		return ""+str.toString().length();
	}
	
	private static String getWrittenNumber(int num) {
		StringBuffer str = new StringBuffer();
		int thousands = 0,
				hundreds = 0,
				tens = 0;
		
		if (num >= 1000) {
			while (num >= 1000) {
				num -= 1000;
				thousands++;
			}
			str.append(getSmallNumber(thousands));
			str.append("thousand");
		}
		if (num >= 100) {
			while (num >= 100) {
				num -= 100;
				hundreds++;
			}
			str.append(getSmallNumber(hundreds));
			if (num == 0) {
				str.append("hundred");
			} else {
				str.append("hundredand");				
			}
			
		}
		if (num >= 20) {
			tens = 0;
			while (num >= 10) {
				num -= 10;
				tens++;
			}
			str.append(getTensNumber(tens));
			if(num == 0)return str.toString();
		}
		str.append(getSmallNumber(num));
		
		return str.toString();
		//return "";
	}
	
	
	private static String getSmallNumber(int num) {
		switch (num) {
		case 1:
		return "one";
		case 2:
		return "two";
		case 3:
		return "three";
		case 4:
		return "four";
		case 5:
		return "five";
		case 6:
		return "six";
		case 7:
		return "seven";
		case 8:
		return "eight";
		case 9:
		return "nine";
		case 10:
		return "ten";
		case 11:
		return "eleven";
		case 12:
		return "twelve";
		case 13:
		return "thirteen";
		case 14:
		return "fourteen";
		case 15:
		return "fifteen";
		case 16:
		return "sixteen";
		case 17:
		return "seventeen";
		case 18:
		return "eighteen";
		case 19:
		return "nineteen";
		}
		return "";
	}
	private static String getTensNumber(int num) {
		switch (num) {
		case 1:
		return "ten";
		case 2:
		return "twenty";
		case 3:
		return "thirty";
		case 4:
		return "forty";
		case 5:
		return "fifty";
		case 6:
		return "sixty";
		case 7:
		return "seventy";
		case 8:
		return "eighty";
		case 9:
		return "ninety";
		}
		return "";
	}
}
