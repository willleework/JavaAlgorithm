package com.will.learn.algorithm;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.*;

/**
 * 排序算法
 *
 * @author liwei15515
 * @since 2018/12/5
 */
public class AlgoSort {

    //region 冒泡排序算法

    /**
     * 冒泡排序算法
     * 平均时间复杂度：O(n^2)
     * 最坏时间复杂度：O(n^2)
     * 最好时间复杂度：O(n)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     *
     * @param items
     * @param <T>
     */
    public static <T> void bubbleSort(@NotNull ArrayList<T> items, Comparator<T> comparator) {
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
     * 稳定性：不稳定
     *
     * @param items      待排序队列
     * @param comparator 比较器
     */
    public static <T> void quickSort(@NotNull ArrayList<T> items, Comparator<T> comparator) {
        internalQuickSort(items, 0, items.size() - 1, comparator);
    }

    /**
     * 快速排序函数
     *
     * @param items      待排序队列
     * @param low_index  起始索引
     * @param high_index 结束索引
     * @param comparator 比较器
     * @param <T>        数据类型
     */
    private static <T> void internalQuickSort(@NotNull ArrayList<T> items, int low_index, int high_index, Comparator<T> comparator) {
        if (low_index >= high_index) {
            return;
        }
        int md = swapSort(items, low_index, high_index, comparator);
        internalQuickSort(items, low_index, md - 1, comparator);
        internalQuickSort(items, md, high_index, comparator);
    }

    /**
     * 以前值为基准，交换低区和高区的值
     *
     * @param items      待排序数组
     * @param low_index  低位索引
     * @param high_index 高位索引
     */
    private static <T> int swapSort(@NotNull ArrayList<T> items, int low_index, int high_index, Comparator<T> comparator) {
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

    //region 归并排序算法

    /**
     * 归并算法
     *
     * @param items
     * @param comparator
     * @return
     */
    public static <T> ArrayList<T> mergeSort(@NotNull ArrayList<T> items, Comparator<T> comparator) {
        int len = items.size();
        if (len < 2) {
            return items;
        }

        int middle = (int) Math.floor(len / 2.0);
        ArrayList<T> left;
        ArrayList<T> right;
        if (middle < len) {
            left = new ArrayList<>(items.subList(0, middle));
        } else {
            left = new ArrayList<>();
        }
        if (middle + 1 < len) {
            right = new ArrayList<>(items.subList(middle + 1, len - 1));
        } else {
            right = new ArrayList<>();
        }

        return merge(mergeSort(left, comparator), mergeSort(right, comparator), comparator);
    }

    private static <T> ArrayList<T> merge(@NotNull ArrayList<T> left, ArrayList<T> right, Comparator<T> comparator) {
        ArrayList<T> temp = new ArrayList<T>();

        while (left.size() > 0 && right.size() > 0) {
            T lt = left.get(0);
            T rt = right.get(0);
            int cmp = comparator.compare(lt, rt);
            if (cmp < 0) {
                temp.add(lt);
                left.remove(0);
            } else {
                temp.add(rt);
                right.remove(0);
            }
        }

        while (left.size() > 0) {
            temp.add(left.get(0));
            left.remove(0);
        }

        while (right.size() > 0) {
            temp.add(right.get(0));
            right.remove(0);
        }
        return temp;
    }
    //endregion

    //region 辅助函数

    /**
     * 交换数组元素位置
     *
     * @param items
     * @param index1
     * @param index2
     */
    private static <T> void swapArrayListItem(@NotNull ArrayList<T> items, int index1, int index2) {
        T temp = items.get(index1);
        items.set(index1, items.get(index2));
        items.set(index2, temp);
    }
    //endregion
}
