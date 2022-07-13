package algorithm.sort;


public class SelectionSort implements MySort{

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
            SortUtils.swap(list,min,i);
        }

    }

}
