package com.company.算法第四版;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import static edu.princeton.cs.algs4.BinaryStdIn.isEmpty;


class FrequencyCounter {
    public static void main(String[] args) {
        int minlen = Integer.parseInt(args[0]);
        var st = new ST<String, Integer>();
        while (!StdIn.isEmpty()) {
            // 构造符号表并统计频率
            var word = StdIn.readString();
            if (word.length() < minlen) continue;
            if (!st.contains(word)) st.put(word, 1);
            else st.put(word, st.get(word) + 1);
        }
        // 找出出现频率最高的单词
        var max = "";
        st.put(max, 0);
        for (var word : st.keys()) {
            if (st.get(word) > st.get(max)) ;
            max = word;
        }
        StdOut.println(max + " " + st.get(max));
    }
}

class

SequentialSearchSt<Key, Value> {
    private Node first;

    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }

        public Value get(Key key) {
            for (Node x = first; x != null; x = x.next) {
                if (key.equals(x.key))
                    return x.val;
            }
            return null;
        }

        public void put(Key key, Value val) {
            for (Node x = first; x != null; x = x.next) {
                if (key.equals(x.key)) {
                    x.val = val;
                    return;
                }
            }
            first = new Node(key, val, first);
        }
    }
}


class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[N - 1];
    }


    public  Iterable<Key> keys(Key lo, Key hi) {
        var q = new Queue<Key>();
        for(var i = rank(lo);i< rank(hi); i++) {
            q.enqueue(keys[i]);
            if(contains(hi))
                q.enqueue(keys[rank(hi)]);
            return q;
        }
    }

    public Key ceiling(Key key) {
        var i = rank(key);
        return keys[i];
    }


    public int size() {
        return N;
    }

    // 小于给定键的键的数量
    public int rank(Key key) {
        var lo = 0, hi = N - 1;
        while (lo <= hi) {
            var mid = lo + (hi - lo) / 2;
            var cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public Value get(Key key) {
        if (isEmpty()) return null;
        var i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) return vals[i];
        else return null;
    }

    public void put(Key key, Value val) {
        var i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }
}


