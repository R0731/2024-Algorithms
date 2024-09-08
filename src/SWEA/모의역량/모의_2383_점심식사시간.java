package SWEA.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 모의_2383_점심식사시간 {
    static class Stairs{
        int r, c, K; //계단이 있는 행, 렬, 내려가는 데 걸리는 시간

        public Stairs(int r, int c, int k) {
            this.r = r;
            this.c = c;
            K = k;
        }
    }

    static class Person{
        int r, c; //사람이 있는 위치
        int stair; //사람이 선택한 계단
        int distance; //내려가는데 걸리는 시간

        public Person(int r, int c) {
            this.r = r;
            this.c = c;
        }

        void calculateDistance(){
            this.distance = Math.abs(this.r - stairs[stair].r) + Math.abs(this.c - stairs[stair].c); //선택한 계단과의 거리
        }

    }

    static int N; //맵의 크기 결정 변수
    static int[][] map; //
    static Stairs[] stairs; //계단의 정보
    static List<Person> person; //사람의 정보
    static boolean[] visitP; //사람 사용 유무
    static Queue<Person>[] queue; //사람을 넣을 큐
    static int min; //최소값이 정답

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            stairs = new Stairs[2];
            person = new ArrayList<>();
            queue = new Queue[2];
            queue[0] = new LinkedList<>();
            queue[1] = new LinkedList<>();
            min = Integer.MAX_VALUE;

            int stairIndex = 0;

            for(int r = 0; r < N; r++){
                StringTokenizer line = new StringTokenizer(br.readLine());
                for(int c = 0; c < N; c++){
                    map[r][c] = Integer.parseInt(line.nextToken());
                    if(map[r][c] == 1){
                        person.add(new Person(r, c));
                    }else if(map[r][c] > 1){
                        stairs[stairIndex] = new Stairs(r, c, map[r][c]);
                        stairIndex++;
                    }
                }
            }
//           ------------------초기화 완료----------------

            //부분집합을 이용해 누가 어느 계단을 이용할지 정해준다
            powerSet(0);

            System.out.println("#" + tc +" ");
        }//tc

    }//main

    private static void powerSet(int idx){
        if(idx == person.size()){
            int time = simulation();
            if(min > time) min = time;
            return;
        }

        person.get(idx).stair = 0;
        person.get(idx).calculateDistance();
        powerSet(idx + 1);

        person.get(idx).stair = 1;
        person.get(idx).calculateDistance();
        powerSet(idx + 1);

    }

    private static int simulation(){
        visitP = new boolean[person.size()];
        int cnt = 0;
        int time = 1;

        while(true){
            for(Queue<Person> q : queue){
                int size = q.size();

            }
        }
    }

}
