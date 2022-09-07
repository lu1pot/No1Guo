package reverseWords;

public class Solution {
    public String reverseWords(String s) {
        s.split(" ");
        char[] str = s.toCharArray();
        for (int i = 0, j = 0; i < str.length; i++) {
            if(str[i] == ' '){
                reverseString(str,j,i -1);
                j = i + 1;
            }
            if(i == str.length -1 && j < i){
                reverseString(str,j,i);
            }
        }
        return String.valueOf(str);
    }
    public void reverseString(char[] s,int start,int end) {
        while(start <= end){
            char tmp = s[start];
            s[start++] = s[end];
            s[end--] = tmp;
        }
    }
}
