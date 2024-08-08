package d3_천의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_8658_Summation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int[] nums = new int[10];

            StringTokenizer line = new StringTokenizer(br.readLine());

            for(int i = 0; i < nums.length; i++){
                nums[i] = Integer.parseInt(line.nextToken());
            }

            int max = 0;
            int min = nums[0];

            for(int i = 0; i < nums.length; i++) {
                int n = 1;
                int sum = 0;
                while(nums[i] > 0){
                    int a = nums[i] / (1000000 / n);
                    nums[i] %= (1000000 / n);
                    sum += a;
                    n *= 10;
                }
                if(sum > max)
                    max = sum;
                if(min > sum)
                    min = sum;
            }

            System.out.println("#" + tc + " " + max + " " + min);
        }
    }
}
