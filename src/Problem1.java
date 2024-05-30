import java.util.*;

public class Problem1 {

    static class Graph {
        private final int V;
        private final List<List<Integer>> adj;

        public Graph(int V) {
            this.V = V;
            adj = new ArrayList<>(V);
            for (int i = 0; i < V; i++) {
                adj.add(new LinkedList<>());
            }
        }

        public void addEdge(int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        private void DFS(int v, boolean[] visited) {
            visited[v] = true;
            for (int next : adj.get(v)) {
                if (!visited[next]) {
                    DFS(next, visited);
                }
            }
        }

        public boolean isConnected() {
            boolean[] visited = new boolean[V];
            DFS(0, visited);

            for (boolean v : visited) {
                if (!v) {
                    return false;
                }
            }
            return true;
        }

        public int countConnectedComponents() {
            boolean[] visited = new boolean[V];
            int count = 0;

            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    DFS(i, visited);
                    count++;
                }
            }

            return count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();

        Graph graph = new Graph(V);

        System.out.println("Enter the edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.addEdge(u, v);
        }

        if (graph.isConnected()) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected.");
            int connectedComponents = graph.countConnectedComponents();
            System.out.println("Number of connected components: " + connectedComponents);
        }

        scanner.close();
    }
}
