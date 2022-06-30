package linkedlist;

public class stackSampleLL {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.pop();
        stack.peek();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        stack.peek();

        stack.traverse();

        System.out.println();

        System.out.println(stack.pop()); //1

        System.out.println(stack.pop());//2

        System.out.println(stack.pop());//3

        System.out.println(stack.pop());//4

        System.out.println(stack.pop());//5

        stack.peek();
        stack.pop();

        System.out.println();

        stack.traverse();
    }
    
}
