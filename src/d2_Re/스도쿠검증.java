package d2_Re;

import java.util.Scanner;

public class 스도쿠검증 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int N = 9;
            int[][] sedoku = new int[N][N];

            for(int r = 0; r < N; r++){
                for(int c = 0; c < N; c++) {
                    sedoku[r][c] = sc.nextInt();
                }
            }

            boolean right = true;

            //가로 검증
            for(int r = 0; r < N; r++){
                int[] count = new int[N + 1];
                for(int c = 0; c < N; c++){
                    count[sedoku[r][c]]++;
                    if(count[sedoku[r][c]] > 1){
                        right = false;
                        break;
                    }
                }
            }

            //세로 검증
            if(right){
                for(int c = 0; c < N; c++){
                    int[] count = new int[N + 1];
                    for(int r = 0; r < N; r++){
                        count[sedoku[r][c]]++;
                        if(count[sedoku[r][c]] > 1){
                            right = false;
                            break;
                        }
                    }
                }
            }

            //네모 검증
            if(right){
                for(int r = 0; r < N - 2; r+=3){
                    for(int c = 0; c < N - 2; c+=3){
                        int[] count = new int[N + 1];
                        for(int a = r; a < r + 3; a++){
                            for(int b = c; b < c + 3; b++){
                                count[sedoku[a][b]]++;
                                if(count[sedoku[a][b]] > 1){
                                    right = false;
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            System.out.println("#" + tc + " " + (right? 1 : 0));
        }
    }
}
