package cn.choleece.sort;

/**
 * @author choleece
 * @description: cn.choleece.sort.insert
 * @date 2018/6/28 10:00
 */
public class ShellSort {
    private static int[] sorts = { 49, 38, 65, 97, 176, 213, 227, 49, 78, 34, 12, 164, 11, 18, 1 };

    /**
     * 希尔排序，思路是先将原数组进行分组，在组内执行直接插入排序，然后逐步缩小分组数，直至组数为1，再执行直接插入排序
     * @param arr
     * @return
     */
    public static int[] shellSort(int[] arr) {
        if (arr == null) {
            return null;
        }
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int j = gap; j < arr.length; j += gap) {
                int temp = arr[j];
                int k;
                for (k = j - gap; k >= 0 && temp < arr[k]; k -= gap) {
                    arr[k + gap] = arr[k];
                }
                arr[k + gap] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println("希尔排序");
        int[] ss = shellSort(sorts);
        for (int i = 0; i < sorts.length; i++) {
            System.out.println(ss[i]);
        }
    }
}
