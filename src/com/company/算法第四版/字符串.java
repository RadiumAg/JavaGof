package com.company.算法第四版;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdOut;

import java.sql.Array;
import java.util.Comparator;


class IndexOrder {
    private static class Student {
        private int _key;
        private String _name;

        public Student(Integer key, String name) {
            this._key = key;
            this._name = name;
        }

        public int key() {
            return this._key;
        }

        public String name() {
            return this._name;
        }

    }


    public static Student[] sort(Student[] a, int R) {
        var count = new int[R + 1];
        var aux = new Student[a.length];

        // 统计每个键出现的频率
        for (var i = 0; i < a.length; i++) {
            count[a[i].key() + 1]++;
        }

        // 转换成索引，占坑
        for (var r = 0; r < R; r++) {
            count[r + 1] += count[r];
        }

        // 根据坑位填入aux
        for (var i = 0; i < a.length; i++) {
            aux[count[a[i].key()]++] = a[i];
        }

        // 修改原数组为排序后的顺序
        for (var i = 0; i < a.length; i++) {
            a[i] = aux[i];
        }

        return a;
    }

    public static void main(String[] args) {
        var student = new Student[20];
        var R = 5;
        student[0] = new Student(2, "Anderson");
        student[1] = new Student(3, "Brown");
        student[2] = new Student(3, "Davis");
        student[3] = new Student(4, "Davis");
        student[4] = new Student(1, "Harris");
        student[5] = new Student(3, "Jackson");
        student[6] = new Student(4, "Johnson");
        student[7] = new Student(3, "Jones");
        student[8] = new Student(1, "Martin");
        student[9] = new Student(2, "Martinez");
        student[10] = new Student(2, "Miller");
        student[11] = new Student(1, "Moore");
        student[12] = new Student(2, "Robinson");
        student[13] = new Student(4, "Smith");
        student[14] = new Student(3, "Taylor");
        student[15] = new Student(4, "Thomas");
        student[16] = new Student(4, "Thompson");
        student[17] = new Student(2, "White");
        student[18] = new Student(3, "Williams");
        student[19] = new Student(4, "Wilson");
        sort(student, 5);
        for (var i = 0; i < student.length; i++) {
            System.out.println(student[i].key() + student[i].name());
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
