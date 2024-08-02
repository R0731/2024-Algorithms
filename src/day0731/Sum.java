package day0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sum {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			int[][] table = new int[100][100];
			for(int r = 0; r < 100; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine()); // 공백기준으로 자르는 것
				
				while()
					table[r][c] = Integer.parseInt(st.nextToken());
				}
			System.out.println(Arrays.deepToString(table));
				
			}
		}
	}
}
