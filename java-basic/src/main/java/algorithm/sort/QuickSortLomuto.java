package algorithm.sort;

import algorithm.sort.sort0.MyQuickSort;
/**
 * 采用Lomuto分区
 */
public class QuickSortLomuto extends MyQuickSort {
    @Override
    protected int partition(int left,int right){
        int pv = list[right];
        int i,j;
        for(i = j = left; i < right; i++){
            if(list[i] < pv) {
                swap(list,i,j);
                j++;
            }
        }
        swap(list,j,right);
        System.out.printf("%d : %d \n",j,list[j]);
        return j;
    }
}
