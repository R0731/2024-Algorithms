package SWEA.d3_천의자리;

import java.util.Scanner;

public class D3_4012_요리사 {
    static int N; //식재료의 수
    static int R; //요리를 만들 때 쓸 식재료의 수
    static int[][] taste;
    static int[] use;//사용할 수 있는 재료 배열
    static int[] notuse;
    static int[] food;
    static int min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            R = N / 2;

            taste = new int[N][N];
            use = new int[R];
            notuse = new int[R];
            food = new int[2];

            min = Integer.MAX_VALUE;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    taste[r][c] = sc.nextInt();
                }
            }

            combination(0, 0);

            System.out.println("#" + tc + " " + min);
        }
    }

    private static void combination(int idx, int sidx) {
        //기저조건
        if (sidx == R) {
            //사용하지 않은 재료 추출
            boolean[] selected = new boolean[N];
            for(int i = 0; i < R; i++){
                selected[use[i]] = true;
            }
            int ndix = 0;
            for(int i = 0; i < N; i++){
                if(!selected[i]){
                    notuse[ndix] = i;
                    ndix++;
                }
            }
            int sum1 = arrSum(use);
            int sum2 = arrSum(notuse);
            min = Math.min(min, Math.abs(sum1 - sum2));
            return;
        }
        if(idx >= N){
            return;
        }

        //재귀부분
        use[sidx] = idx;
        combination(idx + 1, sidx + 1);

        combination(idx + 1, sidx);

    }

    private static int arrSum(int[] arr){
        int sum = 0;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < R; j++){
                sum += taste[arr[i]][arr[j]];
            }
        }
        return sum;
    }
}