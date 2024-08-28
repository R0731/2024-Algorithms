package SWEA.d3_천의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class D3_4088_숫자만들기 {
    static int N;
    static String[] operators;
    static int[] nums;
    static String[] ans;
    static boolean[] visited;
    static int max, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){

            N = Integer.parseInt(br.readLine());

            operators = new String[N - 1];
            ans = new String[N - 1];
            nums = new int[N];
            visited = new boolean[N - 1];

            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            StringTokenizer line = new StringTokenizer(br.readLine());

            Map<Integer, String> map = new HashMap<>();

            map.put(0, "+");
            map.put(1, "-");
            map.put(2, "*");
            map.put(3, "/");

            int opnum = 0;

            for(int i = 0; i < 4; i++){
                int a = Integer.parseInt(line.nextToken());
                while(a > 0){
                    operators[opnum++] = map.get(i);
                    a--;
                }
            }

            StringTokenizer line2 = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++){
                nums[i] = Integer.parseInt(line2.nextToken());
            }

            permuteOp(0);

            System.out.println("#" + tc + " " + (max - min));
        }

    }

    private static void permuteOp(int sidx){
        if(sidx == N - 1){
            sum(ans, nums);
            return;
        }

        String before = "";

        for(int i = 0; i < N - 1; i++){
            if(!visited[i] && !before.equals(operators[i])){
                visited[i] = true;
                ans[sidx] = operators[i];
                permuteOp(sidx + 1);
                visited[i] = false;
                before = operators[i];
            }
        }
    }

    private static void sum(String[] ans, int[] nums){
        int sum = nums[0];

        for(int i = 0; i < N - 1; i++){
            switch (ans[i]) {
                case "+" :
                    sum += nums[i + 1];
                    break;
                case "-" :
                    sum -= nums[i + 1];
                    break;
                case "*" :
                    sum *= nums[i + 1];
                    break;
                default :
                    sum /= nums[i + 1];
            }
        }

        if(sum < min) min = sum;
        if(sum > max) max = sum;
    }
}

//return이 무슨 차이를 일으킨 걸까...결과를 다 출력한 후에도 계속 뒤에서 돌아가는건가....?
