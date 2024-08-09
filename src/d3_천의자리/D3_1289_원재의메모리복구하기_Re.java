package d3_천의자리;

import java.util.Arrays;
import java.util.Scanner;

public class D3_1289_원재의메모리복구하기_Re {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            String line = sc.next();

            char[] memory = line.toCharArray(); //메모리의 원래 값
            char[] newMemory = new char[memory.length]; //새로 덮어씌울 배열
            Arrays.fill(newMemory, '0');

            int count = 0;

            for(int i = 0; i < memory.length; i++){
                if(newMemory[i] != memory[i]){
                    for(int j = i; j < memory.length; j++){
                        newMemory[j] = memory[i];
                    }
                    count++;
                }
            }

            System.out.println("#" + tc + " " + count);
        }
    }
}
