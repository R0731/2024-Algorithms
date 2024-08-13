package d3_천의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    String data;
    Node link;
}

class SinglyLinkedList{
    Node head;
    int size;

    SinglyLinkedList() {
        head = new Node();
    }

    void addData(int i, String data){
        if(0 > i || i > size){
            System.out.println("추가불가");
            return;
        }

        size++;

        Node newNode = new Node();
        newNode.data = data;

        Node curr = head;
        for(int k = 0; k < i; k++){
            curr = curr.link;
        }

        newNode.link = curr.link;
        curr.link = newNode;
    }

    void removeData(int i){
        if(0 > i || i >= size){
            System.out.println("삭제할 수 없는 범위입니다.");
            return;
        }

        size--;

        Node curr = head;

        for(int k = 0; k < i; k++){
            curr = curr.link;
        }

        curr.link = curr.link.link;
    }

    void printans(){
        Node curr = head.link;
        int cnt = 0;
        while(cnt < 10){
            System.out.print(curr.data + " ");
            curr = curr.link;
            cnt++;
        }
    }

}
public class D3_1228_암호문1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer str = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(br.readLine());

            StringTokenizer str2 = new StringTokenizer(br.readLine());

            SinglyLinkedList list = new SinglyLinkedList();

            while(str.hasMoreTokens()){
                list.addData(list.size, str.nextToken());
            }

            while(str2.hasMoreTokens()){
                String command = str2.nextToken();
                if(command.equals("I")) {
                    int x = Integer.parseInt(str2.nextToken());
                    int y = Integer.parseInt(str2.nextToken());

                    for(int i = 0; i < y; i++) {
                        if(str2.hasMoreTokens()) {
                            list.addData(x + i, str2.nextToken());
                        }
                    }
                }
            }

            System.out.print("#" + tc + " ");
            list.printans();
            System.out.println();
        }
    }
}
