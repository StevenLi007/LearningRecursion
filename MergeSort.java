public class MergeSort {
    public static void mergeSort(int[] data, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(data, start, mid);
            mergeSort(data, mid + 1, end);
            merge(data, start, mid, end);
        }
    }

    public static void merge(int[] data, int start, int mid, int end) {
        // build temp array to avoid modifying the original array
        int[] temp = new int[end - start + 1];

        int i = start;
        int j = mid + 1;
        int k = 0;

        // while both arrays have values
        while (i <= mid && j <= end) {
            if (data[i] <= data[j]) {
                temp[k++] = data[i++];
            } else {
                temp[k++] = data[j++];
            }
        }
        // add remaining values from left subarray
        while (i <= mid) {
            temp[k++] = data[i++];
        }
        // add remaining values from right subarray
        while (j <= end) {
            temp[k++] = data[j++];
        }

        for (int n = start; n <= end; n++) {
            data[n] = temp[n - start];
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{-5, 20, 10, 3, 2, 0};
        mergeSort(data, 0, data.length - 1);
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }
}

/**
 * intuition for merge sort:
 * 1. divide the array into the elements
 * 2. compare the pairs
 * 3. merge the sorted pairs back into the original array
 *    using a pointer for each array
 * 
 * my current thoughts:
 * - I understand the logic of the algorithm, but not the implementation details
 *   (e.g. I know that we need to recursively call the algorithm to split the 
 *    array, but how exactly do we implement the recursive divide and merge logic?)
 * - I recall from CSE12 that merge sort required a helper method to assist in merging
 *   (I think?), but I'm not sure how that comes into play.
 */