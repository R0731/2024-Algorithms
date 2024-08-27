package SWEA.d3_천의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D3_1240_단순2진암호코드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer line = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(line.nextToken());
            int M = Integer.parseInt(line.nextToken());

            char[][] nemo = new char[N][M];

            for(int r = 0; r < N; r++) {
                String line2 = br.readLine();
                char[] temp = line2.toCharArray();
                for (int c = 0; c < M; c++) {
                    nemo[r][c] = temp[c];
                }
            }

            //암호코드에 해당하는 줄 구하기
            int password_row = 0;

            for(int r = 0; r < N && password_row == 0; r++){
                for(int c = 0; c < M; c++){
                    if(nemo[r][c] != '0'){
                        password_row = r;
                        break;
                    }
                }
            }

            //뒤에서부터 패스워드 찾기
            int password_end = M - 1;

            while(nemo[password_row][password_end] != '1'){
                password_end--;
            }

            int password_start = password_end - 55;

            //패스워드 쌓을 스택 만들기
            Queue<Integer> password = new LinkedList<>();

            for(int i = 0; i < 8; i++){ // 숫자 7개씩 자를 때마다
                String temp = "";
                for(int c = i * 7; c < (i + 1) * 7; c++){
                    temp += nemo[password_row][password_start + c] + "";
                }
                int p = foundPassWord(temp);
                password.add(p);
            }

            int odd = 0; //홀수자리합
            int even = 0; //짝수자리합

            while(!password.isEmpty()){
                odd += password.poll();
                if(!password.isEmpty())
                    even += password.poll();
            }

            boolean right = true;

            if(((odd * 3) + even) % 10 != 0) {
                right = false;
            }

            int sum = 0;

            if(right){
                sum = odd + even;
            }



            System.out.println("#" + tc + " " + sum);
        }
    }

    static int foundPassWord(String temp) {
        int passWord = 0;
        switch (temp){
            case "0001101":
                 passWord = 0;
                 break;
            case "0011001":
                passWord = 1;
                break;
            case "0010011":
                passWord = 2;
                break;
            case "0111101":
                passWord = 3;
                break;
            case "0100011":
                passWord = 4;
                break;
            case "0110001":
                passWord = 5;
                break;
            case "0101111":
                passWord = 6;
                break;
            case "0111011":
                passWord = 7;
                break;
            case "0110111":
                passWord = 8;
                break;
            default:
                passWord = 9;
        }
        return passWord;
    }
}
