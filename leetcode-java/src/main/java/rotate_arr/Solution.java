package rotate_arr;

public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        for(int i = 0;i < k; i++){
            int last = nums[len-1];
            for(int j = len - 2; j >= 0;j--){
                nums[j+1] = nums[j];
            }
            nums[0] = last;
        }
    }

    public void rotate0(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
