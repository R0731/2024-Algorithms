package SWEA.d4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class D4_7465_창용마을무리의개수 {
    static class Edge{
        int A, B;

        public Edge(int a, int b) {
            A = a;
            B = b;
        }

        @Override
        public String toString() {
            return "edge{" +
                    "A=" + A +
                    ", B=" + B +
                    '}'+"\n";
        }
    }

    static int[] p;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){

            int N = sc.nextInt();
            int M = sc.nextInt();

            Edge[] edges = new Edge[M];

            for(int i = 0; i < M; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();

                edges[i] = new Edge(a, b);
            }

//            System.out.println(Arrays.toString(edges));

            p = new int[N + 1];

            //makeSet
            for(int i = 1; i <= N; i++){
                p[i] = i;
            }

            for(int i = 0; i < M; i++){
                int px = findSet(edges[i].A);
                int py = findSet(edges[i].B);

                if(px != py){
                    union(px, py);
                }
            }

            List<Integer> temp = new ArrayList<>();

            for(int i = 1; i <= N; i++){
                int a = findSet(p[i]);

                if(!temp.contains(a)){
                    temp.add(a);
                }
            }

            System.out.println("#" + tc + " " + temp.size());
        }//tc
    }//main

    static int findSet(int x){
        if(x != p[x]){
            p[x] = findSet(p[x]);
        }
        return p[x];
    }

    static void union(int x, int y){
        p[y] = x;
    }
}
