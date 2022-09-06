package rotate_arr;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        Solution solution = new Solution();
        solution.rotate(nums,3);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
