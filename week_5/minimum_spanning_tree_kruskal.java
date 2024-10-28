package week_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/***
 * Given a undirected connected graph G=(V,E) where V={1,…,N}. Each edge (u,v)∈E(u,v)∈E has weight w(u,v)w(u,v). Compute minimum spanning tree of G.
 * Input
 * Line 1: N and M (1≤N,M≤10
 * 5
 * ) in which NN is the number of nodes and MM is the number of edges.
 * Line i+1 (i=1,…,M): contains 3 positive integers u, v, and w where w is the weight of edge (u,v)
 * Output
 * Write the weight of the minimum spanning tree found.
 * Example
 * Input
 * 5 8
 * 1 2 1
 * 1 3 4
 * 1 5 1
 * 2 4 2
 * 2 5 1
 * 3 4 3
 * 3 5 3
 * 4 5 2
 * Output
 * 7
 */
class Edge {
    int src, dest, weight;


    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class Subset {
    int parent, rank;
}

class KruskalAlgorithm {
    private int vertices;
    private List<Edge> edges;

   
    public KruskalAlgorithm(int vertices) {
        this.vertices = vertices;
        this.edges = new ArrayList<>();
    }

    
    public void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }


    private int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent); // Path compression
        }
        return subsets[i].parent;
    }


    private void union(Subset[] subsets, int x, int y) {
        int rootX = find(subsets, x);
        int rootY = find(subsets, y);

        if (subsets[rootX].rank < subsets[rootY].rank) {
            subsets[rootX].parent = rootY;
        } else if (subsets[rootX].rank > subsets[rootY].rank) {
            subsets[rootY].parent = rootX;
        } else {
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }

    public void kruskalMST() {
        Collections.sort(edges, Comparator.comparingInt(e -> e.weight));
        List<Edge> mst = new ArrayList<>();
        int mstWeight = 0;
        Subset[] subsets = new Subset[vertices + 1];
        for (int i = 0; i <= vertices; i++) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }
        for (Edge edge : edges) {
            int x = find(subsets, edge.src);
            int y = find(subsets, edge.dest);
            if (x != y) {
                mst.add(edge);
                mstWeight += edge.weight;
                union(subsets, x, y);
            }
        }
            System.out.println(mstWeight);
    }
}

public class minimum_spanning_tree_kruskal {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        KruskalAlgorithm graph = new KruskalAlgorithm(n);
        for (int i = 0; i < m; i++) {
            String[] arr = br.readLine().split(" ");
            int u = Integer.parseInt(arr[0]);
            int v = Integer.parseInt(arr[1]);
            int w = Integer.parseInt(arr[2]);
            graph.addEdge(u, v, w);
        }
        graph.kruskalMST();
    }

}
