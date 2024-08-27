package SWEA.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class D2_1859_백만장자프로젝트_Re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer line = new StringTokenizer(br.readLine());

            Stack<Integer> arr = new Stack<>();

            for(int i = 0; i < N; i++){
                int a = Integer.parseInt(line.nextToken());
                arr.add(a);
            }

            long sum = 0;
            int max = arr.pop();

            while(!arr.isEmpty()){
                int a = arr.pop();
                if(a < max){
                    sum += max - a;
                }else{
                    max = a;
                }
            }

            System.out.println("#" + tc + " " + sum);

        }
    }
}
