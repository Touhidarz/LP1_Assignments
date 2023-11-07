import java.util.*;

public class lru {
    public static void main(String args[]) {
        int cap = 4;
        int arr[] = { 7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2 };
        int page_fault = 0;
        int hit = 0;
        int count = 0;
        ArrayList<Integer> arr2 = new ArrayList<>(cap);
        for (int i : arr) {
            if (!arr2.contains(i)) {
                if (arr2.size() == cap) {
                    arr2.remove(0);
                    arr2.add(cap - 1, i);

                } else {
                    arr2.add(count, i);
                }
                    page_fault++;
                    ++count;
                

            } else {
                arr2.remove((Object) i);

                arr2.add(arr2.size(), i);
                hit++;
            }
        }
        System.out.println("Hits : " + hit);
        System.out.println("Fault : " + page_fault);
    }
}