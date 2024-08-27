package SWEA.d2;

import java.util.Scanner;

public class D2_12712_파리퇴치3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int number = 0; number < T; number++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] fly = new int[N][N];
			
			// 파리 배열 만들기
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					fly[r][c] = sc.nextInt();
				}
			}
			
			int max1 = 0;
			int max2 = 0;
			
			// 십자가 모양 합 구하기
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					int sum = fly[r][c];
					for(int i = 1; i < M; i++) {
						if(r-i >= 0)
							sum += fly[r-i][c]; 
						if(r+i < N)
							sum += fly[r+i][c];
						if(c-i >= 0)
							sum += fly[r][c-i];
						if(c+i < N)
							sum += fly[r][c+i];
					}
					
					if(sum > max1) {
						max1 = sum;
					}
						
				}
			}
			
			
			// 대각선 모양 합 구하기
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					int sum = fly[r][c];
					for(int i = 1; i < M; i++) {
						if(r-i >= 0 && c-i >= 0)
							sum += fly[r-i][c-i]; 
						if(r+i < N && c-i >= 0)
							sum += fly[r+i][c-i];
						if(r+i < N && c+i < N)
							sum += fly[r+i][c+i];
						if(r-i >= 0 && c+i < N)
							sum += fly[r-i][c+i];
					}
					if(sum > max2)
						max2 = sum;
				}
				}
			
			int max = 0;
			if(max1 > max2) {
				max = max1;
			} else {
				max = max2;
			}
			
			System.out.println("#" + (number+1) + " " + max);
			
		}
			
			
		
	}	
}
