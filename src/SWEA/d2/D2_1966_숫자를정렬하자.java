package SWEA.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D2_1966_숫자를정렬하자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];

            StringTokenizer line = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(line.nextToken());
            }

            Arrays.sort(arr);

            System.out.print("#" + tc + " ");
            for(int i = 0; i < arr.length; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
