package com.company.DataStructure.Three;

/**
 * 树类
 */
class Tree {
    private Node root;

    public Tree(Node rootNode){
      this.root = rootNode;
    }

    public Node find(int key) {
        var current =this.root;
        while (!(current.iData == key)){
            if (current.iData > key){
                current = current.leftChild;
            }

            if (current.iData < key){
                current = current.rightChild;
            }

            if (current == null){
                return null;
            }
        }
        return current;
    }

    public void insert(int id, double dd) {
    }

    public void delete(int id) {

    }
}

/**
 * 结点
 */
class Node {
    int iData;
    double fData;
    Node leftChild;
    Node rightChild;

    public void displayNode() {

    }

    public void insert(int id, double dd) {
    }

    public void delete(int id) {

    }
}