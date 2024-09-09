package SWEA.d6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D6_1267_작업순서 {
    static int V, E; //정점의 개수(1부터 시작), 간선의 개수
    static int[][] adjArr; //연결 배열
    static int[] degree; //진입차수
    static Queue<Integer> queue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++){
            V = sc.nextInt();
            E = sc.nextInt();
            adjArr = new int[V + 1][V + 1];
            degree = new int[V + 1];
            queue = new LinkedList<>();
            for(int i = 0; i < E; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();

                adjArr[a][b] = 1;
                degree[b]++;
            }
//            ----------초기화 완료------------
            StringBuilder sb = new StringBuilder();//답안 출력용

            for(int i = 1; i < V + 1; i++){
                if(degree[i] == 0){
                    queue.add(i);
                }
            }

            while(!queue.isEmpty()){
                int curr = queue.poll();
                sb.append(curr).append(" ");

                for(int i = 1; i < V + 1; i++){
                    if(adjArr[curr][i] == 1){
                        adjArr[curr][i] = 0;
                        degree[i]--;
                        if(degree[i] == 0){
                            queue.add(i);
                        }
                    }
                }
            }//while

            System.out.println("#" + tc + " " + sb);
        }//tc
    }//main
}
