package SWEA.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1940_가랏RC카 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine()); //N초동안 이동거리 구해야함

            //커맨드 배열에 저장하기
            int[] command = new int[N];
            int[] speed = new int[N];
            for (int i = 0; i < N; i++) {
                StringTokenizer line = new StringTokenizer(br.readLine());

                command[i] = Integer.parseInt(line.nextToken());

                if(!(command[i] == 0)){
                    speed[i] = Integer.parseInt(line.nextToken());
                }

            }

            int nowspeed = 0;
            int sum = 0;

            for (int i = 0; i < N; i++) {
                if (command[i] == 0) {
                    sum += nowspeed;
                } else if (command[i] == 1) {
                    nowspeed += speed[i];
                    sum += nowspeed;
                } else if (command[i] == 2) {
                    if (nowspeed <= speed[i]) {
                        nowspeed = 0;
                        sum += nowspeed;
                    } else {
                        nowspeed -= speed[i];
                        sum += nowspeed;
                    }
                }


            }

                System.out.println("#" + tc + " " + sum);
        }
    }
}