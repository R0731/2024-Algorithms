package SWEA.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D4_1251_하나로 {
    static class Island {
        Long X, Y;

        public Island(Long x, Long y) {
            X = x;
            Y = y;
        }

        @Override
        public String toString() {
            return "island{" +
                    "X=" + X +
                    ", Y=" + Y +
                    '}';
        }
    }

    static class Connect implements Comparable<Connect> {
        int A, B;
        Long E;

        public Connect(int a, int b, Long e) {
            A = a;
            B = b;
            E = e;
        }

        @Override
        public String toString() {
            return "Connect{" +
                    "A=" + A +
                    ", B=" + B +
                    ", E=" + E +
                    '}';
        }

        @Override
        public int compareTo(Connect o) {
            return Long.compare(this.E, o.E);
        }
    }

    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= C; tc++){

            int N = Integer.parseInt(br.readLine());

            Island[] islands = new Island[N];

            StringTokenizer line1 = new StringTokenizer(br.readLine());
            StringTokenizer line2 = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++){
                long a = Long.parseLong(line1.nextToken());
                long b = Long.parseLong(line2.nextToken());

                islands[i] = new Island(a, b);
            }

            double E = Double.parseDouble(br.readLine());

            List<Connect> connects = new ArrayList<>();

            for(int i = 0; i < N - 1; i++){
                for(int j = i; j < N; j++){
                    int a = i;
                    int b = j;
                    long e = Math.round(Math.pow(islands[i].X - islands[j].X, 2) + Math.pow(islands[i].Y - islands[j].Y, 2));

                    connects.add(new Connect(a, b, e));

                }
            }

            Collections.sort(connects);

//            for(Connect connect : connects){
//                System.out.println(connect);
//            }

            p = new int[N + 1];

            //makeSet
            for(int i = 1; i <= N; i++){
                p[i] = i;
            }

            int V = 0;
            int idx = -1;
            double ans = 0;

            while(V < N - 1){
                idx++;
                int px = findSet(connects.get(idx).A);
                int py = findSet(connects.get(idx).B);

                if(px != py){
                    union(px, py);
                    ans += connects.get(idx).E;
                    V++;
                }

            }

            ans =  ans * E;

            System.out.println("#" + tc + " " + Math.round(ans));
        }//tc
    }//main

    private static int findSet(int x){
        if(p[x] != x){
            p[x] = findSet(p[x]);
        }
        return p[x];
    }

    private static void union(int x, int y){
        p[y] = x;
    }
}
