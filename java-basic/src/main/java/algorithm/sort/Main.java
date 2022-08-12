package algorithm.sort;

import algorithm.sort.sort0.MySort;

public class Main {
    public static void main(String[] args) {
//        int[] list = {7,3,23,6,21,34,65,78,12,34,56,42,13};
        int[] list = {5,3,7,2,9,8,1,4,6,10};
        MySort sortUtils = new SelectionSort();

        sortUtils.doSort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }
}
