package offer04;

public class TestMain {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] nums = {{-1,3}};

        boolean res = solution.findNumberIn2DArray(nums, 1);
        System.out.println(res);
    }
}
