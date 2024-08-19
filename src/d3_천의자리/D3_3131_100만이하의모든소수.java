package d3_천의자리;

import java.util.ArrayList;
import java.util.List;

public class D3_3131_100만이하의모든소수 {
    public static void main(String[] args) {
        int N = 1000000;
        int[]nums = new int[N + 1];

        StringBuilder sb = new StringBuilder();

        for(int i = 2; i <= N; i++){
            nums[i] = i;
        }

        for(int i = 2; i * i <= N; i++){
            if(nums[i] == 0){
                continue;
            }
            for(int j = i + i; j <= N; j += i){
                nums[j] = 0;
            }
        }

        for(int n : nums){
            if(n != 0) {
                System.out.print(n + " ");
            }
        }
    }
}
