package offer05;

class Solution {
    public String replaceSpace(String s) {
        int len = s.length();
        int size = 0;
        char[] chars = new char[len * 3];
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(c == ' '){
                chars[size++] = '%';
                chars[size++] = '2';
                chars[size++] = '0';
            }else {
                chars[size++] = c;
            }
        }
        String new_s = new String(chars, 0, size);
        return new_s;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().replaceSpace("I was happy."));
    }
}
