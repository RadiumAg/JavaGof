package com.company.DataStructure.Graph;

// 图
public class Graph {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[]; // 节点列表
    private int adjMat[][]; // 邻接矩阵
    private int nVerts; // 当前的节点索引
    private StackX theStack;

    public Graph() {
        theStack = new StackX();
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++) {
            for (int k = 0; k < MAX_VERTS; k++) {
                adjMat[j][k] = 0;
            }
        }
    }

    public void dfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        this.theStack.push(0);

        while (!theStack.isEmpty()) {
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1)
                theStack.pop();
            else {
                this.vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }

        for (int j = 0; j < nVerts; j++) {
            vertexList[j].wasVisited = false;
        }

    }

    public int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++) {
            if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false) return j;
        }
        return -1;
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }
}

// 顶点
class Vertex {
    public char label;
    public boolean wasVisited;

    public Vertex(char lab) {
        label = lab;
        wasVisited = false;
    }
}

class StackX {
    private final int SIZE = 20;
    private int[] st;
    private int top;

    public StackX() {
        st = new int[SIZE];
        this.top = -1;
    }

    public void push(int j) {
        st[++top] = j;
    }

    public int pop() {
        return st[this.top--];
    }

    public int peek() {
        return st[this.top];
    }

    public boolean isEmpty() {
        return (this.top == -1);
    }
}