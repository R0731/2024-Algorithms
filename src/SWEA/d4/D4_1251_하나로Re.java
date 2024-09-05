package SWEA.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D4_1251_하나로Re {
    static class Island {
        int X, Y;

            public Island(int x, int y) {
                X = x;
                Y = y;
            }
    }

    static class Connect implements Comparable<Connect>{
        int Y;
        long distance;

        public Connect(int y, long distance) {
            Y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Connect o) {
            return Long.compare(this.distance, o.distance);
        }
    }

    static int N;
    static double E;
    static Island[] islands;
    static List<Connect>[] connects;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            islands = new Island[N];
            connects = new ArrayList[N];
            visited = new boolean[N];

            for(int i = 0; i < N; i++){
                connects[i] = new ArrayList<>();
            }//실제 생성 완료

            StringTokenizer line1 = new StringTokenizer(br.readLine());
            StringTokenizer line2 = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                int x = Integer.parseInt(line1.nextToken());
                int y = Integer.parseInt(line2.nextToken());

                islands[i] = new Island(x, y);
            }

            E = Double.parseDouble(br.readLine());

            for(int i = 0; i < N; i++){
                for(int j = i + 1; j < N; j++){
                    long dx = islands[i].X - islands[j].X;
                    long dy = islands[i].Y - islands[j].Y;
                    long d = dx * dx + dy * dy;

                    connects[i].add(new Connect(j, d));
                    connects[j].add(new Connect(i, d));
                }
            }

            PriorityQueue<Connect> pq = new PriorityQueue<>();
            visited[0] = true;

            long sum = 0;
            int pick = 1;

            pq.addAll(connects[0]);

            while(pick != N){
                Connect c = pq.poll();
                if(visited[c.Y]) continue;

                sum += c.distance;
                visited[c.Y] = true;
                pick++;

                pq.addAll(connects[c.Y]);

            }

            double ans = sum * E;

            System.out.println("#" + tc+ " " + Math.round(ans));
        }//tc
    }//main
}
