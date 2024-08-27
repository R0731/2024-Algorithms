package SWEA.d2_Re;

import java.util.Scanner;

public class 두개의문자열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] A = new int[N];
            int[] B = new int[M];

            for(int i = 0; i < N; i++){
                A[i] = sc.nextInt();
            }

            for(int i = 0; i < M; i++) {
                B[i] = sc.nextInt();
            }

//            System.out.println(Arrays.toString(A));
//            System.out.println(Arrays.toString(B));

            int max = 0;

            if(N > M){
                for(int i = 0; i < N - M + 1; i++){
                    int sum = 0;
                    for(int j = 0; j < M; j++){
                        sum += A[i + j] * B[j];
                    }
                    if(sum > max){
                        max = sum;
                    }
                }
            }else{
                for(int i = 0; i < M - N + 1; i++){
                    int sum = 0;
                    for(int j = 0; j < N; j++){
                        sum += A[j] * B[i + j];
                    }
                    if(sum > max){
                        max = sum;
                    }
                }
            }

            System.out.println("#" + tc + " " + max);
        }
    }
}
