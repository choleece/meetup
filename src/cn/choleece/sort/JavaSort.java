package cn.choleece.sort;

/**
 * Java 排序
 * 排序分类，分为插入排序，选择排序，比较排序，归并排序，基数排序
 *
 * @author choleece
 * @date 2018/6/18
 */
public class JavaSort {

    private static int[] sorts = { 49, 38, 65, 97, 176, 213, 227, 49, 78, 34, 12, 164, 11, 18, 1 };

    /**
     * 插入排序的思想是每一步将待插入的项与前边已经排好序的部分进行比较，然后找到合适的位置进行插入，时间复杂度为O(O2),最坏的情况为倒序，最好的情况为正序
     */

    /**
     * 直接插入排序
     * @param sorts
     * @return
     */
    public static int[] directInsertSort(int[] sorts) {
        if (sorts == null) {
            return null;
        }
        for (int i = 0; i < sorts.length; i++) {
            int temp = sorts[i];
            int j;
            for (j = i - 1; j >= 0 ; j--) {
                if (temp < sorts[j]) {
                    sorts[j + 1] = sorts[j];
                } else {
                    break;
                }
            }
            sorts[j+1] = temp;
        }
        return sorts;
    }

    /**
     * 二分插入排序，与插入排序相比，减少比较的次数，通过二分法查找插入的位置，然后再移动插入的位置的后面的数
     * @param sorts
     * @return
     */
    public static int[] binaryInsertSort(int[] sorts) {
        if (sorts == null) {
            return null;
        }
        for (int i = 0; i < sorts.length; i++) {
            int temp = sorts[i];
            int left = 0, right = i - 1, mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                if (temp > sorts[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            for (int j = i - 1; j >= left; j--) {
                sorts[j + 1] = sorts[j];
            }
            if (left != i) {
                sorts[left] = temp;
            }
        }
        return sorts;
    }

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

    /**
     * 选择排序：思路，在每一次查找的过程中将最小的那个数放在待排序数的第一位，要点：找到最小的那个数, 时间复杂度为O(n2),最好最坏的情况都如此，都是要逐个比较
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

    /**
     * 每一轮找出当前轮最小或者最大的那个数,最坏的情况是倒叙，时间复杂度为O(n2)，最好的情况为顺序，时间复杂度为O(n)
     * @param arrs
     * @return
     */
    public static int[] bubbleSort(int[] arrs) {
        if (arrs == null) {
            return null;
        }
        for (int i = 0; i < arrs.length; i++) {
            int temp = arrs[i];
            for (int j = i + 1; j < arrs.length; j++) {
                if (arrs[j] <= temp) {
                    arrs[i] = arrs[j];
                    arrs[j] = temp;
                    temp = arrs[i];
                }
            }
        }
        return arrs;
    }

    public static void main(String[] args) {
        System.out.println("直接插入排序");
        int[] dis = directInsertSort(sorts);
        for (int i = 0; i < dis.length; i++) {
            System.out.print(dis[i] + " ");
        }
        System.out.println();

        System.out.println("二分插入排序");
        int[] bis = binaryInsertSort(sorts);
        for (int i = 0; i < bis.length; i++) {
            System.out.print(bis[i] + " ");
        }
        System.out.println();

        System.out.println("希尔排序");
        int[] ss = shellSort(sorts);
        for (int i = 0; i < sorts.length; i++) {
            System.out.println(ss[i]);
        }

        System.out.println("选择排序: ");

        int[] dss = directedSelectedSort(sorts);
        for (int i = 0; i < dss.length; i++) {
            System.out.println(dss[i]);
        }

        System.out.println("冒泡排序");
        int[] bubbleSort = shellSort(sorts);
        for (int i = 0; i < bubbleSort.length; i++) {
            System.out.println(bubbleSort[i]);
        }
    }
}
