package offer10;

public class Solution {
    public int fib(int n) {
        final int MOD = 1000000007;
        int p = 0;
        int q = 1;
        int r = 0;
        if (n < 2) {
            return n;
        }
        for (int i = 2; i <= n; i++) {
            r = (p + q) % MOD;
            p = q;
            q = r;

        }
        return  r;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fib(7));
    }
}
