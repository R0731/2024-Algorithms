package day0731;

import java.util.Arrays;
import java.util.Scanner;

public class D2_1954_달팽이숫자 {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test = 1; test <= T; test++) {
			
			// 달팽이 틀 만들기
			int N = sc.nextInt();
			int[][] snail = new int[N][N];
			
			int r = 0;
			int c = 0;
			int cnt = 0;
			int d = 0; // 우하좌상 이동용 변수
	
			// 우 하 좌 상
			int[] dr = {0, 1, 0, -1};
			int[] dc = {1, 0, -1, 0};
			
			while(cnt++ < N*N) {
				snail[r][c] = cnt;
				
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				// 오른쪽으로 이동하며 채우기
				if(nr >= N || nr < 0 || nc >= N || nc < 0 || snail[nr][nc] != 0) {
					d = (d+1) % 4;
					nr = r + dr[d];
					nc = c + dc[d];
					}
				r = nr;
				c = nc;
				}
		
				System.out.println("#" + test);
				for(r = 0; r < N; r++) {
					for(c = 0; c < N; c++) {
						System.out.print(snail[r][c] + " ");						
					}
					System.out.println();
				}
				
			}
			
			
		}
	}
