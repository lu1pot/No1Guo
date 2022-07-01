package dwd;

public class Solution {
    public int divide(int dividend, int divisor) {
        boolean sign = (((dividend >>> 31) ^ (divisor >>> 31)) == 1);
        if(dividend > 0){
            dividend = -dividend;
        }
        if(divisor > 0) {
            divisor = -divisor;
        }
        int mod = divisor;
        int minn = dividend >> 1;
        int now = -1;
        while(mod >= minn) { // while(mod >= minn && mod >= (Integer.MIN_VALUE >> 1)) {
            mod <<= 1;
            now <<= 1;
        }
        int ans = 0;
        while(dividend <= divisor){
            while(mod < dividend){
                mod >>= 1;
                now >>= 1;
            }
            while(dividend <= mod) {
                dividend -= mod;
                ans-=now;
            }
        }
        if(ans == Integer.MIN_VALUE && !sign) {
            return 2147483647;
        }
        return sign?-ans:ans;
    }
}
