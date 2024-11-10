package week_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class max_flow {
    private static List<List<Edge>> graph;
    private static boolean[] visited;
    private static int N, M, s, t;
    static class Edge{
        int v, capacity;
        Edge(int v, int capacity){
            this.v = v;
            this.capacity = capacity;
        }
    }
    static int fordFulkerson(int source, int sink){
        int maxFlow = 0;
        while(true){
            visited = new boolean[N + 1];
            int flow = dfs(source, sink, Integer.MAX_VALUE);
            if(flow == 0) break;
            maxFlow += flow;
        }
        return maxFlow;
    }
    static int dfs(int u, int sink, int flow){
        if(u == sink) return flow;
        visited[u] = true;
        for(Edge edge : graph.get(u)){
            if(!visited[edge.v] && edge.capacity > 0){
                int minFlow = Math.min(flow, edge.capacity);
                int ket_qua = dfs(edge.v, sink, minFlow);
                if(ket_qua > 0){
                    edge.capacity -= ket_qua;

                    for (Edge revEdge : graph.get(edge.v)){
                        if (revEdge.v == u) {
                            revEdge.capacity += ket_qua;
                            break;
                        }
                    }
                    return ket_qua;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstline = br.readLine().split(" ");
        N = Integer.parseInt(firstline[0]);
        M = Integer.parseInt(firstline[1]);
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        String[] secLine = br.readLine().split(" ");
        s = Integer.parseInt(secLine[0]);
        t = Integer.parseInt(secLine[1]);
        for(int i = 0; i < M; i++){
            String[] line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            int capacity = Integer.parseInt(line[2]);
            graph.get(u).add(new Edge(v, capacity));
            graph.get(v).add(new Edge(u, 0));
        }
        int maxFlow = fordFulkerson(s,t);
        System.out.println(maxFlow);
    }
}
