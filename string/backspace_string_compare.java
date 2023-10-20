package string;

import java.util.*;

public class backspace_string_compare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println("Answer is: "+ backspaceCompare(s, t));
    }

    public static boolean backspaceCompare(String s, String t) {
        //very easy using stack
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        //traverse and put all the characters inside the stack
        for(char ch: s.toCharArray()){
            if(ch == '#'){
                if(!s1.isEmpty()){
                    s1.pop();
                    continue;
                }
            }else{
                s1.push(ch);
            }
        }
        for(char ch: t.toCharArray()){
            if(ch == '#'){
                if(!s2.isEmpty()){
                    s2.pop();
                    continue;
                }
            }else{
                s2.push(ch);
            }
        }
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while(!s1.isEmpty()){
            sb1.append(s1.pop());
        }

        while(!s2.isEmpty()){
            sb2.append(s2.pop());
        }

        return sb1.toString().equals(sb2.toString());
    }
}
