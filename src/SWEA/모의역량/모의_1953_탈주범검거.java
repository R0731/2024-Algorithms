package SWEA.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 모의_1953_탈주범검거 {
    static int N, M; //지하터널 세로 가로 크기
    static int R, C; //맨홀뚜껑 시작점
    static int L; //탈출 후 소요 시간
    static int ans; //정답(탈출할 수 있는 위치의 개수)
    static int[][] map;
    static boolean[][] visited;
    //상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    //터널커맨드
    static List<Integer>[] tunnel = new ArrayList[8];
    private static void addList(){
        for(int i = 0; i < 8; i++){
            tunnel[i] = new ArrayList<>();
        }

        Collections.addAll(tunnel[1], 0, 1, 2, 3);
        Collections.addAll(tunnel[2], 0, 1);
        Collections.addAll(tunnel[3], 2, 3);
        Collections.addAll(tunnel[4], 0, 3);
        Collections.addAll(tunnel[5], 1, 3);
        Collections.addAll(tunnel[6], 1, 2);
        Collections.addAll(tunnel[7], 0, 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer line = new StringTokenizer(br.readLine());
            N = Integer.parseInt(line.nextToken());
            M = Integer.parseInt(line.nextToken());
            R = Integer.parseInt(line.nextToken());
            C = Integer.parseInt(line.nextToken());
            L = Integer.parseInt(line.nextToken());
            ans = 0;
            map = new int[N][M];
            visited = new boolean[N][M];
            addList();

            for(int r = 0; r < N; r++){
                line = new StringTokenizer(br.readLine());
                for(int c = 0; c < M; c++){
                    map[r][c] = Integer.parseInt(line.nextToken());
                }
            }
            //---------------------초기화 완료------------------------

            ans = bfs(R, C);

            System.out.println("#" + tc + " " + ans);
        }//tc
    }//main

    private static int bfs(int startR, int startC){
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{startR, startC, 1}); //시작 값 추가
        visited[startR][startC] = true; //방문 처리

        int count = 1; //방문할 수 있는 터널의 개수. 시작 값을 넣었으니까 1개부터 시작

        while(!q.isEmpty()){ //q가 빌 때까지 실행
            int[] idx = q.poll();
            int r = idx[0];
            int c = idx[1];
            int currentTime = idx[2];

            if(currentTime >= L) continue;
            int command = map[r][c];
            for(int i = 0; i < tunnel[command].size(); i++){
                int d = tunnel[command].get(i);
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == 0) continue;
                if(possible(d, nr, nc)){
                    q.add(new int[]{nr, nc, currentTime + 1});
                    visited[nr][nc] = true;
                    count++;
                }
            }
        }

        return count;

    }//bfs

    private static boolean possible(int d, int nr, int nc){
        //서로 이동할 수 있는지 판단
        if(d == 0){ //상
            if(map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 5 || map[nr][nc] == 6) {
                return true;
            }
        }else if(d == 1){ //하
            if(map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 7) {
                return true;
            }
        }else if(d == 2){ //좌
            if(map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 5) {
                return true;
            }
        }else if(d == 3){ //우
            if(map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 6 || map[nr][nc] == 7) {
                return true;
            }
        }

        return false;
    }
}
