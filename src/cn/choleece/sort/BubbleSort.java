package cn.choleece.sort;

/**
 * Java 排序
 * 排序分类，分为插入排序，选择排序，比较排序，归并排序，基数排序
 *
 * @author choleece
 * @date 2018/6/18
 */
public class BubbleSort {

    private static int[] sorts = { 49, 38, 65, 97, 176, 213, 227, 49, 78, 34, 12, 164, 11, 18, 1 };

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
        System.out.println("冒泡排序");
        int[] bubbleSort = bubbleSort(sorts);
        for (int i = 0; i < bubbleSort.length; i++) {
            System.out.println(bubbleSort[i]);
        }
    }
}
