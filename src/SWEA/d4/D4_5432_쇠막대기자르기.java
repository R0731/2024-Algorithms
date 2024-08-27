package SWEA.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class D4_5432_쇠막대기자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String line = br.readLine();
			
			//원본배열
			char[] arr = line.toCharArray();
			
			Stack<Character> pip = new Stack<>();
			
			//쇠막대 개수
			int pipe = 0;
			
			for(int p = 0; p < arr.length; p++) {
				if(arr[p] == '(') {
				pipe++;
				}
			}
			
			for(int q = 1; q < arr.length; q++) {
				if(arr[q-1] == '(' && arr[q] == ')') {
					pipe--;
				}
			}
			
			//몇 번 잘랐을까
			int count = pipe;
			
			pip.push(arr[0]);
			
			for(int i = 1; i < arr.length; i++) {				
				if(arr[i-1] == '(' && arr[i] == ')') {
					pip.pop();
					count += pip.size();
				}else if(arr[i] == '(') {
					pip.push('(');
				}else if(arr[i] == ')'){
					pip.pop();	
				}
			
			}
			
			System.out.println("#" + tc + " " + count);
		}
	}
}

