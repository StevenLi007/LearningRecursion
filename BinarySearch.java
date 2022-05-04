import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch {
    public int binarySearch(int target, int lowIdx, int highIdx, ArrayList<Integer> arr) {
        // base case
        if (lowIdx > highIdx) {
            return -1;
        }

        // divide and conquer
        int midpt = (lowIdx + highIdx) / 2;

        if (arr.get(midpt) == target) {
            return midpt;
        }

        if (arr.get(midpt) > target) {
            return binarySearch(target, lowIdx, midpt - 1, arr);
        }

        return binarySearch(target, midpt + 1, highIdx, arr);
    }

    public static void main(String[] args) {
        BinarySearch obj = new BinarySearch();
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(obj.binarySearch(1, 0, 4, nums));
    }
}
