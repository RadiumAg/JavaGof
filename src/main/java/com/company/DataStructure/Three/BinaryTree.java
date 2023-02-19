package com.company.DataStructure.Three;

import java.sql.ClientInfoStatus;

/**
 * 树类
 */
class Tree {
    private Node root;

    public Tree(Node rootNode) {
        this.root = rootNode;
    }

    public Node find(int key) {
        var current = this.root;
        while (!(current.iData == key)) {
            if (current.iData > key) {
                current = current.leftChild;
            }

            if (current.iData < key) {
                current = current.rightChild;
            }

            // 到尾结点
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void insert(int id, double dd) {
        Node newNode = new Node();
        newNode.iData = id;
        newNode.fData = dd;
        if (root == null)
            root = newNode;
        else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (id < current.iData) {
                    current = current.leftChild;
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (current.iData != key) {
            parent = current;
            if (key < current.iData) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null)
                return false;

            if (current.leftChild == null && current.rightChild == null) {
                if (current == root)
                    root = null;
                else if (isLeftChild)
                    parent.leftChild = null;
                else
                    parent.rightChild = null;
            } else if (current.leftChild == null) {
                if (current == root)
                    root = current.rightChild;
                else if (isLeftChild)
                    parent.leftChild = current.rightChild;
                else
                    parent.rightChild = current.rightChild;
            } else {
                Node successor = getSuccessor(current);
                if (current == root)
                    root = successor;
                else if (isLeftChild)
                    parent.rightChild = successor;
                successor.leftChild = current.leftChild;
            }
        }
        return true;
    }

    public Node minimum() {
        Node current;
        Node last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    /**
     * 找到后继节点
     *
     * @param delNode
     * @return
     */
    public Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        } else {
            successor = getSuccessor(current);
        }
        return successor;
    }

    public void inOrder(Node localRoot) {
        if (localRoot == null) {
            return;
        }
        inOrder(localRoot.leftChild);
        System.out.print(localRoot.iData + "");
        inOrder(localRoot.rightChild);
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
        System.out.print("{");
        System.out.print(iData);
        System.out.print(", ");
        System.out.print(fData);
        System.out.print("} ");
    }
}