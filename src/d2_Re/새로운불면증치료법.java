package d2_Re;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 새로운불면증치료법 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int plus = N;

            Set<Integer> count = new HashSet<>();
            int ans = 0;

            while(count.size() != 10){
                String a = N + "";
                char[] c = a.toCharArray();
                for(int i = 0; i < c.length; i++){
                    count.add(c[i]-'0');
                }

                ans++;

                N += plus;

            }


            System.out.println("#" + tc + " " + (ans*plus));
        }
    }
}
