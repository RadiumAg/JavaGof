package com.company.算法第四版;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


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

class SequentialSearchSt<Key, Value> {
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
            first = new Node(key,val,first);
        }
    }
}