package queue;

public class CircularQueue {
    
    int max = 5;
    int arr[] = new int[max];
    int front;
    int rear;

    CircularQueue(int front,int rear){
        this.front = front;
        this.rear = rear;
    }

    void enQueue(int data){
        if(front==(rear+1)%max){
            System.out.println("Queue is full.");
            return;
        }else if(front==-1){
            rear = 0;
            front = 0;
        }else{
            rear = (rear+1)%max;
        }
        arr[rear] = data;
        
    }

    int deQueue(){
        int num;
        if(rear==-1){
            System.out.println("Queue is empty.");
            return -1;
        }else{
            num = arr[front];
            if(front==rear){
                front = -1;
                rear = -1;
            }else{
                front =(front+1)%max;
            }
        }
        return num;
    }

    void traverse(){
        if(front<=rear){
            for(int i=front; i<=rear; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }else{
            for(int i=front; i<max; i++){
                System.out.print(arr[i]+" ");
            }
            for(int i=0; i<=rear; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(-1, -1);
        q.deQueue();
        q.enQueue(5);
        q.enQueue(8);
        q.enQueue(9);
        q.enQueue(10);
        q.enQueue(1);
        q.traverse();
        q.enQueue(4);

        System.out.println(q.deQueue());
        q.traverse();
        
        q.enQueue(6);
        q.traverse();
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
    }
}
