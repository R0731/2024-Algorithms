package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1979_어디에단어가들어갈수있을까 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			StringTokenizer line = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(line.nextToken());
			int K = Integer.parseInt(line.nextToken());
			
			int[][] nemo = new int[N][N];
			
			//배열채우기
			for(int r = 0; r < N; r++) {
				StringTokenizer line2 = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					nemo[r][c] = Integer.parseInt(line2.nextToken());
				}
			}
			
			int sum = 0;
			
			//가로 검사
			for(int r = 0; r < N; r++) {
				for(int c = 0; c <= N-K; c++) {
					boolean ans = true;
					for(int n = 0; n < K; n++) {
						if(nemo[r][c+n] != 1) {
							ans = false;
							break;
						}
					}
					if(ans == true) {
						if((c+K >= N || nemo[r][c+K] == 0) && (c == 0 || nemo[r][c-1] == 0)) {
							sum++;
						}
					}
				}
			}
			
			//세로 검사
			for(int c = 0; c < N; c++) {
				for(int r = 0; r <= N-K; r++) {
					boolean ans = true;
					for(int n = 0; n < K; n++) {
						if(nemo[r+n][c] != 1) {
							ans = false;
							break;
						}
					}
					if(ans == true) {
						if((r+K >= N || nemo[r+K][c] == 0) && (r == 0 || nemo[r-1][c] == 0)) {
							sum++;
						}
					}
				}
			}
			
			
			System.out.println("#" + tc + " " + sum);
		}
	}
}
