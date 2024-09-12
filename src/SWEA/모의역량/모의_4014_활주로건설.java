package SWEA.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 모의_4014_활주로건설 {
    static int N, X; //map의 크기, 경사로의 길이
    static int[][] map;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer line = new StringTokenizer(br.readLine());
            N = Integer.parseInt(line.nextToken());
            X = Integer.parseInt(line.nextToken());
            map = new int[N][N];
            ans = 0;
            for(int r = 0; r < N; r++){
                line = new StringTokenizer(br.readLine());
                for(int c = 0; c < N; c++){
                    map[r][c] = Integer.parseInt(line.nextToken());
                }
            }
//            for(int i = 0; i < N; i++){
//                if(possibleRow(i)) ans++; //가로 탐색
//                if(possibleCol(i)) ans++; //세로 탐색
//            }
//            System.out.println("#" + tc + " " + ans);
        }//tc
    }//main
    
    //가로 탐색
//    private static boolean possibleRow(int row){
//        boolean[] slope = new boolean[N]; //경사로가 설치된 곳 체크
//        for(int c = 0; c < N - 1; c++){
//            if(map[row][c] == map[row][c + 1]) continue; //높이가 같음
//            if(Math.abs(map[row][c] - map[row][c + 1]) > 1) return false; //경사로 설치해도 비행 불가
//            if(map[row][c] - 1 == map[row][c + 1]){
//                for(int i = 1; i <= X; i++){
//
//                }
//            }
//        }
//    }//possibleRow

    //세로 탐색
    private static void rowSearch(int r, int c, int height){
        if(r == N - 1){
            System.out.println("세로 탐색 " + c);
            ans++;
            return;
        }

        int nr = r + 1;

        //다음 칸이 동일함
        if(map[nr][c] == map[r][c]){
            rowSearch(nr, c, height);
        }

        //다음 칸의 값이 다른 경우
        if(Math.abs(map[nr][c] - map[r][c]) > 1){ //높이 차이가 1보다 큰 경우에는 경사로를 놓아도 소용 없음
//            System.out.println("경사 문제" + nr + " " + c);
            return;
        }

        int length = 0;
        if(Math.abs(map[nr][c] - map[r][c]) == 1){ //경사로를 놓을 수 있는 경우
            for(int i = nr; i < N; i++){
                if(map[i][c] == map[nr][c]){
                    length++;
                }else{ //중간에 다른 숫자가 나오면 멈춤
//                    System.out.println("숫자 문제" + i + " " + c);
                    break;
                }
                if(length == X){ //활주로 건설 가능
//                    System.out.println("건설하자" + i + " " + c);
                    break;
                }
            }
        }
        //활주로 건설하는 경우
        if(length == X){
            System.out.println("이전 좌표 : " + r + " " + c);
            System.out.println("다음 좌표 : " + (r + X) + " " + c);
            rowSearch(r + X, c, map[r + X][c]);
        }

    }//rowSearch

    //가로 탐색
    private static void colSearch(int r, int c, int height){
        if(c == N - 1){
            System.out.println("가로 탐색 " + c);
            ans++;
            return;
        }

        int nc = c + 1;

        //다음 칸이 동일함
        if(map[r][nc] == map[r][c]){
            colSearch(r, nc, height);
        }

        //다음 칸의 값이 다른 경우
        if(Math.abs(map[r][nc] - map[r][c]) > 1){ //높이 차이가 1보다 큰 경우에는 경사로를 놓아도 소용 없음
//            System.out.println("경사 문제" + nr + " " + c);
            return;
        }

        int length = 0;
        if(Math.abs(map[r][nc] - map[r][c]) == 1){ //경사로를 놓을 수 있는 경우
            for(int i = nc; i < N; i++){
                if(map[r][i] == map[r][nc]){
                    length++;
                }else{ //중간에 다른 숫자가 나오면 멈춤
//                    System.out.println("숫자 문제" + i + " " + c);
                    break;
                }
                if(length == X){ //활주로 건설 가능
//                    System.out.println("건설하자" + i + " " + c);
                    break;
                }
            }
        }
        //활주로 건설하는 경우
        if(length == X){
//            System.out.println("이전 좌표 : " + r + " " + c);
//            System.out.println("다음 좌표 : " + (r + X) + " " + c);
            colSearch(r, c + X, map[r][c + X]);
        }

    }//colSearch
}
