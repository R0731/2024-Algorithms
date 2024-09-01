package SWEA.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D4_2382_미생물격리 {
    static int N, M, K; //네모크기, 시간, 군집 수
    static int[][] bacteria; //세로 위치, 가로 위치, 박테리아 수, 방향
    //공백 상 하 좌 우
    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer line = new StringTokenizer(br.readLine());

            N = Integer.parseInt(line.nextToken());
            M = Integer.parseInt(line.nextToken());
            K = Integer.parseInt(line.nextToken());

            bacteria = new int[K][4];

            for (int i = 0; i < K; i++) {
                line = new StringTokenizer(br.readLine());
                bacteria[i][0] = Integer.parseInt(line.nextToken()); // 세로위치
                bacteria[i][1] = Integer.parseInt(line.nextToken()); // 가로위치
                bacteria[i][2] = Integer.parseInt(line.nextToken()); // 미생물 수
                bacteria[i][3] = Integer.parseInt(line.nextToken()); // 이동방향
            }

            move();

            int sum = 0;
            for (int i = 0; i < K; i++) {
                sum += bacteria[i][2];
            }

            System.out.println("#" + tc + " " + sum);
        }
    }

    private static void move() {
        int time = 0;

        while (time < M) {
            Map<String, List<int[]>> map = new HashMap<>();
            for (int i = 0; i < K; i++) {
                if (bacteria[i][2] > 0) {
                    int r = bacteria[i][0];
                    int c = bacteria[i][1];
                    int d = bacteria[i][3];
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr == 0 || nr == N - 1 || nc == 0 || nc == N - 1) {
                        bacteria[i][2] /= 2;
                        bacteria[i][3] = (d % 2 == 0) ? d - 1 : d + 1;
                        ;
                    }

                    bacteria[i][0] = nr;
                    bacteria[i][1] = nc;

                    String key = nr + "," + nc;
                    map.putIfAbsent(key, new ArrayList<>());
                    map.get(key).add(bacteria[i]);
                }
            }

            //같은 위치 탐색
            for (String key : map.keySet()) {
                //각 List에 저장된 크기가 1보다 클 경우에만 처리
                List<int[]> bacteriaList = map.get(key);
                if (bacteriaList.size() > 1) {
                    int[] large = bacteriaList.get(0);
                    int max = 0;

                    for (int i = 1; i < bacteriaList.size(); i++) {
                        if (bacteriaList.get(i)[2] > large[2]) {
                            large = bacteriaList.get(i);
                            max = i;
                        }
                    }

                    for (int i = 0; i < bacteriaList.size(); i++) {
                        if (i != max) {
                            large[2] += bacteriaList.get(i)[2];
                            bacteriaList.get(i)[2] = 0;
                        }
                    }
                }

            }
            time++;
        }
    }
}
