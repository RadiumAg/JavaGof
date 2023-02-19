package com.company.DataStructure.Graph;

public class Main {

    public static void main(String[] args) {
        Graph theGraph = new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
        theGraph.addEdge(0, 1, true); // AB
        theGraph.addEdge(1, 2,true); // BC
        theGraph.addEdge(0, 3,true); // AD
        theGraph.addEdge(3, 4,true); // DE
        System.out.print("Visits:");
//        theGraph.dfs();
        theGraph.mst();
        System.out.print("");
    }
}



