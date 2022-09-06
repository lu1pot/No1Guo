package sfrm.searchi35;

public class TestMain {
    public static void main(String[] args) {
        int arr[] = {-1,0,3,5,9,12};
        SearchInsert searchInsert = new SearchInsert();
        int i = searchInsert.searchInsert(arr, 13);
        System.out.println(i);

    }
}
