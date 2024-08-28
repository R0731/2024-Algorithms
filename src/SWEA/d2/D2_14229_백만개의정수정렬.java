package SWEA.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_14229_백만개의정수정렬 {
    static int N = 1000000;
    static int[] A = new int[N];
    static int[] tmp = new int[N];

    public static void main(String[] args) throws IOException {
        //정수 백만 개 중 50만번째 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer line = new StringTokenizer(br.readLine());

        int idx = 0;

        while(line.hasMoreTokens()){
            A[idx++] = Integer.parseInt(line.nextToken());
        }

//        mergeSort(0, N - 1);
        quickSort(0, N - 1);

        System.out.println(A[500000]);

    }

    private static void mergeSort(int left, int right){
        if(left < right){
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    private static void merge(int left, int mid, int right){
        int L = left;
        int R = mid + 1;

        int idx = left;

        while(L <= mid && R <= right){
            if(A[L] <= A[R]){
                tmp[idx] = A[L];
                idx++;
                L++;
            }else{
                tmp[idx] = A[R];
                idx++;
                R++;
            }
        }

        if(L <= mid){
            for(int i = L; i <= mid; i++){
                tmp[idx++] = A[i];
            }
        }else{
            for(int i = R; i <= right; i++){
                tmp[idx++] = A[i];
            }
        }

        for(int i = left; i <= right; i++){
            A[i] = tmp[i];
        }
    }

    private static void quickSort(int left, int right) {
        if (left < right) {
            int pivot = partition(left, right);
            quickSort(left, pivot - 1);
            quickSort(pivot + 1, right);
        }

    }

    private static int partition(int left, int right) {
        int pivot = A[left];

        int L = left + 1, R = right;

        while(L <= R){
            while(L <= R && A[L] <= pivot) L++;
            while(A[R] > pivot) R--;

            if(L < R){
                int tmp = A[L];
                A[L] = A[R];
                A[R] = tmp;
            }
        }

        int tmp = A[left];
        A[left] = A[R];
        A[R] = tmp;

        return R;
    }

}
