package d2_Re;

import java.util.Scanner;

public class 패턴마디의길이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            String str = sc.next();

            int ans = str.length();

            for(int i = 1; i <= 10; i++){
                String line1 = str.substring(0, i);
                String line2 = str.substring(i, i + i);
                if(line1.equals(line2)){
                    ans = line1.length();
                    break;
                }
            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}
