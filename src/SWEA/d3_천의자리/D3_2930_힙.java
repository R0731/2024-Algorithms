package SWEA.d3_천의자리;

import java.util.Scanner;

public class D3_2930_힙 {

    static int N;
    static int[] heap;
    static int heapSize;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            N = sc.nextInt();
            heap = new int[N + 1];
            heapSize = 0;

            StringBuilder ans = new StringBuilder();

            for(int i = 0; i < N; i++){
                int command = sc.nextInt();
                if(command == 1){
                    heapPush(sc.nextInt());
                }else{
                    ans.append(heapPop()).append(" ");
                }
            }

            System.out.println("#" + tc + " " + ans);

        }
    }

    static void swap(int i, int j){
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    static void heapPush(int data){
        heap[++heapSize] = data;

        int ch = heapSize;
        int p = ch / 2;

        while(ch != 1 && heap[ch] > heap[p]){
            swap(p, ch);

            ch = p;
            p = ch / 2;

        }
    }

    static int heapPop(){
        if (heapSize == 0)
            return -1;

        int popItem = heap[1];
        heap[1] = heap[heapSize--];

        int p = 1;
        int ch = p * 2;

        if(ch + 1 <= heapSize && heap[ch] < heap[ch + 1]){
            ch++;
        }

        while(ch <= heapSize && heap[p] < heap[ch]){

            swap(p, ch);

            p = ch;
            ch = p * 2;

            if(ch + 1 <= heapSize && heap[ch] < heap[ch + 1]){
                ch++;
            }

        }

        return popItem;
    }
}
