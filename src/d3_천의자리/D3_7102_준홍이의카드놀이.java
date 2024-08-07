package d3_천의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class D3_7102_준홍이의카드놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer line = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(line.nextToken());
            int M = Integer.parseInt(line.nextToken());

            int[] arr1 = new int[N];
            for(int i = 0; i < N; i++){
                arr1[i] = i+1;
            }

            int[] arr2 = new int[M];
            for(int i = 0; i < M; i++){
                arr2[i] = i+1;
            }

            List<Integer> num = new ArrayList<>();

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    num.add(arr1[i] + arr2[j]);
                }
            }

            int[] count = new int[N+M+1];

            for(int i = 0; i < num.size(); i++){
                count[num.get(i)]++;
            }

            int maxnum = 0;

            for(int i = 0; i < count.length; i++){
                if(count[i] > maxnum){
                    maxnum = count[i];
                }
            }

            System.out.print("#" + tc + " ");
            for(int i = 0; i < count.length; i++) {
                if(count[i] == maxnum){
                    System.out.print(i + " ");
                }
            }
            System.out.println();

        }
    }
}
