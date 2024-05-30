import java.util.*;

public class Problem5 {

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

        public boolean isBipartite() {
            int[] color = new int[V];
            Arrays.fill(color, -1); // -1 means uncolored

            for (int i = 0; i < V; i++) {
                if (color[i] == -1) { // Not colored, start BFS
                    if (!isBipartiteUtil(i, color)) {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean isBipartiteUtil(int src, int[] color) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(src);
            color[src] = 0; // Start coloring src with color 0

            while (!queue.isEmpty()) {
                int u = queue.poll();

                for (int v : adj.get(u)) {
                    if (color[v] == -1) {
                        color[v] = 1 - color[u];
                        queue.add(v);
                    } else if (color[v] == color[u]) {
                        return false;
                    }
                }
            }
            return true;
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

        if (graph.isBipartite()) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }

        scanner.close();
    }
}
