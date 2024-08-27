package SWEA.d2;

import java.util.Scanner;

public class D2_2001_파리퇴치 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test = 0; test < T; test++) {
			int N = sc.nextInt(); // 파리
			int M = sc.nextInt(); // 파리채
			
			int[][] fly = new int[N][N];
			int[][] flyCatch = new int[M][M];
			
			// 파리 배열 만들기
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					fly[r][c] = sc.nextInt();
				}
			}
			
			int max = 0;
			
			// 파리채 영역
			for(int r = 0; r <= N-M; r++) {
				for(int c = 0; c <= N-M; c++) {
					int sum = 0;
				for(int i = 0; i < M; i++) {
					for(int j = 0; j < M; j++) {
						sum += fly[r+i][c+j];

				}
				if(sum > max)
					max = sum;
				}
			}
			
		}
			System.out.println("#" + (test+1) + " " + max);
	}
}
}
	