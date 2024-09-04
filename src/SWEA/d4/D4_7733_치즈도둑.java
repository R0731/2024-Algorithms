package SWEA.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_7733_치즈도둑 {
    static class Cheese{
        int day;
        boolean eat;

        public Cheese(int day, boolean eat) {
            this.day = day;
            this.eat = eat;
        }

        @Override
        public String toString() {
            return "Cheese{" +
                    "day=" + day +
                    ", eat=" + eat +
                    '}';
        }
    }

    static int N;
    static int maxDay;
    static Cheese[][]cheese;
    static boolean[][] visited;
    //상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());

            cheese = new Cheese[N][N];
            maxDay = 1;
            ans = 0;

            for(int r = 0; r < N; r++){
                StringTokenizer line = new StringTokenizer(br.readLine());
                for(int c = 0; c < N; c++){
                    int a = Integer.parseInt(line.nextToken());
                    if(a > maxDay) maxDay = a;
                    cheese[r][c] = new Cheese(a, false);
                }
            }

//            System.out.println(Arrays.deepToString(cheese));

            for(int i = 0; i <= maxDay; i++){
                //치즈 먹은 후
                visited = new boolean[N][N];
                int count = 0;
                for(int r = 0; r < N; r++){
                    for(int c = 0; c < N; c++){
                        if(cheese[r][c].day == i) {
                            cheese[r][c].eat = true;
                        }
                    }
                }
                //덩어리 개수 찾기
                for(int r = 0; r < N; r++){
                    for(int c = 0; c < N; c++){
                        if(!visited[r][c] && !cheese[r][c].eat) {
                            dfs(r, c);
                            count++;
                        }
                    }
                }

                ans = Math.max(ans, count);
            }

            System.out.println("#" + tc + " " + ans);
        }//tc
    }//main

    private static void dfs(int r, int c){
        visited[r][c] = true;

        for(int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && !cheese[nr][nc].eat){
                dfs(nr, nc);
            }
        }
    }
}
