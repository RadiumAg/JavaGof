package com.company.DataStructure.Graph;

/**
 * 图类
 */
public class Graph {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[]; // 节点列表
    private int adjMat[][]; // 邻接矩阵
    private int nVerts; // 当前的节点索引
    private StackX theStack;
    private Queue theQueue;

    public Graph() {
        theStack = new StackX();
        theQueue = new Queue();
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++) {
            for (int k = 0; k < MAX_VERTS; k++) {
                adjMat[j][k] = 0;
            }
        }
    }

    /**
     * @apiNote 深度遍历
     */
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

    /**
     * @apiNote 广度遍历
     */
    public void bfs() {
        this.vertexList[0].wasVisited = true;
        displayVertex(0);
        theQueue.insert(0);
        int v2;

        while (!theQueue.isEmpty()) {
            int v1 = theQueue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                theQueue.insert(v2);
            }
        }

        for (int j = 0; j < nVerts; j++) {
            vertexList[j].wasVisited = false;
        }
    }

    /**
     * @apiNote 生成最小树
     */
    public void mst() {
        this.vertexList[0].wasVisited = true;
        this.theStack.push(0);

        while (!theStack.isEmpty()) {
            int currentValue = this.theStack.peek();
            int v = this.getAdjUnvisitedVertex(this.theStack.peek());
            if (v == -1)
                this.theStack.pop();
            else {
                this.theStack.push(v);
                this.vertexList[v].wasVisited = true;
                this.displayVertex(currentValue);
                this.displayVertex(v);
                System.out.print(" ");
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

    public int onSuccessors(){
        boolean isEdge;
        for (int row = 0; row < nVerts ; row++) {
            for (int col = 0; col < row+1; col++) {

            }
        }
    }

    public void addEdge(int start, int end, boolean isDirection) {
        adjMat[start][end] = 1;
        if (isDirection) {
            return;
        }
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }
}

/**
 *  顶点类
 */
class Vertex {
    public char label;
    public boolean wasVisited;

    public Vertex(char lab) {
        label = lab;
        wasVisited = false;
    }
}

/**
 *  操作栈类
 */
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

    /**
     * @return 出栈，并返回出栈的值
     */
    public int pop() {
        return st[this.top--];
    }

    /**
     * @return 返回栈顶的值
     */
    public int peek() {
        return st[this.top];
    }

    public boolean isEmpty() {
        return (this.top == -1);
    }
}


/**
 * 队列
 */
class Queue {
    private final int SIZE = 20;
    private int[] queArray;
    private int front;
    private int rear;

    public Queue() {
        queArray = new int[this.SIZE];
        front = 0;
        rear = -1;
    }

    public void insert(int j) {
        if (rear == SIZE - 1)
            rear = -1;
        queArray[++rear] = j;
    }

    public int remove() {
        var temp = queArray[front++];
        if (front == this.SIZE)
            front = 0;
        return temp;
    }

    public boolean isEmpty() {
        return (rear + 1 == front || (front + SIZE - 1 == rear));
    }
}