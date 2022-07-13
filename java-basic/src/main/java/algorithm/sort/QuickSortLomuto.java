package algorithm.sort;

public class QuickSortLomuto implements MySort{

    private int[] list;
    @Override
    public void doSort(int[] list) {
        this.list = list;
        quickSort(0,list.length-1);
    }

    private void quickSort(int left,int right){
        if(left >= right) {
            return;
        }
        int pv_idx = partition(left,right);
        quickSort(left,pv_idx - 1);
        quickSort(pv_idx + 1,right);
        return;
    }

    private int partition(int left,int right){
        int pv = list[right];
        int i,j;
        for(i = j = left; i < right; i++){
            if(list[i] < pv) {
                SortUtils.swap(list,i,j);
                j++;
            }
        }
        SortUtils.swap(list,j,right);
        System.out.printf("%d : %d \n",j,list[j]);
        return j;
    }
}
