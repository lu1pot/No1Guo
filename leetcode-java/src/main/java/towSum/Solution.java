package towSum;

import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for(int i = 0;i < len;i++){
            if(map.containsKey(target - nums[i])) {
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
       return new int[0];
    }
}
