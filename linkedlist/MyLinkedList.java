package linkedlist;

public class MyLinkedList {
    
    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            next = null;
        }
    }
    Node head;

    public void insertAtEnd(int data){

        //dynamically create a new node
        Node newNode = new Node(data);
        
        if(isEmpty()){
            head = newNode;
            return;
        }
        if(head.next==null){
            head.next = newNode;
            return;
        }

        Node ptr = head;
        while(ptr.next!=null){
            ptr = ptr.next;
        }
        ptr.next = newNode;
    }

    public void insertAtStart(int data){
        //dynamically create a new Node
        Node newNode = new Node(data);
        if(isEmpty()){
            head = newNode;
            return;
        }
        Node ptr = head;
        head = newNode;
        newNode.next = ptr;
    }

    public void insertAtAnyPos(int data,int key){

        //dynamically create a new Node
        Node newNode = new Node(data);
        if(head==null){
            return;
        }

        Node ptr = head;
        while(ptr.data!=key){
            ptr = ptr.next;
        }
         newNode.next = ptr.next;
         ptr.next = newNode;

    }

    public int deleteStart(){
        if(head==null){
            return -1;
        }
        int num = head.data;
        head = head.next;
        return num;
    }

    public int delete(){
        if(head==null){
            return -1;
        }
        if(head.next==null){
            return head.data;
        }
        int num = head.data;
        return num;
    }

    public int deleteEnd(){
        if(head==null||head.next==null){
            return head.data;
        }
        Node ptr = head;
        Node prev = null;
        while(ptr.next!=null){
            prev = ptr;
            ptr = ptr.next;
        }
        int num = ptr.data;
        prev.next = null;
        return num;
    }

    public int deleteAtAnyPos(int key){
        Node ptr = head;
        Node prev = null;
        while(ptr.data!=key){
            prev = ptr;
            ptr = ptr.next;
        }
        int num = ptr.data;
        prev.next = ptr.next;
        return num;
    }

    public void traverse(){
        Node ptr = head;
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr = ptr.next;
        }
    }

    public boolean isEmpty(){
        if(head==null){
            return true;
        }else{
            return false;
        }
    }
    
}
