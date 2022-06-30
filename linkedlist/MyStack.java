package linkedlist;

public class MyStack {

    MyLinkedList ll = new MyLinkedList();

    public void push(int data){
        ll.insertAtStart(data);
    }

    public int pop(){
        int num = ll.deleteStart();
        if(num==-1){
            System.out.println("UnderFlow");
            return -1;
        }
        return num;
    }

    public void peek(){
        int num = ll.delete();
        if(num==-1){
            System.out.println("Cannot peek element stack is empty.");
            return;
        }
        System.out.println(num);
    }

    public void traverse(){
        ll.traverse();
    }
    
}
