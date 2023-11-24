package tree;

import java.util.*;



public class symmetric_tree {

    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }

    public static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Node root = buildTree(str);

        System.out.println("Answer is: " + isSymmetric(root));
    }

    public static boolean isSymmetric(Node root){
        // add your code here; 
        if(root==null){
            return true;
        }
        return solve(root.left, root.right);
    }
    public static boolean solve(Node r1,Node r2){
        if(r1==null&&r2==null){
            return true;
        }
        if(r1==null||r2==null){
            return false;
        }
        if(r1.data!=r2.data){
            return false;
        }
        boolean left = solve(r1.left,r2.right);
        boolean right = solve(r2.left,r1.right);
        if(left&&right){
            return true;
        }else{
            return false;
        }
    } 
}


