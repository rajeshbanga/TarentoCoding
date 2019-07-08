package com.tarento.coding;

import java.util.ArrayList;
import java.util.List;

public class DAG {
    private int v;

    private ArrayList<Integer>[] adjList;

    public DAG(int vertices) {

        this.v = vertices;

        initAdjList();
    }

    private void initAdjList() {
        adjList = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            adjList[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int u, int v) {
        adjList[u].add(v);
    }

    public void printAllPaths(int s, int d) {
        boolean[] isVisited = new boolean[v];
        ArrayList<Integer> pathList = new ArrayList<Integer>();

        pathList.add(s);

        printAllPathsUtil(s, d, isVisited, pathList);
    }

    private void printAllPathsUtil(Integer u, Integer d,
                                   boolean[] isVisited,
                                   List<Integer> localPathList) {

        isVisited[u] = true;

        if (u.equals(d)) {
            System.out.println(localPathList);
            isVisited[u] = false;
            return;
        }

        for (Integer i : adjList[u]) {
            if (!isVisited[i]) {
                localPathList.add(i);
                printAllPathsUtil(i, d, isVisited, localPathList);
                localPathList.remove(i);
            }
        }

        isVisited[u] = false;
    }

    public static void main(String[] args) {
        DAG g = new DAG(9);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(1, 5);
        g.addEdge(2, 6);
        g.addEdge(3, 6);
        g.addEdge(3, 7);
        g.addEdge(4, 7);
        g.addEdge(4, 8);
        g.addEdge(5, 8);

        int s = 1;

        for (int d = 6; d < 9; d++) {
            g.printAllPaths(s, d);
        }

    }
}
