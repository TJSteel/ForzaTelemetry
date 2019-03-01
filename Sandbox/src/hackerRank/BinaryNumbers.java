package hackerRank;
import java.util.*;

public class BinaryNumbers {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        scanner.close();
        
        String str = Integer.toBinaryString(n);
        int len = 0;
        int maxLen = 0;
        for (int i = 0; i < str.length(); i++) {
        	if (Integer.parseInt(str.substring(i, i+1)) == 1) {
        		len++;
        		maxLen = len > maxLen ? len : maxLen;
        	} else {
        		len = 0;
        	}
        }
        System.out.println(maxLen);
    }
}
