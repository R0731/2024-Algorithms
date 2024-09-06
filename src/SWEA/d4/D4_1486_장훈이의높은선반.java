package SWEA.d4;

import java.util.Scanner;

public class D4_1486_장훈이의높은선반 {
    static int N, B; //N : 직원의 수 B : 만들어야 하는 높이
    static int[] nums; //직원의 키가 저장되는 배열
    static boolean[] visited;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            N = sc.nextInt();
            B = sc.nextInt();
            nums = new int[N];
            visited = new boolean[N];
            ans = B;
            for(int i = 0; i < N; i++){
                nums[i] = sc.nextInt();
            }
            //-------초기화 완료--------

            comb(0, 0);

            System.out.println("#" + tc + " " + ans);

        }//tc
    }//main

    //idx : 사용할 nums의 인덱스
    //currentSum : 현재 사용한 수를 더한 값
    private static void comb(int idx, int currentSum){
        //만약 현재값이 필요한 값을 넘어가면 즉시 판단
        if(currentSum >= B){
            int a = currentSum - B;
            ans = Math.min(ans, a);
            return; //차이가 가장 적은 값이 필요하므로 여기서 더 더할 필요 없음
        }
        if(idx >= N) return; //만약 idx가 배열의 범위를 넘어가는 순간 return

        //사용한 경우
        visited[idx] = true;
        comb(idx + 1, currentSum + nums[idx]);

        //사용하지 않은 경우
        visited[idx] = false;
        comb(idx + 1, currentSum);

    }
}
