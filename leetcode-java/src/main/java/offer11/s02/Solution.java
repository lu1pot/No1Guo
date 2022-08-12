package offer11.s02;

public class Solution {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right){
            int pv = (left + right) >>> 1;
            if(numbers[pv] > numbers[right]){
                left = pv + 1;
            }else if(numbers[pv] < numbers[right]) {
                right = pv;
            } else {
                right --;
            }
        }

        return numbers[left];
    }
}
