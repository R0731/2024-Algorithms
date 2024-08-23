package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_4613_Re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(line.nextToken());
            int M = Integer.parseInt(line.nextToken());

            char[][] flag = new char[N][M];

            for (int r = 0; r < N; r++) {
                String str = br.readLine();
                flag[r] = str.toCharArray();
            }

            int min = N * M;

            for (int white = 0; white < N - 2; white++) {
                for (int blue = white + 1; blue < N - 1; blue++) {
                    int change = 0;
                    for (int w = 0; w <= white; w++) {
                        for (int c = 0; c < M; c++) {
                            if (flag[w][c] != 'W') {
                                change++;
                            }
                        }
                    }
                    for (int b = white + 1; b <= blue; b++) {
                        for (int c = 0; c < M; c++) {
                            if (flag[b][c] != 'B') {
                                change++;
                            }
                        }
                    }
                    for (int r = blue + 1; r < N; r++) {
                        for (int c = 0; c < M; c++) {
                            if (flag[r][c] != 'R') {
                                change++;
                            }
                        }
                    }
                    if (change < min) {
                        min = change;
                    }
                }
            }

            System.out.println("#" + tc + " " + min);
        }

    }
}
