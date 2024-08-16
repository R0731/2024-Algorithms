package d2_Re;

import java.util.Scanner;

public class 초심자의회문검사 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            String line = sc.next();

            char[] c = line.toCharArray();

            boolean ans = true;

            for(int i = 0; i < c.length / 2; i++){
                if(c[i] != c[c.length-1-i]){
                    ans = false;
                    break;
                }
            }

            System.out.println("#" + tc + " " + (ans? 1: 0));
        }
    }
}
