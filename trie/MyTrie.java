package trie;

public class MyTrie {
    

    static class TrieNode{
        char data;
        TrieNode children[] = new TrieNode[26];
        boolean isTerminal;

        TrieNode(char data){
            this.data = data;
            for(int i=0; i<26; i++){
                children[i] = null;
            }
            isTerminal = false;
        }

    }

    TrieNode root = new TrieNode('\0');

    //insertion
    void insert(String word){
        insertUtils(root,word);
    }
    void insertUtils(TrieNode root, String word){
        //base case
        if(word.length()==0){
            root.isTerminal = true;
            return;
        }
        int index = word.charAt(0) - 'A';
        TrieNode child;

        //present
        if(root.children[index]!=null){
            child = root.children[index];
        }else{
            //absent
            child = new TrieNode(word.charAt(0));
            root.children[index] = child;
        }

        //recursion
        insertUtils(child, word.substring(1));
    }

    //searching
    boolean search(String word){
        return searchUtils(root,word);
    }

    boolean searchUtils(TrieNode root, String word){
        //base case
        if(word.length()==0){
            return root.isTerminal;
        }
        int index = word.charAt(0) - 'A';
        TrieNode child;
        //present
        if(root.children[index]!=null){
            child = root.children[index];
        }else{
            //absent
            return false;
        }

        //recursion
        return searchUtils(child, word.substring(1));
    }

    //remove
    void remove(String word){
        removeUtils(root,word);
    }
    void removeUtils(TrieNode root,String word){
        //base condtion
        if(word.length()==0){
            root.isTerminal = false;
            return;
        }
        int index = word.charAt(0) - 'A';
        TrieNode child;
        //present
        if(root.children[index]!=null){
            child = root.children[index];
        }else{
            return;
        }
        //recursion
        removeUtils(child, word.substring(1));
    }

    public static void main(String[] args) {

        MyTrie node = new MyTrie();
        node.insert("ARM");
        node.insert("DOG");
        node.insert("TIMER");


        System.out.println(node.search("ARM"));
        System.out.println(node.search("DOG"));

        //needs more optimization in space because the String "DOG" is still present in the Trie
        node.remove("DOG");

        System.out.println(node.search("DOG"));


        /**
         * Time Complexity
         * Insertion:  O(l)    l = lenght of the String word
         * Deletion: O(l)
         * Searching: O(l)
         */
        
    }

}
