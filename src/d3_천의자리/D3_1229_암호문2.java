package d3_천의자리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node2{
    String data;
    Node2 link;
}

class SinglyLinkedList2 {
    Node2 head;
    int size;

    SinglyLinkedList2(){
        head = new Node2();
    }

    void addData(int i, String data){
        size++;

        Node2 newNode = new Node2();
        newNode.data = data;

        Node2 curr = head;
        for(int k = 0; k < i; k++){
            curr = curr.link;
        }

        newNode.link = curr.link;
        curr.link = newNode;
    }

    void removeData(int i){
        size--;

        Node2 curr = head;

        for(int k = 0; k < i; k++){
            curr = curr.link;
        }

        curr.link = curr.link.link;

    }

    void printAns(){
        Node2 curr = head.link;

        int cnt = 0;
        while(cnt < 10){
            System.out.print(curr.data + " ");
            curr = curr.link;
            cnt++;
        }
    }


}

public class D3_1229_암호문2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc = 1; tc <= 10; tc++) {
            SinglyLinkedList2 list = new SinglyLinkedList2();

            int N = Integer.parseInt(br.readLine());

            StringTokenizer str = new StringTokenizer(br.readLine());

            while(str.hasMoreTokens()){
                list.addData(list.size, str.nextToken());
            }

            int M = Integer.parseInt(br.readLine());

            StringTokenizer str2 = new StringTokenizer(br.readLine());

            while(str2.hasMoreTokens()){
                String command = str2.nextToken();

                if(command.equals("I")){
                    int X = Integer.parseInt(str2.nextToken());
                    int Y = Integer.parseInt(str2.nextToken());
                    for(int i = 0; i < Y; i++){
                        list.addData(X+i, str2.nextToken());
                    }
                }else if(command.equals("D")){
                    int X = Integer.parseInt(str2.nextToken());
                    int Y = Integer.parseInt(str2.nextToken());
                    for(int i = Y - 1; i >= 0; i--){
                        list.removeData(X+i);
                    }
                }else if(command.equals("A")){
                    int Y = Integer.parseInt(str2.nextToken());
                    for(int i = 0; i < Y; i++){
                        list.addData(list.size, str2.nextToken());
                    }
                }
            }

            System.out.print("#" + tc + " ");
            list.printAns();
            System.out.println();
        }


    }
}
