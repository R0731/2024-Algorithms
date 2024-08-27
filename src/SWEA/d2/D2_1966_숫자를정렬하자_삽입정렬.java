package SWEA.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1966_숫자를정렬하자_삽입정렬 {
    //삽입정렬 방식으로 풀어보기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            int N = Integer.parseInt(br.readLine());

            StringTokenizer line = new StringTokenizer(br.readLine());

            int[] arr = new int[N];

            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(line.nextToken());
            }

            for(int i = 1; i < N; i++){
                int data = arr[i];
                int j;
                for(j = i - 1; j >= 0 && data < arr[j]; j--){
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = data;
            }

            System.out.print("#" + tc + " ");
            for(int i = 0; i < N; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}