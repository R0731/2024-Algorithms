package SWEA.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D2_14510_나무높이 {
    static int N;
    static int[] tree;
    static int max, day, maxtree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            tree = new int[N];
            max = 0;
            day = 0;
            maxtree = 0;

            StringTokenizer line = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                tree[i] = Integer.parseInt(line.nextToken());
                if(tree[i] > max) max = tree[i];
            }

            for (int i = 0; i < N; i++){
                if(tree[i] == max) maxtree++;
            }

            int needWater = N - maxtree;

//            System.out.println(max);

            while(needWater > 0){
                day++;
                System.out.println(Arrays.toString(tree));
                if(day % 2 == 0) {
                    boolean use = false;
                    for (int i = 0; i < N; i++) {
                        if (tree[i] + 2 <= max && tree[i] % 2 == 0) {
                            tree[i] += 2;
                            use = true;
                            if(tree[i] == max) needWater--;
                            break;
                        }
                    }
                    if(!use){
                        for(int i = 0; i < N; i++) {
                            if(tree[i] % 2 != 0 && tree[i] + 3 <= max){
                                tree[i] += 2;
                                if(tree[i] == max) needWater--;
                                break;
                            }
                        }
                    }
                }else{//day가 홀수인 경우
                    boolean use = false;
                    for(int i = 0; i < N; i++){
                        if(tree[i] + 1 == max || (tree[i] % 2 != 0 && tree[i] + 1 <= max)){
                            tree[i] += 1;
                            use = true;
                            if(tree[i] == max) needWater--;
                            break;
                        }
                    }
                    if(!use){
                        int count = 0;
                        int idx = -1;
                        boolean noodd = true;
                        for(int i = 0; i < N; i++) {
                            if(tree[i] % 2 == 0 && tree[i] + 3 <= max){
                                tree[i] += 1;
                                if(tree[i] == max) needWater--;
                                noodd = false;
                                break;
                            }
                            if(tree[i] + 2 == max){
                                count++;
                                idx = i;
                            }
                        }
                        if(noodd && count >= 2) {
                            tree[idx] += 1;
                        }
                    }
                }

            }//while문

            System.out.println("#" + tc + " " + day);
        }
    }//main

}
