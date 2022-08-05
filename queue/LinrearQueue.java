package queue;

import java.util.Scanner;

public class LinrearQueue {

    int max = 10;
    int arr[] = new int[max];
    int front;
    int rear;

    LinrearQueue(int front,int rear){
        this.front = front;
        this.rear = rear;
    }

    void enQueue(int data){
        if(rear==max-1){
            System.out.println("Queue is Full.");
            return;
        }
        rear = rear+1; 
        arr[rear] = data;
    }
    int deQueue(){
        if(front==0&&rear==-1){
            System.out.println("Queue is Empty.");
            return -1;
        }
        int num = arr[front];
        front++;
        return num;
    }

    void traverse(){
        for(int i=front; i<=rear; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinrearQueue q = new LinrearQueue(0, -1);
        q.deQueue();
        q.enQueue(5);
        q.enQueue(6);
        q.enQueue(7);
        q.enQueue(9);
        q.enQueue(1);
        q.enQueue(4);
        q.traverse();

        System.out.println(q.deQueue());
        q.traverse();

        System.out.println(q.deQueue());
        q.traverse();

        q.enQueue(10);
        q.enQueue(10);
        q.enQueue(10);
        q.enQueue(10);
        q.enQueue(10);
        q.enQueue(10);
        q.enQueue(10);
    
        q.traverse();
    }
}
