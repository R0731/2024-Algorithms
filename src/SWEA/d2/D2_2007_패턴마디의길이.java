package SWEA.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D2_2007_패턴마디의길이 {
	public static void main(String[] args) throws RuntimeException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			
			String line = br.readLine();
			
			char[] voca = line.toCharArray();
			
			System.out.println("#" + tc + " " + Arrays.toString(voca));
			
			
			
			
			
		}
		
		
	}
}
