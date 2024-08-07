package d3_천의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D3_1289_원재의메모리복구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String str = br.readLine();

            char[] bit = str.toCharArray(); //원본 배열

            char[] zero = new char[bit.length];
            Arrays.fill(zero,'0');

            int count = 0;

            while(!Arrays.equals(bit, zero)){
                for(int i = 0; i < bit.length; i++){
                    if(bit[i] != zero[i]){
                        for(int j = i; j < bit.length; j++){
                            zero[j] = bit[i];
                        }
                        count++;
                    }
                }
            }

            System.out.println("#" + tc + " " + count);
        }
    }
}