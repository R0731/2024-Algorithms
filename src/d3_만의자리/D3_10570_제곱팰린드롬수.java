package d3_만의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_10570_제곱팰린드롬수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer line = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(line.nextToken());
            int B = Integer.parseInt(line.nextToken());


            int count = 0;

            for(int i = A; i <= B; i++) {
                int n = (int) Math.sqrt(i);
                if ( (n * n == i) && pel(i) && pel(n))
                    count++;
            }


            System.out.println("#" + tc + " " + count);
        }
    }

    //회문 만들기
    static boolean pel(int num){
        String str = Integer.toString(num);
        int N = str.length();
        for(int i = 0; i < N / 2; i++){
            if(str.charAt(i) != str.charAt(N-1-i)){
                return false;
            }
        }
        return true;
    }
}