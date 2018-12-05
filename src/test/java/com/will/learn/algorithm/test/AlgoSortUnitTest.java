package com.will.learn.algorithm.test;

import com.will.learn.algorithm.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

/**
 * 排序算法测试类
 */
public class AlgoSortUnitTest {

    ArrayList<SortItem> items = new ArrayList<>();
    Comparator<SortItem> comparator ;

    /**
     * 初始化数组
     */
    @Before
    public void init(){
        items.add(new SortItem(5, "测试5"));
        items.add(new SortItem(9, "测试9"));
        items.add(new SortItem(3, "测试3"));
        items.add(new SortItem(2, "测试2"));
        comparator = (t1, t2) -> {
            int id1 = t1.getId();
            int id2 = t2.getId();
            if (id1 > id2) {
                return 1;
            } else if (id1 == id2) {
                return 0;
            } else {
                return -1;
            }
        };
    }

    /**
     * 冒泡排序测试
     */
    @Test
    public void bubbleSortTest(){
        AlgoSort.bubbleSort(items, comparator);
        Print(items);
    }

    /**
     * 快速排序测试
     */
    @Test
    public void quickSortTest() {
        AlgoSort.quickSort(items, comparator);
        Print(items);
    }

    /**
     * 归并算法测试
     */
    @Test
    public void mergeSortTest(){
        ArrayList<SortItem> rslt = AlgoSort.mergeSort(items, comparator);
        Print(rslt);
    }

    /**
     * 输出函数
     */
    private void Print(ArrayList<SortItem> items)
    {
        for (SortItem item : items) {
            System.out.println(item.getName());
        }
    }
}
