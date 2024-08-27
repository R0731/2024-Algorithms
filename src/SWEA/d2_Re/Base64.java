package SWEA.d2_Re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Base64 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            String line = br.readLine();

            char[] c = line.toCharArray();

            int[] base = new int[c.length];


            for(int i = 0; i < c.length; i++){

            }

            System.out.println("#" + tc + " ");
        }
    }
}
