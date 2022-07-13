package algorithm.sort;

public class SortUtils {
    public static void swap(int[] list, int x,int y){
        int tmp;
        tmp = list[x];
        list[x] = list[y];
        list[y] = tmp;
    }
}
