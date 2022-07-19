package algorithm.sort.sort0;

public abstract class SortUtils {
    protected void swap(int[] list, int x,int y){
        int tmp;
        tmp = list[x];
        list[x] = list[y];
        list[y] = tmp;
    }
}
