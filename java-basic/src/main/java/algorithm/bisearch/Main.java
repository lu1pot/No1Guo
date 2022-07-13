package algorithm.bisearch;

public class Main {
    public static void main(String[] args) {
        int[] list = {1,3,5,8,9,14,17,22,28,31,37,50,54,66};

        int idx = BiSearch.search(list, 66);

        System.out.println(idx);
        System.out.println(list[idx]);
    }
}
