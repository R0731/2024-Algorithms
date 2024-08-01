package day0801;

import java.util.Scanner;

public class D3_1216_회문2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int test = 0; test < 10; test++) {
			int t  = sc.nextInt();
			
			// 100*100 배열 만들어서 입력받기
			char[][]nemo1 = new char[100][100];
			
			for(int r = 0; r < 100; r++) {
				String s = sc.next();
				for(int c = 0; c < 100; c++) {
					nemo1[r][c] = s.charAt(c);
				}
			}
			
			int max_len = 0;
			
			// 열에서 최대 회문 찾기
			for(int r = 0; r < 100; r++) {
				start : for(int start = 0; start < 100 - max_len; start++) {
					int end = 99;
					while(start + max_len <= end) {
						boolean flag = checkPal(nemo[r], start, end);
					}
					for(int end = 99; end >= start; end--) {
						if(nemo1[r][start] != nemo1[r][end]) {
							break;
						} else {
							int len = end - start+1;
							if(len > max) {
								max = len;
							}
							break;
						}
					}
				}
			}
			
			
			// 행에서 최대 회문 찾기
			for(int c = 0; c < 100; c++) {
				for(int start = 0; start < 100; start++) {
					for(int end = 99; end >= start; end--) {
						if(nemo1[start][c] != nemo1[end][c]) {
							break;
						} else {
							int len = end - start+1;
							if(len > max) {
								max = len;
							}
							break;
						}
					}
				}
			}
			
			
			System.out.println("#" + t + " " + max);
			
			
			
		}
			
			
	}
}
