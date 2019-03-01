package hackerRank;
import java.math.BigDecimal;
import java.util.*;

public class BigDecimalTest {
	    public static void main(String []args){
	        //Input
	        Scanner sc= new Scanner(System.in);
	        int n=sc.nextInt();
	        String []s=new String[n+2];
	        for(int i=0;i<n;i++){
	            s[i]=sc.next();
	        }
	        sc.close();

	        //Write your code here
	        BigDecimal[] bd = new BigDecimal[s.length];
	        for(int i=0;i<n;i++){
	            bd[i]=new BigDecimal(s[i]);
	        }
	        
	        Arrays.sort(bd);
	        
		// Output
		for (int i = 0; i < n; i++) {
			System.out.println(s[i]);
		}
	}
}
