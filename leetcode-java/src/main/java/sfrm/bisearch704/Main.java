package sfrm.bisearch704;

public class Main {
    public static void main(String[] args) {
        int arr[] = {-1,0,3,5,9,12};
        BiSearch biSearch = new BiSearch();
        int search = biSearch.search(arr, 9);
        System.out.println(search);
    }
}
