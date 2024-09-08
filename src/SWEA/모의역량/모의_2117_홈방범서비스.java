package SWEA.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 모의_2117_홈방범서비스 {
    static class Home{
        int r, c;

        public Home(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Home{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
    static int N, M, K; //맵의 크기, 한 집당 낼 수 있는 돈, 운영범위
    static int[][] map;
    static List<Home> homeLocation; //집의 위치를 저장할 배열
    static int ans; //정답

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer line = new StringTokenizer(br.readLine());
            N = Integer.parseInt(line.nextToken());
            M = Integer.parseInt(line.nextToken());
            K = 1;
            map = new int[N][N];
            homeLocation = new ArrayList<>();
            ans = 0;

            for(int r = 0; r < N; r++){
                line = new StringTokenizer(br.readLine());
                for(int c = 0; c < N; c++){
                    map[r][c] = Integer.parseInt(line.nextToken());
                    if(map[r][c] == 1){
                        homeLocation.add(new Home(r, c));
                    }
                }
            }
//            --------------------초기화 및 입력 완료---------------------------

            int max_zone = 1; //마름모의 범위를 어디까지 탐색할지 정하기
            while(true) {
                int totalMoney = homeLocation.size() * M;
                int cost = max_zone * max_zone + (max_zone - 1) * (max_zone - 1);
                if(cost > totalMoney){ //이 경우 모든 집이 운영비를 내도 값 충당 불가. 볼 필요 X
                    break;
                }
                max_zone++;
            }

            while(K < max_zone){
                int cost = K * K + (K - 1) * (K - 1);
                for(int r = 0; r < N; r++){
                    for(int c = 0; c < N; c++){ //모든 배열 칸을 시작점 삼아서 돌겠다
                        int count = 0; //각 칸마다 세는 숫자 초기화
                        for(Home h : homeLocation){
                            int length = Math.abs(h.r - r) + Math.abs(h.c - c) + 1; //시작점부터 각 집까지의 거리
                            if(length <= K){ //범위 내에 있는 집만 세기
                                count++;
                            }
                        }
                        int earnMoney = count * M;
                        if(earnMoney >= cost && count > ans){ //손해가 나지 않고 집의 개수가 더 많을 때만 업데이트
                            ans = count;
                        }
                    }
                }
                K++;
            }
//            System.out.println(Arrays.deepToString(map));
            System.out.println("#" + tc + " " + ans);
        }//tc

    }//main
}
