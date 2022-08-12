package algorithm.bisearch;

public class Main {
    public static void main(String[] args){
        int[] list = {1,3,5,6};

        int idx = BiSearch.search(list, 5);

        System.out.println(idx);
    }

}
