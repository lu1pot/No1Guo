package sfrm.bisearch704;

public class BiSearch {
    public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        int res_idx = -1;
        while (l <= h){
            int mid = (l + h) >>> 1;
            if(nums[mid] == target){
                res_idx = mid;
                break;
            }
            if(nums[mid] > target) h = mid -1;
            else l = mid + 1;
        }
        return res_idx;
    }
}
