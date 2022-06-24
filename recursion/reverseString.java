package recursion;

public class reverseString {
    public static void main(String[] args) {
        String name = "satyajit";
        int i = 0;
        int j = name.length()-1;
        String s = reverse(name,i,j);
        System.out.println(s);
    }

    

    private static String reverse(String str, int i, int j) {
        if(i>j){
            return str;
        }
        // System.out.println(str);
        String newStr = swap(str,i,j);
        i++;
        j--;
        return reverse(newStr,i,j);
    }
    

    private static String swap(String str, int i, int j) {
        char ch[] = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        String s = new String(ch);
        return s;
    }
    
}
