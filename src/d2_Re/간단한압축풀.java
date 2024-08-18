package d2_Re;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 간단한압축풀 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();

            List<String> str = new ArrayList<>();

            for(int i = 0; i < N; i++){
                String a = sc.next();
                int b = sc.nextInt();
                for(int j = 0; j < b; j++) {
                    str.add(a);
                }
            }

            System.out.println("#" + tc + " ");

            while(!str.isEmpty()) {
                for(int i = 0; i < 10; i++) {
                    if(!str.isEmpty()) {
                        System.out.print(str.remove(0));
                    }
                }
                System.out.println();
            }
        }
    }
}
