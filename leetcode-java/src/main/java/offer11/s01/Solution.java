package offer11.s01;

public class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int pv = (left + right) >>> 1;
            if(nums[pv] > nums[right]){
                left = pv + 1;
            }else {
                right = pv;
            }
        }
        return nums[left];
    }
}
