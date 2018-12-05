package com.will.learn.algorithm;

import java.util.ArrayList;
import java.util.*;

/**
 * 排序算法
 * @author liwei15515
 * @since 2018/12/5
 */
public class AlgoSort {

    //region 冒泡排序算法

    /**
     * 冒泡排序算法
     * @param items
     * @param <T>
     */
    public static <T> void bubbleSort(ArrayList<T> items, Comparator<T> comparator) {
        int length = items.size();
        for (int j = 0; j < length; j++) {
            for (int k = 0; k < length - j - 1; k++) {
                int cmp = comparator.compare(items.get(k), items.get(k + 1));
                if (cmp > 0) {
                    swapArrayListItem(items, k, k + 1);
                }
            }
        }
    }
    //endregion

    //region 快速排序算法
    /**
     * 快速排序算法
     * 平均时间复杂度：O(nlog2n)
     * 最坏时间复杂度：O(n^2)
     * 最好时间复杂度：O(nlog2n)
     * 空间复杂度：O(nlog2n)
     * @param items
     * @param low_index
     * @param high_index
     */
    public static <T> void quickSort(ArrayList<T> items, int low_index, int high_index, Comparator<T> comparator) {
        if (low_index >= high_index) {
            return;
        }
        int md = swapSort(items, low_index, high_index, comparator);
        quickSort(items, low_index, md-1, comparator);
        quickSort(items, md, high_index, comparator);
    }

    /**
     * 以前值为基准，交换低区和高区的值
     *
     * @param items      待排序数组
     * @param low_index  低位索引
     * @param high_index 高位索引
     */
    private static <T> int swapSort(ArrayList<T> items, int low_index, int high_index, Comparator<T> comparator) {
        if (low_index >= high_index) {
            return 0;
        }
        T cmp = items.get(low_index);
        while (low_index != high_index) {
            while (high_index > low_index && comparator.compare(items.get(high_index), cmp) > 0) {
                high_index--;
            }
            if (high_index > low_index) {
                items.set(low_index, items.get(high_index));
                low_index++;
            } else {
                break;
            }
            while (low_index < high_index && comparator.compare(items.get(low_index), cmp) < 0) {
                low_index++;
            }
            if (low_index < high_index) {
                items.set(high_index, items.get(low_index));
                high_index--;
            } else {
                break;
            }
        }
        items.set(low_index++, cmp);
        return low_index;
    }
    //endregion

    //region 辅助函数
    /**
     * 交换数组元素位置
     * @param items
     * @param index1
     * @param index2
     */
    private static <T> void swapArrayListItem(ArrayList<T> items, int index1, int index2){
        T temp = items.get(index1);
        items.set(index1, items.get(index2));
        items.set(index2, temp);
    }
    //endregion
}
