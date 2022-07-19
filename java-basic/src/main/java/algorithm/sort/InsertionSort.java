package algorithm.sort;

import algorithm.sort.sort0.MySort;
import algorithm.sort.sort0.SortUtils;

public class InsertionSort extends SortUtils implements MySort {
    @Override
    public void doSort(int[] list) {
        int i,j,tmp;
        for (i = 1; i < list.length; i++) {
            tmp = list[i];
            for (j = i -1; j >= 0; j--) {
                if(tmp < list[j]){
                    list[j + 1] = list[j];
                }else {
                    break;
                }
            }
            list[j + 1] = tmp;
        }
    }
}
