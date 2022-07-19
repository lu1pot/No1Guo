package algorithm.sort.sort0;

public abstract class MyQuickSort extends SortUtils implements MySort {
    protected int[] list;
    /**
     *
     * @param list 需要进行排序的数组
     */
    @Override
    public void doSort(int[] list) {
        this.list = list;
        quickSort(0,list.length-1);
    }


    /**
     * 递归方式实现快排过程
     * @param left  数组的左边界，初始值一般是0
     * @param right 数组右边界，初始值一般是 length - 1
     */
    protected void quickSort(int left,int right){
        if(left >= right) {
            return;
        }
        int pv_idx = partition(left,right);
        quickSort(left,pv_idx - 1);
        quickSort(pv_idx + 1,right);
    }

    /**
     * 根据分区方式不同实现方式也不同，比如Lomuto和Hoare
     * @param left 数组的左边界
     * @param right 数组右边界
     * @return 分好区的基准值索引
     */
    protected int partition(int left, int right) {
        return 0;
    }
}
