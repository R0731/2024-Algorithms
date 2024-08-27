package SWEA.d3_천의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D3_3499_퍼펙트셔플 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            int N = Integer.parseInt(br.readLine());

            StringTokenizer line = new StringTokenizer(br.readLine());

            Queue<String> queue1 = new LinkedList<>();
            Queue<String> queue2 = new LinkedList<>();

            if(N % 2 == 1){
                for (int i = 0; i < (N / 2) + 1; i++) {
                    queue1.add(line.nextToken());
                }

            }else{
                for (int i = 0; i < N / 2; i++) {
                    queue1.add(line.nextToken());
                }
            }

            for (int i = 0; i < N / 2; i++) {
                queue2.add(line.nextToken());
            }


            System.out.print("#" + tc + " ");
            while(!(queue1.isEmpty()) || !(queue2.isEmpty())) {
                if(!(queue1.isEmpty())){
                    System.out.print(queue1.poll() + " ");
                }
                if(!(queue2.isEmpty()))
                    System.out.print(queue2.poll() + " ");
                }
            System.out.println();
        }
    }
}