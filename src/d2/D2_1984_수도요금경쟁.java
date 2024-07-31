package d2;

import java.util.Scanner;

public class D2_1984_수도요금경쟁 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
				
		for(int loop = 0; loop < t; loop++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			int r = sc.nextInt();
			int s = sc.nextInt();
			int w = sc.nextInt();
			
			int answer = 0;
			
			if(w-r > 0) {
				if(w*p <= q+((w-r)*s)) {
					answer = w*p;
				} else {
					answer = q+((w-r)*s);
				}
			} else if(w-r <= 0) {
				if(w*p <= q) {
					answer = w*p;
				} else {
					answer = q;
				}
			}
			System.out.println("#" + (loop+1) + " " + answer);
	}
}
}
