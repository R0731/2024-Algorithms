package SWEA.d3_천의자리;

import java.util.Arrays;
import java.util.Scanner;

public class D3_7985_RootedTree재구성 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int K = sc.nextInt();

            int N = (int)Math.pow(2, K) - 1;

            int[] tree = new int[N];

            for(int i = 0; i < N; i++){
                tree[i] = sc.nextInt();
            }

            System.out.println(Arrays.toString(tree));


            System.out.println("#" + tc + " ");
            maketree(tree, 0, N - 1, K);
            System.out.println();


        }

    }

    static void maketree(int[] tree, int start, int end, int level){
        if(level == 0)
            return;

        int mid = (start + end) / 2;
        System.out.println(tree[mid] + " ");

        if(level > 1){
           maketree(tree, start, mid - 1, level - 1);
           maketree(tree, start, mid + 1, level + 1);
        }

    }

    //중위순회? 재귀?
}
