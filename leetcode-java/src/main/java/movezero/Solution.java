package movezero;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println("..");
    }
    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        int index = 0; //通过index维护非0元素
        for(int i = 0; i < len ; i++){
            if(nums[i] != 0){
                nums[index] = nums[i];
                index ++;
            }
        }

        for(int i = index;i<len;i++){
            nums[i] = 0;
        }
    }
}
