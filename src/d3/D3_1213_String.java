package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class D3_1213_String {
	public static void main(String[] args) throws NumberFormatException, IOException {
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <= 1; tc++){
			
			int T = Integer.parseInt(br.readLine());
			
			String line2 = br.readLine();
			
			char[] findVoca = line2.toCharArray();
			
			
//			for(int i = 0; i < findVoca.length(); i++) {
//				findVoca[i] = ;
//			}
			
			String line = br.readLine();
			
		
			char[] word = line.toCharArray();
			
			
			System.out.println(Arrays.toString(findVoca));
			System.out.println(Arrays.toString(word));
			
				
			
			
			
		}
		
	}
}