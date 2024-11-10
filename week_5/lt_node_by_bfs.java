package week_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class lt_node_by_bfs {
    private static List<List<Integer>> graph;
    private static boolean[] visited;
    private static List<Integer> ket_qua;

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            ket_qua.add(node);

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];
        ket_qua = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i = 0; i <= n; i++ ){
            Collections.sort(graph.get(i));
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                bfs(i);
            }
        }

        for(int node : ket_qua){
            System.out.print(node + " ");
        }
    }
}
