package algorithm.sort.sort0;

public abstract class MyQuickSort extends SortUtils implements MySort {
    protected int[] list;
    @Override
    public void doSort(int[] list) {
        this.list = list;
        quickSort(0,list.length-1);
    }
    protected void quickSort(int left,int right){
        if(left >= right) {
            return;
        }
        int pv_idx = partition(left,right);
        quickSort(left,pv_idx - 1);
        quickSort(pv_idx + 1,right);
    }
    protected int partition(int left, int right) {
        return 0;
    }
}
