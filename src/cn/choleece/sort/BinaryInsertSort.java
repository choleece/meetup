package cn.choleece.sort;

/**
 * @author choleece
 * @description: cn.choleece.sort.insert
 * @date 2018/6/28 9:59
 */
public class BinaryInsertSort {
    private static int[] sorts = { 49, 38, 65, 97, 176, 213, 227, 49, 78, 34, 12, 164, 11, 18, 1 };

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

    public static void main(String[] args) {
        System.out.println("二分插入排序");
        int[] bis = binaryInsertSort(sorts);
        for (int i = 0; i < bis.length; i++) {
            System.out.print(bis[i] + " ");
        }
    }
}
