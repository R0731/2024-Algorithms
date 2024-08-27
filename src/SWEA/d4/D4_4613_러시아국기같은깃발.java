package SWEA.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_4613_러시아국기같은깃발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer line2 = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(line2.nextToken());
            int M = Integer.parseInt(line2.nextToken());

            char[][] flag = new char[N][M];

            //깃발 만들기
            for (int r = 0; r < N; r++) {
                String line = br.readLine();
                char[] temp = line.toCharArray();
                for (int c = 0; c < M; c++) {
                    flag[r][c] = temp[c];
                }
            }

            int min = N * M;

            //모두 파란색으로 민다고 가정할 경우
            for (int white = 0; white < N - 2; white++) {
                for (int blue = white + 1; blue < N - 1; blue++) {
                    int count = 0;
                    //흰색의 범위
                    for (int r = 0; r <= white; r++) {
                        for (int c = 0; c < M; c++) {
                            if (flag[r][c] != 'W') {
                                count++;
                            }
                        }
                    }
                    //너무졸려진심
                    //파란색의 범위
                    for (int r = white + 1; r <= blue; r++) {
                        for (int c = 0; c < M; c++) {
                            if (flag[r][c] != 'B') {
                                count++;
                            }
                        }
                    }
                    //빨간색의 범위
                    for (int r = blue + 1; r < N; r++) {
                        for (int c = 0; c < M; c++) {
                            if (flag[r][c] != 'R') {
                                count++;
                            }
                        }
                    }

                    if (count < min) {
                        min = count;
                    }

                }
            }
                    System.out.println("#" + tc + " " + min);
        }
    }
}
