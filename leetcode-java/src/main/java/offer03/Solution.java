package offer03;

import java.util.HashSet;
import java.util.Iterator;

class Solution {
    public int findRepeatNumber(int[] nums) {
        int repeat = -1;
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            if(!set.add(n)){
                repeat = n;
                break;
            }
        }

        return repeat;
    }

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(3);
        set.add(4);
        System.out.println(set.add(2));
        System.out.println(set.add(2));
        System.out.println(set.add(3));

    }
}
