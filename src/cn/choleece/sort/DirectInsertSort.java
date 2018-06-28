package cn.choleece.sort;

/**
 * @author choleece
 * @description: 直接插入排序, 插入排序的思想是每一步将待插入的项与前边已经排好序的部分进行比较，然后找到合适的位置进行插入，时间复杂度为O(O2),最坏的情况为倒序，最好的情况为正序
 * @date 2018/6/28 9:57
 */
public class DirectInsertSort {

    private static int[] sorts = { 49, 38, 65, 97, 176, 213, 227, 49, 78, 34, 12, 164, 11, 18, 1 };

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

    public static void main(String[] args) {
        System.out.println("直接插入排序");
        int[] dis = directInsertSort(sorts);
        for (int i = 0; i < dis.length; i++) {
            System.out.print(dis[i] + " ");
        }
    }

}
