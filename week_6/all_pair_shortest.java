package week_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class all_pair_shortest {
    private static List<List<int[]>> graph;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);

        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
             String[] line = br.readLine().split(" ");
             int u = Integer.parseInt(line[0]);
             int v = Integer.parseInt(line[1]);
             int w = Integer.parseInt(line[2]);

             graph.get(u).add(new int[]{v,w});
        }

        floydWarshall(graph, n);
    }
    public static void floydWarshall(List<List<int[]>> graph, int n){
        int[][] dist = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        for (int u = 1; u <= n; u++){
            for(int[] edge : graph.get(u)){
                int v = edge[0];
                int weight = edge[1];
                dist[u][v] = weight;
            }
        }
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE){
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
