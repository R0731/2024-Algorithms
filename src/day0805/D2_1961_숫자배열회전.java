package day0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D2_1961_숫자배열회전 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] nemo = new int[N][N];
			
			for(int r = 0; r < N; r++) {
				StringTokenizer line = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					nemo[r][c] = Integer.parseInt(line.nextToken());
				}
			}
			
			//90도
			int[][] nemo90 = new int[N][N];
			
			int i90 = 0;			
			for(int c = N-1; c >= 0; c--) {
				int j = 0;
				for(int r = 0; r < N; r++) {
					nemo90[r][c] = nemo[i90][j];
					j++;
				}
				i90++;
				}
			
			//180도
			int[][] nemo180 = new int[N][N];
			
			int i180 = 0;			
			for(int r = N-1; r >= 0; r--) {
				int j = 0;
				for(int c = N-1; c >= 0; c--) {
					nemo180[r][c] = nemo[i180][j];
					j++;
				}
				i180++;
				}
			
			
			//270도
			int[][] nemo270 = new int[N][N];
			
			int i270 = 0;			
			for(int c = 0; c < N; c++) {
				int j = 0;
				for(int r = N-1; r >= 0; r--) {
					nemo270[r][c] = nemo[i270][j];
					j++;
				}
				i270++;
				}
			
			System.out.println("#" + tc);
			//출력문
			for(int r = 0; r < N; r++) {
				for(int a = 0; a < N; a++) {
					System.out.print(nemo90[r][a]);
				}
				System.out.print(" ");
				for(int b = 0; b < N; b++) {
					System.out.print(nemo180[r][b]);
				}
				System.out.print(" ");
				for(int c = 0; c < N; c++) {
					System.out.print(nemo270[r][c]);
				}
				System.out.println();
			}
		}
	}
}
