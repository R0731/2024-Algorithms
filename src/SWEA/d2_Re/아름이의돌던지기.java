package SWEA.d2_Re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 아름이의돌던지기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());

            StringTokenizer line = new StringTokenizer(br.readLine());

            int min = 100000;

            while(line.hasMoreTokens()){
                int num = Integer.parseInt(line.nextToken());

                if(Math.abs(num) < min){

                }
            }


            System.out.println("#" + tc + " ");
        }
    }
}
