package hackerRank;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<int[]> arr = new ArrayList<int[]>();

        for (int i = 0; i < n; i++){
            int len = scan.nextInt();
            arr.add(new int[len]);
            for (int d = 0; d < len; d++){
                arr.get(i)[d] = scan.nextInt();
            }
        }

        int q = scan.nextInt();
        for (int i = 0; i < q; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
                System.out.println("x,y = " + x + "," + y);
                System.out.println(arr.get(x)[y]);

        }
        scan.close();
    }
}

