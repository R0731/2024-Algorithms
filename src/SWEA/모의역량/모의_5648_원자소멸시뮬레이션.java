package SWEA.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 모의_5648_원자소멸시뮬레이션 {
    static class Atom{
        int x, y, d, k; //x축(열), y축(행), 이동방향, 에너지

        public Atom(int y, int x, int d, int k) {
            this.y = y;
            this.x = x;
            this.d = d;
            this.k = k;
        }
    }
    static int N; //N개의 원자
    static int[][] map;
    //상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<Atom> atoms;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            map = new int[4001][4001];
            atoms = new LinkedList<>();
            ans = 0;
            for(int i = 0; i < N; i++){
                StringTokenizer line = new StringTokenizer(br.readLine());
                int x = (Integer.parseInt(line.nextToken()) + 1000) * 2;
                int y = (Integer.parseInt(line.nextToken()) + 1000) * 2;
                int d = Integer.parseInt(line.nextToken());
                int k = Integer.parseInt(line.nextToken());

                atoms.add(new Atom(y, x, d, k));
                map[y][x] = k;
            }

            move();

            System.out.println("#" + tc + " " + ans);
        }//tc
    }//main

    private static void move(){
        int r, c, d, k, nr, nc;
        List<int[]> check = new ArrayList<>();
        while(!atoms.isEmpty()) {
            int n = atoms.size();
            boolean[][] visited = new boolean[4001][4001];
            for(int i = 0; i < n; i++) {
                Atom temp = atoms.poll();
                r = temp.y;
                c = temp.x;
                d = temp.d;
                k = temp.k;

                if(map[r][c] == 0) continue; //충돌로 사라진 원자

                nr = r + dr[d];
                nc = c + dr[d];

                if (nr < 0 || nr >= 4001 || nc < 0 || nc >= 4001) {
                    map[r][c] = 0;
                    continue;
                }

                if(!visited[nr][nc]) {
                    atoms.offer(new Atom(nr, nc, d, k));
                    map[r][c] = 0;
                    map[nr][nc] += k;
                    visited[nr][nc] = true;
                }else{
                    check.add(new int[]{nr, nc});
                    ans += k;
                }
            }
            for(int[] num : check){
                int i = num[0];
                int j = num[1];
                ans += map[i][j];
                map[i][j] = 0;
            }
        }


    }

}
