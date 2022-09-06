package sfrm.searchi35;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        int count = 0;
        while (l <= h){
            int m = (l + h) >>> 1;
            if(target == nums[m]) {
                return m;
            }
            if(target > nums[m]){
                l = m + 1;
            }else {
                h = m - 1;
            }

        }

        return l;
    }
}
