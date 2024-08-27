package SWEA.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class D4_1222_계산기1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			String expression = br.readLine();
			
			String ex2 = infixToPostfix(expression);
			
			int ans = evalPostfix(ex2);
			
			System.out.println("#" + tc + " " + ans);
		}
		
	}
	
	//후위계산식으로 바꾸는 메소드
	static Map<Character, Integer> m = new HashMap<>();
	
	static {
		m.put('+', 1);
		m.put('-', 1);
		m.put('*', 2);
		m.put('/', 2);
		
	}
	
	static String infixToPostfix(String str) {
		
		Stack<Character> s = new Stack<>();
		
		String postfix = "";
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(c <= '9' && c >= '0') {
				postfix += c;
			}else if(c == '(') {
				s.push(c);
			}else if(c == ')') {
				char popItem = s.pop();
				while(popItem != '(') {
					postfix += popItem;
					popItem = s.pop();
				}
			
			}else {
				while(!s.isEmpty() &&
						s.peek() != '(' &&
						m.get(s.peek()) >= m.get(c)) {
					char popItem = s.pop();
					postfix += popItem;
				}
				s.push(c);
			}
		}
		
		while(!s.isEmpty()) {
			postfix += s.pop();
		}
		
		return postfix;
		
	}
	
	//후위계산식 계산
	static int evalPostfix(String postfix) {
		
		Stack<Integer> s = new Stack<>();
		
		for(int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			
			if(c <= '9' && c >= '0') {
				s.push(c - '0');
			}else {
				int num1 = s.pop();
				int num2 = s.pop();
				int result;
				
				if(c == '+') {
					result = num2 + num1; 
				}else if(c == '-') {
					result = num2 + num1; 
				}else if(c == '*') {
					result = num2 * num1; 
				}else {
					result = num2 / num1; 
				}
				s.push(result);
			}
		}

		return s.pop();
	}

}
