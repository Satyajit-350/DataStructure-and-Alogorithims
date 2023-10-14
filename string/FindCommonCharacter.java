package string;

import java.util.*;

public class FindCommonCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String words[] = new String[n];
        for(int i=0; i<n; i++){
            words[i] = sc.next();
        }
        List<String> ans = commonChars(words);
        for(int i=0; i<ans.size(); i++){
            System.out.print(ans.get(i)+" ");
        }
    }
    public static List<String> commonChars(String[] words) {
        int ch1[] = new int[26];
        int ch2[] = new int[26];
        //first store thr fist word in ch
        for(int i=0; i<words[0].length(); i++){
            ch1[words[0].charAt(i)-'a']++;
        }
        //start from the first string
        for(int i=1; i<words.length; i++){
            for(char k=0; k<words[i].length(); k++){
                ch2[words[i].charAt(k)-'a']++;
            }
            for(int j=0; j<26; j++){
                ch1[j] = Math.min(ch1[j],ch2[j]);
                ch2[j] = 0;
            }
        }
        List<String> ans = new ArrayList<>();
        for(int i=0; i<26; i++){
            if(ch1[i]>0){
                int count = ch1[i];
                while(count-->0){
                    //get the character from the index
                    char ch = (char)(i+'a');
                    StringBuilder sb = new StringBuilder();
                    sb.append(ch);
                    ans.add(sb.toString());
                }

            }
        }
        return ans;
    }
}
