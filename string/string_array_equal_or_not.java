package string;

import java.util.*;

public class string_array_equal_or_not {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        String w1[] = new String[n1];
        String w2[] = new String[n2];
        for(int i=0; i<n1; i++){
            w1[i] = sc.next();
        }
        for(int i=0; i<n2; i++){
            w2[i] = sc.next();
        }
        System.out.println("Answer is: " + arrayStringsAreEqual(w1, w2));
    }
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(String str: word1){
            sb1.append(str);
        }
        for(String str: word2){
            sb2.append(str);
        }
        return sb1.toString().equals(sb2.toString());
    }
}
