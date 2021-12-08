package com.company.算法第四版;

public class 字符串 {


    public static void main(String[] args) {
        var test = new String[]{"1", "2", "1"};
        LSD.sort(test, 1);
        for (int i = 0; i <= test.length; i++) {
            System.out.println(test[i]);
        }
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
            for (int i = 0; i < N; i++)
                aux[count[a[i].charAt(d)]++] = a[i];
            for (int i = 0; i < N; i++)
                a[i] = aux[i];
        }
    }
}