package com.company.DataStructure.Graph;

public class Main {

    public static void main(String[] args) {
//        var redCircle = new Circle(100, 100, 10, new RedCircle());
//        var greenCircle = new Circle(100, 100, 10, new GreenCircle());
//
//        redCircle.draw();
//        greenCircle.draw();
//
//        var chRemote = new self.my.Remote(new ChangHongTv());
//        var aocRemote = new self.my.Remote(new AOCTv());
//        chRemote.open();
//        aocRemote.open();
//        int[] a = new int[3];
//        Arrays.stream(a).map(x->2);

        Graph theGraph = new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
        theGraph.addEdge(0, 1); // AB
        theGraph.addEdge(1, 2); //BC
        theGraph.addEdge(0, 3); //AD
        theGraph.addEdge(3, 4); //DE
        System.out.print("Visits:");
        theGraph.dfs();
        System.out.print("");
    }
}



