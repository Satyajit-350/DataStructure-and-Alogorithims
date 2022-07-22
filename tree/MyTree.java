package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MyTree {

    static class Node{
        int data;
        Node left;
        Node right;

        Node (int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

    } 

    public static Node buildTree(Node root){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the data: ");
        int data = sc.nextInt();
        root = new Node(data);
        //base case 
        if(data==-1){
            return null;
        }
        System.out.println("Enter data for inserting in left node of "+data);
        root.left = buildTree(root.left);

        System.out.println("Enter data for inserting in right node of "+data);
        root.right = buildTree(root.right);

        return root;
    }

    static void levelOrderTraversal(Node root){
        if (root == null){
            System.out.println("root is null");
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.print(temp.data+" ");
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }
    }

    static void inorder(Node root){
        //base case
        if(root==null){
            return;
        }
        //LNR
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    static void preorder(Node root){
        //base case
        if(root==null){
            return;
        }
        //NLR
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    static void postorder(Node root){
        //base case
        if(root==null){
            return;
        }

        //LRN
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }

    public static void main(String[] args) {
        
        Node root = null;
        
        Node x = buildTree(root);

        //1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1

        System.out.println("LevelOrderTraversal: ");
        levelOrderTraversal(x);
        System.out.println();

        System.out.println("Inorder traversal: ");
        inorder(x);
        System.out.println();

        System.out.println("PreOrder traversal: ");
        preorder(x);
        System.out.println();

        System.out.println("PostOrder traversal: ");
        postorder(x);
        System.out.println();
    }
}
