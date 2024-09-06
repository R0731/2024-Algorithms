package SWEA.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 모의_2382_미생물격리 {
    static class Bacteria{
        int r, c, size, d; //행, 열, 군집크기, 방향

        public Bacteria(int r, int c, int size, int d){
            this.r = r;
            this.c = c;
            this.size = size;
            this.d = d;
        }

        @Override
        public String toString() {
            return "Bacteria{" +
                    "r=" + r +
                    ", c=" + c +
                    ", size=" + size +
                    ", d=" + d +
                    '}' + "\n";
        }

    }
    static int N, M, K; //네모크기, 시간, 군집의 수
    static int[][] nemo;
    static Bacteria[] bacterias;
    //상하좌우가 1234로 주어짐
    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, -1, 1};
    static int ans; //남은 미생물 수(정답)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer line = new StringTokenizer(br.readLine());
            N = Integer.parseInt(line.nextToken());
            M = Integer.parseInt(line.nextToken());
            K = Integer.parseInt(line.nextToken());
            nemo = new int[N][N];
            bacterias = new Bacteria[K];
            ans = 0;

            for(int i = 0; i < K; i++){
                line = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(line.nextToken());
                int c = Integer.parseInt(line.nextToken());
                int size = Integer.parseInt(line.nextToken());
                int d = Integer.parseInt(line.nextToken());

                bacterias[i] = new Bacteria(r, c, size, d);
            }
            //----------초기화 완료-----------
//            System.out.println(Arrays.toString(bacterias));
            for(int i = 0; i < M; i++){
                move();
                fight();
            }

//            System.out.println(Arrays.toString(bacterias));

            //모든 과정을 거치고 살아남은 박테리아 더하기
            for(int i = 0; i < K; i++){
                ans+= bacterias[i].size;
            }

            System.out.println("#" + tc + " " + ans);
        }//tc
    }//main

    //박테리아 위치 변화
    private static void move(){
        for(int i = 0; i < K; i++) {
            if (bacterias[i].size > 0) { //살아남은 군집이 있는 경우에만 진행
                int d = bacterias[i].d;
                int nr = bacterias[i].r + dr[d];
                int nc = bacterias[i].c + dc[d];
                if (nr == 0 || nr == N - 1 || nc == 0 || nc == N - 1) { //박테리아가 약품에 닿으면
                    bacterias[i].size /= 2;
                    //방향 변경
                    if(d % 2 == 0){ //짝수일때
                        bacterias[i].d = d - 1;
                    }else{ //홀수일때
                        bacterias[i].d = d + 1;
                    }
                }
                bacterias[i].r = nr;
                bacterias[i].c = nc;
            }
        }
    }//move

    //박테리아 위치 중복 탐색
//    private static void fight(){
//        for(int i = 0; i < K; i++) {
//            if (bacterias[i].size > 0) {
//                int r1 = bacterias[i].r;
//                int c1 = bacterias[i].c;
//                Bacteria temp = new Bacteria(bacterias[i].r, bacterias[i].c, bacterias[i].size,bacterias[i].d);
//                int sum = bacterias[i].size;
//                for (int j = i + 1; j < K; j++) {
//                    if(bacterias[j].size > 0) { //살아남은 군집이 있는 경우만
//                        int r2 = bacterias[j].r;
//                        int c2 = bacterias[j].c;
//                        if (r1 == r2 && c1 == c2) {
//                            if(bacterias[j].size > temp.size) {
//                                temp.size = bacterias[j].size;
//                                temp.d = bacterias[j].d;//담고
//                            }
//                            sum += bacterias[j].size;
//                            bacterias[j].size = 0; //어차피 이긴 것만 살아남으니까
//                        }
//                    }
//                }
//                bacterias[i].size = sum;
//                bacterias[i].d = temp.d;
//            }
//        }
//    }//fight

    private static void fight(){
        Map<String, List<Bacteria>> map = new HashMap<>();

        for(int i = 0; i < K; i++) {
            if (bacterias[i].size > 0) {
                String temp = bacterias[i].r + "," + bacterias[i].c;
                map.putIfAbsent(temp, new ArrayList<>());
                map.get(temp).add(bacterias[i]);
            }
        }

        for(String key : map.keySet()){
            List<Bacteria> list = map.get(key);

            if(list.size() > 1) {
                Bacteria largest = list.get(0);
                int sum = 0;

                for (Bacteria b : list) {
                    sum += b.size;
                    if (b.size > largest.size) {
                        largest = b;
                    }
                }

                for (Bacteria b : list) {
                    if (b != largest) {
                        b.size = 0;
                    }
                }

                largest.size = sum;
            }

        }
    }//fight

}
