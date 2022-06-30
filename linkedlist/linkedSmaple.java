package linkedlist;

public class linkedSmaple {

    public static void main(String[] args) {
        
        MyLinkedList ll = new MyLinkedList();

        int c = ll.deleteStart();

        System.out.println(c);

        ll.insertAtEnd(5);
        ll.insertAtEnd(4);
        ll.insertAtEnd(7);
        ll.insertAtEnd(1);

        // ll.traverse();

        ll.insertAtEnd(2);

        ll.insertAtStart(10);
        ll.insertAtStart(1);

        ll.insertAtAnyPos(12, 10);

        ll.traverse();

        System.out.println();

        int x = ll.deleteStart();
        System.out.println(x);

        ll.traverse();

        System.out.println();

        int y = ll.deleteEnd();
        System.out.println(y);

        ll.traverse();

        System.out.println();

        int z = ll.deleteAtAnyPos(5);
        System.out.println(z);

        ll.traverse();

    }
    
}
