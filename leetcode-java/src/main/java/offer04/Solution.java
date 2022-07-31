package offer04;

class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {
            int col_len = matrix[i].length;
            int[] col = matrix[i];
            for (int j = 0; j < col_len ; j++) {

                if(target > col[col_len - 1 ]){
                    break;
                }
                if(target == col[col_len - 1]){
                    return true;
                }
                if(biSearch(col,target)){
                    return true;
                }
            }
        }
        return false;
    }


    private boolean biSearch(int[] col,int target){
        int left,right,mid;
        left = 0;
        right = col.length;
        while (true){
            mid = (left+right) >>> 1;
            if(target > col[mid]){
                left = mid + 1;
            }
            if(target < col[mid]){
                right = mid - 1;
            }
            if(left > right){
                break;
            }
            if(target == col[mid]){
                return true;
            }
        }
        return false;
    }
}