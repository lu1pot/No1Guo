package algorithm.sort;


import algorithm.sort.sort0.MySort;
import algorithm.sort.sort0.SortUtils;

public class SelectionSort extends SortUtils implements MySort {

    @Override
    public void doSort(int[] list){
        int min;
        for (int i = 0; i < list.length; i++) {
            min = i;
            for (int j = i + 1; j < list.length; j++) {
                if(list[j] < list[min]){
                    min = j;
                }
            }
           swap(list,min,i);
        }

    }

}
