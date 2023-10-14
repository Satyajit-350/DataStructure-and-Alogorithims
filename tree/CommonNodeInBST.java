package tree;

import java.io.*;
import java.util.*;

public class CommonNodeInBST {
    
    static Node buildTree(String str){
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root1 = buildTree(s);
            
            s = br.readLine();
            Node root2 = buildTree(s);
            
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = findCommon(root1,root2);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
            
            t--;
        }
    }

    public static ArrayList<Integer> findCommon(Node root1,Node root2){
        //code here 
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();
        inorder1(root1,set);
        inorder2(root2,set, ans);
        return ans;
    }
    public static void inorder1(Node root, Set<Integer>set){
        if(root==null){
            return;
        }
        inorder1(root.left, set);
        set.add(root.data);
        inorder1(root.right, set);
    }
    
    public static void inorder2(Node root, Set<Integer>set, ArrayList<Integer> ans){
        if(root==null){
            return;
        }
        inorder2(root.left, set, ans);
        if(set.contains(root.data)){
            ans.add(root.data);
        }
        inorder2(root.right, set, ans);
    }

}

class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
