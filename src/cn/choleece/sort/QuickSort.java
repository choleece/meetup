package cn.choleece.sort;

/**
 * 快速排序，采用分治法的思想，每次找一个基准，每轮排序将数值分成该基准值的左右
 * @author choleece
 * @description: cn.choleece.sort
 * @date 2018/6/28 10:43
 */
public class QuickSort {
    private static int[] sorts = { 49, 38, 65, 97, 176, 213, 227, 49, 78, 34, 12, 164, 11, 18, 1, 49 };

    /**
     * 先找一个基准数，然后从两端遍历，将数按照基准数分成两部分
     * @param arr
     * @param head
     * @param tail
     */
    public static void quickSort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length == 1) {
            return;
        }
        int i = head, j = tail, pivot = arr[(head + tail) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                ++i;
            }
            while (arr[j] > pivot) {
                --j;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
            quickSort(arr, head, j);
            quickSort(arr, i, tail);
        }
    }

    public static void main(String[] args) {
        quickSort(sorts, 0, sorts.length - 1);
        for (int i = 0; i < sorts.length; i++) {
            System.out.println(sorts[i]);
        }
    }
}
