package algorithm.sort;

import algorithm.sort.sort0.MyQuickSort;

public class QuickSortHuole extends MyQuickSort {
    @Override
    protected int partition(int left,int right){
        int pv = list[left];
        int begin,end;
        begin = left;
        end = right;
        while (begin < end){
            while (begin < end && list[end] >= pv){
                end--;
            }
            while (begin < end && list[begin] <= pv){
                begin++;
            }
            swap(list,begin,end);
        }
        swap(list,left,end);
        return end;
    }
}
