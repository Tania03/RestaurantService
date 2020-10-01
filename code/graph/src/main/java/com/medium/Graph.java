package com.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tania.gupta
 * @date 24/06/20
 */
public class Graph {
    int vertices;
    List<Integer>[] edges;

    Graph(int vertices, int[][] prerequisites) {

        this.vertices = vertices;
        edges = new ArrayList[vertices];

        for (int i = 0; i < vertices; i++)
            edges[i] = new ArrayList();

        for (int[] i : prerequisites) {
            edges[i[0]].add(i[1]);
        }
    }
}



