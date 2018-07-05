package cn.choleece.sort;

/**
 * @author choleece
 * @description: cn.choleece.sort
 * @date 2018/6/28 10:04
 */
public class DirectSelectedSort {

    private static int[] sorts = { 49, 38, 65, 97, 176, 213, 227, 49, 78, 34, 12, 164, 11, 18, 1 };

    /**
     * 选择排序：思路，在每一次查找的过程中将最小的那个数放在待排序数的第一位，要点：找到最小的那个数, 时间复杂度为O(n2),最好最坏的情况都如此，都是要逐个比较
     * @param arr
     * @return
     */
    public static int[] directedSelectedSort(int[] arr) {
        if (arr == null) {
            return null;
        }
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int j, minIndex = i;
            for (j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println("选择排序: ");

        int[] dss = directedSelectedSort(sorts);
        for (int i = 0; i < dss.length; i++) {
            System.out.println(dss[i]);
        }
    }
}
