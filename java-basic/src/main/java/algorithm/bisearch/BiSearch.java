package algorithm.bisearch;

public class BiSearch {
    public static int search(int[] list,int target){
        int left,right,mid;
        left = 0;
        right = list.length;
        while (true){
            mid = (left+right) >>> 1;
            if(target > list[mid]){
                left = mid + 1;
            }
            if(target < list[mid]){
                right = mid - 1;
            }
            if(left > right){
                break;
            }
            if(target == list[mid]){
                return mid;
            }
        }

        return -1;
    }
}
