package com.company.算法第四版;

import edu.princeton.cs.algs4.Insertion;

import java.util.Comparator;

public class 字符串 {


    public static void main(String[] args) {
        var test = new String[]{"1", "2", "3", "1"};
        LSD.sort(test, 1);
        //for (int i = 0; i <= test.length; i++) {
        //System.out.println(test[i]);
        //}
    }
}


class TrieSt<Value> {
    private static int R = 256;

    private Node root;

    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
        private  int cnt = 0;

        public  inst size(){
            return  size(root);
        }

        private  int size(Node x) {
            if(x == null) return 0;
            if(x.val != null)  cnt++;
            for (char c = 0; c < R; c++)
                cnt += size(next[c]);
            return cnt;
        }
    }


    public Value get(String key) {
        var x = get(root, key, 0);
        if (x == null) return null;
        return (Value) x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);
        return x;
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

/**
 * 高位优先的字符串排序
 */
class MSD {
    private static int R = 256;       // 基数
    private static final int M = 15;  // 小数组的切换阈值
    private static String[] aux;      // 数据分类的辅助数组

    private static int charAt(String s, int d) {
        if (d < s.length()) return s.charAt(d);
        else return -1;
    }

    public static void srot(String[] a) {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N - 1, 0);
    }


    private static void sort(String[] a, int lo, int hi, int d) {
        if (hi <= lo + M) {
            Insertion.sort(a, lo, hi, new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    return d;
                }
            });
            return;
        }
        int[] count = new int[R + 2];
        for (int i = lo; i <= hi; i++) {
            count[charAt(a[i], d) + 2]++;
        }

        for (int r = 0; r < R + 1; r++)
            count[r + 1] += count[r];

        for (int i = lo; i <= hi; i++)
            aux[count[charAt(a[i], d) + 1]++] = a[i];

        for (int i = lo; i <= hi; i++)
            a[i] = aux[i - lo];

        for (int r = 0; r < R; r++)
            sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);
    }
}


class Quick3string {
    private static int charAt(String s, int d) {
        if (d < s.length()) return s.charAt(d);
        else return -1;
    }

    public static void sort(String[] a) {
        sort(a, 0, a.length - 1, 0);
    }

    private static void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        int v = charAt(a[lo], d);
        int i = lo + 1;
        while (i <= gt) {
            int t = charAt(a[i], d);
            if (t < v) exch(a, lt++, i++);
            else if (t > v) exch(a, i, gt--);
            else i++;
        }
    }
}
