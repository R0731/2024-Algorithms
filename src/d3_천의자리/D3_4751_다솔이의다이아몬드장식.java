package d3_천의자리;

import java.util.Scanner;

public class D3_4751_다솔이의다이아몬드장식 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            String str = sc.next();

            int N = str.length();

            char[] voca = str.toCharArray();

            //첫째줄
            System.out.print("..#..");
            for(int i = 1; i < N; i++){
                System.out.print(".#..");
            }
            System.out.println();

            //둘째줄
            System.out.print(".#.#.");
            for(int i = 1; i < N; i++){
                System.out.print("#.#.");
            }
            System.out.println();

            //셋째줄
            System.out.print("#." + voca[0] + ".#");
            for(int i = 1; i < N; i++){
                System.out.print("." + voca[i] + ".#");
            }
            System.out.println();

            //넷째줄
            System.out.print(".#.#.");
            for(int i = 1; i < N; i++){
                System.out.print("#.#.");
            }
            System.out.println();

            //다섯째줄
            System.out.print("..#..");
            for(int i = 1; i < N; i++){
                System.out.print(".#..");
            }
            System.out.println();
        }
    }
}
