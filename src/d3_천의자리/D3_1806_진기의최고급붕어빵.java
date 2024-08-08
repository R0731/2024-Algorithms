package d3_천의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

            for(int i = 0; i < N; i++){
                customer[i] = Integer.parseInt(line2.nextToken());
            }

            for(int i = 1; i < customer.length; i++){
                int data = customer[i];
                int j;
                for(j = i - 1; j >= 0 && customer[j] > data; j--){
                    customer[j + 1] = customer[j];
                }
                customer[j + 1] = data;
            }


            int time = 1;
            int fish = 0;
            int cnumber = 0;

            String ans = "Possible";

            while(cnumber < N){
                int c = customer[cnumber];
                time++;
                if((time % M) == 0) {
                  fish += K;
                }
                if(time >= c && fish < 1){
                    ans = "Impossible";
                    break;
                }else if(time == c) {
                    fish--;
                    cnumber++;
                }
            }



//            int time = 1;
//            int fish = 0;
//            int ctime = 1;
//            String ans = "Possible";
//
//            while(!customer.isEmpty()){
//                int c = customer.peek();
//                time++;
//                ctime++;
//                if((time % M) == 0) {
//                    fish += K;
//                }
//
//                if(ctime == c && fish < 1){
//                    ans = "Impossible";
//                    break;
//                }else if(ctime == c){
//                    customer.poll();
//                    fish--;
//                    ctime = 0;
//                }
//
//            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}

