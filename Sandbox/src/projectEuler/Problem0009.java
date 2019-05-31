package projectEuler;

/*
*/
public class Problem0009 {
	public static String problem0009() {
		int num = 1000;

		for (int a = 1; a < num; a++) {
			for (int b = 1; b < num; b++) {
				int c = num - a - b;
				if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2))
					return "" + (a * b * c);
			}
		}

		return "";
	}
}
