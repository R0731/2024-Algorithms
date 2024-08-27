package SWEA.d3_천의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D3_1225_암호생성기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc = 1; tc <= 10; tc++){
            int T = Integer.parseInt(br.readLine());

            StringTokenizer line = new StringTokenizer(br.readLine());

            Queue<Integer> queue = new LinkedList<>();

            for(int i = 0; i < 8; i++) {
                queue.add(Integer.parseInt(line.nextToken()));
            }


            int minus = 1;

            while(true){
                int a = queue.poll() - minus;
                if(a <= 0){
                    queue.add(0);
                    break;
                }else if(a > 0){
                    queue.add(a);
                    minus++;
                }

                if(minus > 5)
                    minus = 1;
            }

            Queue<Integer> ans = new LinkedList<>();

            System.out.print("#" + T + " ");

            while(!(queue.isEmpty())){
                   System.out.print(queue.poll() + " ");;
            }
            System.out.println();


        }

    }
}
