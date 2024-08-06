package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D2_1946_간단한압축풀기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());


            String[] st = new String[N];
            int[] num = new int[N];

            for(int i = 0; i < N; i++){
                StringTokenizer line = new StringTokenizer(br.readLine());
                String c = line.nextToken();
                int n = Integer.parseInt(line.nextToken());

                st[i] = c;
                num[i] = n;
            }

            Queue<String> list = new LinkedList<>();

            for(int j = 0; j < N; j++){
                int loop = num[j];
                while(loop > 0){
                    list.offer(st[j]);
                    loop--;
                }
            }

            System.out.println("#" + tc); //#1
            while(list.size() > 0) {
                int linesize = 0;
                while (linesize < 10) {
                    System.out.print(list.poll());
                    linesize++;
                    if(list.size() == 0)
                        break;
                }
                System.out.println();
            }

        }
    }
}
