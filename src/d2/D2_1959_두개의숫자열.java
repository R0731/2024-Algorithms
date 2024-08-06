package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D2_1959_두개의숫자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= t; tc++){
            //배열 만들기
            StringTokenizer line = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(line.nextToken());
            int M = Integer.parseInt(line.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];

            StringTokenizer line2 = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                A[i] = Integer.parseInt(line2.nextToken());
            }

            StringTokenizer line3 = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++){
                B[i] = Integer.parseInt(line3.nextToken());
            }

            int num = Math.abs(N-M);
            //비교값을 저장할 배열만들기
            int[] sum = new int[num+1];

            int s = 0;

            //한 칸씩 옮겨가면서 비교해보기
            if(N <= M) {
                int ni = 0;
                while(ni <= num){
                    for(int i = 0; i < N; i++){
                        sum[s] += A[i] * B[i + ni];
                    }
                    ni++;
                    s++;
                }

            }else{
                int mi = 0;
                while(mi <= num){
                    for(int i = 0; i < M; i++){
                        sum[s] += A[i + mi] * B[i];
                    }
                    mi++;
                    s++;
                }
            }

//            System.out.println(Arrays.toString(sum));

            //최댓값 구하기
            int max = 0;

            for(int i = 0; i < sum.length; i++){
                if(sum[i] > max)
                    max = sum[i];
            }

            System.out.println("#" + tc + " " + max);
        }
    }
}
