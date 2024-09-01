package SWEA.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D4_2383_점심식사시간 {
    static int N;
    static int[][] nemo;
    static List<int[]> Person; //사람의 위치
    static List<int[]> Stairs; //계단의 위치
    static int Psize;
    static int[] firstGroup;
    static int[] secondGroup;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            nemo = new int[N][N];
            Person = new ArrayList<>();
            Stairs = new ArrayList<>();

            for(int r = 0; r < N; r++){
                StringTokenizer line = new StringTokenizer(br.readLine());
                for(int c = 0; c < N; c++){
                    nemo[r][c] = Integer.parseInt(line.nextToken());
                    if(nemo[r][c] == 1){
                        Person.add(new int[]{r, c, 0}); //사람의 위치
                    }else if(nemo[r][c] >= 2){
                        Stairs.add(new int[]{r, c, nemo[r][c]}); //계단의 위치 및 소요시간 저장
                    }
                }
            }
            Psize = Person.size();

            if(Psize % 2 == 0) {
                firstGroup = new int[Psize / 2];
            }else{
                firstGroup = new int[Psize / 2 + 1];
                secondGroup = new int[Psize / 2];
            }

            group(0);

            move();

            System.out.println("#" + tc + " ");
        }
    }//main

    //1. 계단은 두 개니까 사람이 0번 계단을 사용할 지 1번 계단을 사용할 지 조합으로 나누어 정하기
    //2. 각 계단을 통해 최소 시간
    //3. 움직이기

    private static void group(int sidx){

    }
    private static void move(){
        //가장 가까운 계단 탐색해서 계단에서 가까운 사람부터 내려가기
        List<int[]> list = new ArrayList<>();

        for(int i = 0; i < Psize; i++){
            list.add(new int[]{3, 20});
            int min = 20;
            int pr = Person.get(i)[0];
            int pc = Person.get(i)[1];
            for(int j = 0; j < Stairs.size(); j++){
                int sr = Stairs.get(j)[0];
                int sc = Stairs.get(j)[1];
                int length = Math.abs(pr - sr) + Math.abs(pc - sc);
                if(length < min){
                    min = length;
                }
            }

        }
        //계단에서 기다려야 하는 경우에는 그 다음으로 가까운 계단 탐색해서 계단 내려가는 소요시간 이하일 때 이동
    }

}
