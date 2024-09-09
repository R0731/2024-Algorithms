package SWEA.모의역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 모의_2477_차량정비소 {
    static class Customer implements Comparable <Customer> {
        int idx, arrive, a, b;

        public Customer(int arrive){
            this.arrive = arrive;
        }

        @Override
        public int compareTo(Customer o) {
            return this.arrive - o.arrive;
        }
    }
    static int N, M, K, A, B; //접수 창구 개수, 정비 창구 개수, 총 고객 수, 찾을 접수창구, 찾을 고객창구
    static int[][] infoA, infoB; //접수창구, 고객창구
    static Customer[] processingA, processingB; //일하는 중
    static PriorityQueue<Customer> waitingQueue;
    static Queue<Customer> queueA;
    static Queue<Customer> queueB;
    static int completed;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer line = new StringTokenizer(br.readLine());
            N = Integer.parseInt(line.nextToken());
            M = Integer.parseInt(line.nextToken());
            K = Integer.parseInt(line.nextToken());
            A = Integer.parseInt(line.nextToken());
            B = Integer.parseInt(line.nextToken());
            infoA = new int[N + 1][2];
            infoB = new int[M + 1][2];
            processingA = new Customer[N + 1];
            processingB = new Customer[M + 1];
            completed = 0;
            ans = 0;
            line = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++){
                infoA[i][0] = Integer.parseInt(line.nextToken());
            }

            line = new StringTokenizer(br.readLine());
            for(int i = 1; i <= M; i++){
                infoB[i][0] = Integer.parseInt(line.nextToken());
            }

            waitingQueue = new PriorityQueue<>();
            queueA = new LinkedList<>();
            queueB = new LinkedList<>();
            line = new StringTokenizer(br.readLine());
            for(int i = 0; i < K; i++){
                int temp = Integer.parseInt(line.nextToken());
                waitingQueue.add(new Customer(temp));
            }
//            ----------------초기화 완료---------------------

            simulate();

            if(ans == 0) ans = -1;

            System.out.println("#" + tc + " " + ans);
        }//tc
    }//main

    private static void simulate() {
        int time = 0;
        int num = 1;
        while (completed < K) {
//       1.고객 도착 > 접수 대기열에 추가
            while(!waitingQueue.isEmpty() && waitingQueue.peek().arrive == time){
                Customer curr = waitingQueue.poll();
                curr.idx = num++;
                queueA.add(curr);
            }
//       2. 접수 창구 > 정비 창구
            moveCustomer(infoA, queueA, queueB, processingA,"a");
//       3. 정비 창구 > 완료
            moveCustomer(infoB, queueB, null, processingB, "b");

            time++;
        }//while
    }//simulate

    private static void moveCustomer(int[][] arr, Queue<Customer> queue, Queue<Customer> nextqueue, Customer[] process, String type){
        for(int i = 1; i <= arr.length - 1; i++){
            //창구에서 처리 중인 경우
            if(arr[i][1] > 0) {
                arr[i][1]--;
                //처리 중이던 업무가 완료된 경우
                if(arr[i][1] == 0){
                    Customer curr = process[i];
                    process[i] = null;
                    if(type.equals("a")){
                        curr.a = i;
                        nextqueue.add(curr);
                    }else{
                        curr.b = i;
                        completed++;
                        check(curr);
                    }
                }
            }
            //창구가 비어 있는 경우
            if(process[i] == null && !queue.isEmpty()){
                Customer curr = queue.poll();
                arr[i][1] = arr[i][0];
                process[i] = curr;
            }
        }

    }

    private static void check(Customer customers){
        if(customers.a == A && customers.b == B){
            ans += customers.idx;
        }
    }
}
