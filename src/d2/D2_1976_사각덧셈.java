package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1976_사각덧셈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer line = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(line.nextToken());
            int b = Integer.parseInt(line.nextToken());
            int c = Integer.parseInt(line.nextToken());
            int d = Integer.parseInt(line.nextToken());

            int n1 = a + c;
            int n2 = b + d;
            if(n2 >= 60) {
                n2 = n2 - 60;
                n1++;
            }

            if(n1 > 12){
                n1 = n1-12;
            }

            System.out.println("#" + tc + " " + n1 + " " + n2);
        }

    }

}
