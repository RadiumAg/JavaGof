package com.company.算法第四版;

import edu.princeton.cs.algs4.Insertion;

import java.util.SortedMap;

public class 字符串 {


    public static void main(String[] args) {
        var test = new String[]{"1", "2", "3", "1"};
        LSD.sort(test, 1);
        //for (int i = 0; i <= test.length; i++) {
        //System.out.println(test[i]);
        //}
    }
}


/**
 * 低位优先的字符串排序
 */
class LSD {
    /**
     * 通过前W个字符将a[]排序
     *
     * @param a
     * @param w
     */
    public static void sort(String[] a, int w) {
        int N = a.length;
        int R = 256;

        String[] aux = new String[N];

        for (int d = w - 1; d >= 0; d--) {
            int[] count = new int[R + 1];
            // 计算出现频率
            for (int i = 0; i < N; i++)
                count[a[i].charAt(d) + 1]++;
            // 将频率转换为索引
            for (int r = 0; r < R; r++)
                count[r + 1] += count[r];
            // 将元素分类
            for (int i = 0; i < N; i++) {
                System.out.println(count[a[i].charAt(d)]);
                aux[count[a[i].charAt(d)]++] = a[i];
            }
            for (int i = 0; i < N; i++)
                a[i] = aux[i];
        }
    }
}

///**
// * 高位优先的字符串排序
// */
//class MSD {
//    private static int R = 256;       // 基数
//    private static final int M = 15;  // 小数组的切换阈值
//    private static String[] aux;      // 数据分类的辅助数组
//
//    private static int charAt(String s, int d) {
//        if (d < s.length()) return s.charAt(d);
//        else return -1;
//    }
//
//    public static void srot(String[] a) {
//        int N = a.length;
//        aux = new String[N];
//        sort(a, 0, N - 1, 0);
//    }
//
//}
//    private static void sort(String[] a, int lo, int hi, int d) {
//        if (hi <= lo + M) {
//            Insertion.sort(a, lo, hi, d);
//            return;
//        }
//        int[] count = new int[R + 2];
//        for (int i = lo; i <= hi; i++) {
//            count[charAt(a[i], d) + 2]++;
//        }
//
//        for (int r = 0; r < R + 1; r++)
//            count[r + 1] += count[r];
//
//        for (int i = lo; i <= hi; i++)
//            aux[count[charAt(a[i], d) + 1]++] = a[i];
//
//        for (int i = lo; i <= hi; i++)
//            a[i] = aux[i - lo];
//
//        for (int r = 0; r < R; r++)
//            sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);
//
//    }

//}