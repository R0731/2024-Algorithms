package day0801;

import java.util.Scanner;

public class D3_1216_회문2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int test = 0; test < 10; test++) {
			int t  = sc.nextInt();
			
			// 100*100 배열 만들어서 입력받기
			char[][]nemo = new char[100][100];
			
			for(int r = 0; r < 100; r++) {
				String s = sc.next();
				for(int c = 0; c < 100; c++) {
					nemo[r][c] = s.charAt(c);
				}
			}
			
			int answer = 1;
			
			// 열에서 최대 회문 찾기
			for(int r = 0; r < 100; r++) {
				int c = 0;
				while(c <= 100-answer) {
					for(int d = 100 - c; answer < d; d--) {
						boolean palindrome = true;
						for(int half = 0; half < d / 2; half++){
							if(!(nemo[r][half+c] == (nemo[r][c+d-1-half]))) {
							palindrome = false;
							break;
							}
						}
						if(palindrome) {
							answer = Math.max(answer, d);
						}
					}
					c++;
				}
			}
				
			
			// 행에서 최대 회문 찾기
			for(int c = 0; c < 100; c++) {
				int r = 0;
				while(r <= 100-answer) {
					for(int d = 100 - r; answer < d; d--) {
						boolean palindrome = true;
						for(int half = 0; half < d / 2; half++){
							if(!(nemo[r+half][c] == (nemo[r+d-1-half][c]))) {
							palindrome = false;
							break;
							}
						}
						if(palindrome) {
							answer = Math.max(answer, d);
						}
					}
					r++;
				}
			}
			
			
			System.out.println("#" + t + " " + answer);
			
			
			
		}
			
			
	}
}
