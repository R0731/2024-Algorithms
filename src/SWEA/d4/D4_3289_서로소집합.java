package SWEA.d4;

import java.util.Arrays;
import java.util.Scanner;

public class D4_3289_서로소집합 {
    static class Edge{
        int command, A, B;

        public Edge(int command, int a, int b) {
            this.command = command;
            A = a;
            B = b;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "command=" + command +
                    ", A=" + A +
                    ", B=" + B +
                    '}' + "\n";
        }
    }

    static int n, m;
    static int[] p;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            StringBuilder sb = new StringBuilder(); //정답 출력용
            n = sc.nextInt();
            m = sc.nextInt();

            Edge[] edges = new Edge[m];

            for(int i = 0; i < m; i++){
                int command = sc.nextInt();
                int a = sc.nextInt();
                int b = sc.nextInt();

                edges[i] = new Edge(command, a, b);

            }

            p = new int[n + 1];

            //makeSet
            for(int i = 1; i <= n; i++){
                p[i] = i;
            }

//            System.out.println(Arrays.toString(edges));

            for(int i = 0; i < m; i++){
                if(edges[i].command == 0){
                    int a = findSet(edges[i].A);
                    int b = findSet(edges[i].B);
                    if(a != b) {
                        union(a, b);
                    }
                }else if(edges[i].command == 1){
                    int a = findSet(edges[i].A);
                    int b = findSet(edges[i].B);

                    if(a == b){
                        sb.append(1);
                    }else{
                        sb.append(0);
                    }
                }
            }

            System.out.println("#" + tc + " " + sb);

        }

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
