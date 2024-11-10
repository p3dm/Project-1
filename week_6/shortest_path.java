package week_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Given a directed graph G = (V,E) in which V = {1,2,...,n) is the set of nodes. Each arc (u,v) has a non-negative weight w(u,v). Given two nodes s and t of G. Find the shortest path from s to t on G.
 * Input
 * Line 1: contains two integers n and m which are the number of nodes and the number of arcs of G (1 <= n <= 100000)
 * Line i + 1(i = 1,2,...,m): contains 3 integers u, v, w in which w is the weight of arc(u,v) (0 <= w <= 100000)
 * Line m+2: contains two integers s and t
 * Output
 * Write the weight of the shortest path found or write -1 if no path from s to t was found
 * Example
 * Input
 * 5 7
 * 2 5 87
 * 1 2 97
 * 4 5 78
 * 3 1 72
 * 1 4 19
 * 2 3 63
 * 5 1 18
 * 1 5
 *
 * Output
 * 97
 */

public class shortest_path {
    private static List<List<int[]>> graph;
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] nline = br.readLine().split(" ");
            int u = Integer.parseInt(nline[0]);
            int v = Integer.parseInt(nline[1]);
            int w = Integer.parseInt(nline[2]);
            graph.get(u).add(new int[]{v, w});
        }

        String[] lastline = br.readLine().split(" ");
        int s = Integer.parseInt(lastline[0]);
        int t = Integer.parseInt(lastline[1]);


        int result = zeroOneBFS(n, s, t);
        System.out.println(result);
    }


    public static int zeroOneBFS(int n, int start, int target) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(start);

        while (!deque.isEmpty()) {
            int u = deque.pollFirst();


            for (int[] edge : graph.get(u)) {
                int v = edge[0];
                int weight = edge[1];

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;

                    if (weight == 0) {
                        deque.addFirst(v);
                    } else {
                        deque.addLast(v);
                    }
                }
            }
        }

        return dist[target] == INF ? -1 : dist[target];
    }
}
