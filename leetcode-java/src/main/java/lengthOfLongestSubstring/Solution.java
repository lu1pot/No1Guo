package lengthOfLongestSubstring;

import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int len = s.length();
        int start = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < len; end++) {
            char c = s.charAt(end);

            if(map.containsKey(c)){
                start = Math.max(map.get(c) + 1,start);
            }
            map.put(c,end);
            max = Math.max(end - start +1,max);
        }
        return max;
    }
}
