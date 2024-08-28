package SWEA.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1864_정사각형방 {
    static int N;
    static int[][] nums;
    static boolean ans;
    static int minN;
    static int max;
    static int count;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());

            nums = new int[N][N];

            ans = false;
            minN = N * N;
            max = 0;
            count = 0;

            for (int r = 0; r < N; r++) {
                StringTokenizer line = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    nums[r][c] = Integer.parseInt(line.nextToken());
                }
            }

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    sum(r, c);
                    if(ans && nums[r][c] < minN){
                        minN = nums[r][c];
                    }
                }
            }

            System.out.println("#" + tc + " ");
        }
    }

    private static void sum(int r, int c){
        if(N * N - nums[r][c] < max){
            return;
        }

        int n = nums[r][c];

        int d = 0;

        while(d < 4){
            if(nums[r + dr[d]][c + dc[d]] == n + 1){
                r += dr[d];
                c += dc[d];
                count++;
                sum(r, c);
                break;
            }
            d++;
        }

        if(count > max){
            max = count;
            ans = true;
        }

        return;
    }
}
