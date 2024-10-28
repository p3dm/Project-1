package week_5;

/***
 * Given an undirected graph G = (V,E). Write a program to check if G is a Hamiltonian graph.
 * Input
 * Line 1: a positive integer T (number of graphs)
 * Subsequent lines are information about T graphs, each has the following format:
 * Line 1: n and m (number of nodes and edges)
 * Line i+1 (i = 1, 2, ..., m): u and v : two end points of the ith edge
 * Output
 * In the i
 * th
 *  line, write 1 if the corresponding is a Hamiltonian graph, and write 0, otherwise
 * Example
 * Input
 * 2
 * 5 5
 * 1 2
 * 1 3
 * 2 4
 * 2 5
 * 3 5
 * 7 13
 * 1 3
 * 1 5
 * 1 7
 * 2 4
 * 2 5
 * 2 6
 * 3 4
 * 3 5
 * 3 7
 * 4 6
 * 4 7
 * 5 7
 * 6 7
 *
 * Output
 * 0
 * 1
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;


public class halmiton_cycle {
        private static ArrayList<Integer>[] adjList;
        private static boolean[] visited;
        private static int n;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


            int T = Integer.parseInt(br.readLine().trim());
            StringBuilder output = new StringBuilder();

            for (int t = 0; t < T; t++) {
                String[] line = br.readLine().split(" ");
                n = Integer.parseInt(line[0]);
                int m = Integer.parseInt(line[1]);

                adjList = new ArrayList[n + 1];
                for (int i = 1; i <= n; i++) {
                    adjList[i] = new ArrayList<>();
                }


                for (int i = 0; i < m; i++) {
                    String[] input = br.readLine().split(" ");
                    int u = Integer.parseInt(input[0]);
                    int v = Integer.parseInt(input[1]);
                    adjList[u].add(v);
                    adjList[v].add(u);
                }

                output.append(checkHamilton() ? 1 : 0).append("\n");
            }

            System.out.println(output);
        }

        private static boolean checkHamilton() {
            for (int i = 1; i <= n; i++) {
                visited = new boolean[n + 1];
                if (dfs(i, 1)) {
                    return true;
                }
            }
            return false;
        }


        private static boolean dfs(int node, int count) {
            visited[node] = true;

            if (count == n) {
                return adjList[node].contains(1);
            }


            for (int neighbor : adjList[node]) {
                if (!visited[neighbor]) {
                    if (dfs(neighbor, count + 1)) {
                        return true;
                    }
                }
            }
            visited[node] = false;
            return false;
        }
    }


