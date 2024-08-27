package SWEA.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class D2_1974_스도쿠검증 {
	public static void main(String[] args) throws RuntimeException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			// 입력받기
			int[][] puzzle = new int[9][9]; 
			
			
			// 퍼즐 만들기
			for(int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 9; j++) {
					puzzle[i][j] = Integer.parseInt(st.nextToken());				
				}
			}
			
			boolean isValid = true;
			
			// 가로 찾기
			for(int i = 0; i < puzzle.length; i++) {
				Set<Integer> nums = new HashSet<>();
				for(int j = 0; j < puzzle.length; j++) {
					nums.add(puzzle[i][j]);
					}
				if(nums.size() != 9) {
					isValid = false;
					break;
				}
			}
						
			// 세로 찾기
			if(isValid) {
				for(int j = 0; j < puzzle.length; j++) {
					Set<Integer> nums = new HashSet<>();
					for(int i = 0; i < puzzle.length; i++) {
						nums.add(puzzle[i][j]);
						}
					if(nums.size() != 9) {
						isValid = false;
						break;
					}
				}
			}
			
			// 사각형 찾기
			if(isValid) {
				for(int r = 0; r < puzzle.length; r+=3) {
					for(int c = 0; c < puzzle.length; c+=3) {
						Set<Integer> nums = new HashSet<>();
						for(int i = 0; i < 3; i++) {
							for(int j = 0; j < 3; j++) {
								nums.add(puzzle[i+r][j+c]);
							}
						}
						if(nums.size() != 9) {
							isValid = false;
							break;
						}
					}
					 if(!isValid) break;
				}
			}				
			
			// 답안 출력
			int answer = isValid ? 1 : 0;
			
			System.out.println("#" + tc + " " + answer);
			
		}
	}
}
