package d3_천의자리;

import java.util.Scanner;

public class D3_1209_Sum {
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	
	for(int test = 1; test <= 10; test++) {
		int t = sc.nextInt();
		
		int[][] nemo = new int[100][100];
		
		// 배열에 숫자 입력
		for(int r = 0; r < 100; r++) {
			for(int c = 0; c < 100; c++) {
				nemo[r][c] = sc.nextInt();
			}
		}
		
		// 각 열의 합
		int[] max = new int[4];
		
		int[] rmax = new int[100];

		for(int r = 0; r < 100; r++) {
			for(int c = 0; c < 100; c++) {
				rmax[r] += nemo[r][c]; 
			}
		}
		
		for(int i = 0; i < rmax.length; i++) {
			if(rmax[i] > max[0])
				max[0] = rmax[i];
		}
		
		// 각 행의 합
		int[] cmax = new int[100];
		
		for(int c = 0; c < 100; c++) {
			for(int r = 0; r < 100; r++) {
				cmax[c] += nemo[r][c]; 
			}
		}
		
		for(int i = 0; i < cmax.length; i++) {
			if(cmax[i] > max[1])
				max[1] = cmax[i];
		}
		
		// 대각선1의 합
		for(int i = 0; i < 100; i++) {
			max[2] += nemo[i][i]; 
		}
		
		// 대각선2의 합
		for(int i = 0; i < 100; i++) {
			max[3] += nemo[i][99-i];
		}
		
		int ans = max[0];
		
		for(int i = 0; i < max.length; i++) {
			if(max[i] > ans) {
				ans = max[i];
			}
		}
		
		System.out.println("#" + t + " " + ans);
		
	}
}
}