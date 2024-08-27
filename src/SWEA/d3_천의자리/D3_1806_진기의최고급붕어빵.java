package SWEA.d3_천의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D3_1806_진기의최고급붕어빵 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer line = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(line.nextToken());
            int M = Integer.parseInt(line.nextToken()); //시간
            int K = Integer.parseInt(line.nextToken()); //만들 수 있는 붕어빵의 개수

            StringTokenizer line2 = new StringTokenizer(br.readLine());

            int[] customer = new int[N];

            for (int i = 0; i < N; i++) {
                customer[i] = Integer.parseInt(line2.nextToken());
            }

            //손님 정렬
            for (int i = 1; i < customer.length; i++) {
                int data = customer[i];
                int j;
                for (j = i - 1; j >= 0 && customer[j] > data; j--) {
                    customer[j + 1] = customer[j];
                }
                customer[j + 1] = data;
            }

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < customer.length; i++) {
                queue.add(customer[i]);
            }


            int time = 0;
            int fish = 0;

            String ans = "Possible";

            while (!queue.isEmpty()) {
                int c = queue.peek();
                while (time < c) {
                    time++;
                    if ((time % M) == 0) {
                        fish += K;
                    }
                }

                if (fish < 1) {
                    ans = "Impossible";
                    break;
                }
                fish--;
                queue.poll();
            }

            System.out.println("#" + tc + " " + ans);

        }


    }
}

