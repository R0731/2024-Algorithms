package SWEA.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 모의_2115_벌꿀채취 {
    static int N, M, C; //맵의 크기, 가로로 선택 가능한 벌통의 개수, 1명이 최대 채취 가능한 양
    static int[][] map;
    static int max; //최대 이득

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer line = new StringTokenizer(br.readLine());
            N = Integer.parseInt(line.nextToken());
            M = Integer.parseInt(line.nextToken());
            C = Integer.parseInt(line.nextToken());
            map = new int[N][N];
            for(int r = 0; r < N; r++){
                line = new StringTokenizer(br.readLine());
                for(int c = 0; c < N; c++){
                    map[r][c] = Integer.parseInt(line.nextToken());
                }
            }
//            ------------------초기화 완료---------------------
            int ans = 0;

            //일꾼1 채취
            for(int r = 0; r < N; r++){
                for(int c = 0; c < N - M + 1; c++){
                    max = 0;
                    honey(r, c, 0, 0, 0);
                    int max1 = max;
                    max = 0;
                    int max2 = 0;
                    //일꾼2 채취
                    for(int x = r; x < N; x++) {
                        if (x == r) {
                            for (int y = c + M; y < N - M + 1; y++){
                                honey(x, y, 0, 0, 0);
                            }
                        } else {
                            for (int y = 0; y < N - M + 1; y++) {
                                honey(x, y, 0, 0, 0);
                            }
                        }
                    }
                    max2 = max;
                    ans = Math.max(ans, max1 + max2);
                }
            }

            System.out.println("#" + tc + " " + ans);
        }//tc
    }//main

    //시작 행, 시작 열, M개 이하로 채취할 벌통, 총 벌통 개수, 현재 값
    private static void honey(int r, int c, int idx, int cnt, int currentSum){
        if(cnt > C){
            return;
        }
        if(idx == M){
            max = Math.max(currentSum, max);
            return;
        }

        //해당 위치 벌통 채취시
        honey(r, c + 1, idx + 1, cnt + map[r][c], currentSum + (map[r][c]*map[r][c]));

        //벌통 채취하지 않을 시
        honey(r, c + 1, idx + 1, cnt, currentSum);
    }
}
