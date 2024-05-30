import java.util.*;

public class Problem8 {

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

        public boolean isIsomorphic(Graph other) {
            if (V != other.V || adj.size() != other.adj.size()) {
                return false;
            }

            // Calculate degrees of vertices for both graphs
            int[] degrees1 = new int[V];
            int[] degrees2 = new int[V];
            for (int i = 0; i < V; i++) {
                degrees1[i] = adj.get(i).size();
                degrees2[i] = other.adj.get(i).size();
            }

            // Sort the degree arrays
            Arrays.sort(degrees1);
            Arrays.sort(degrees2);

            // Check if the degree arrays are equal
            return Arrays.equals(degrees1, degrees2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices for the first graph: ");
        int V1 = scanner.nextInt();

        System.out.print("Enter the number of edges for the first graph: ");
        int E1 = scanner.nextInt();

        Graph graph1 = new Graph(V1);

        System.out.println("Enter the edges (u v) for the first graph:");
        for (int i = 0; i < E1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph1.addEdge(u, v);
        }

        System.out.print("Enter the number of vertices for the second graph: ");
        int V2 = scanner.nextInt();

        System.out.print("Enter the number of edges for the second graph: ");
        int E2 = scanner.nextInt();

        Graph graph2 = new Graph(V2);

        System.out.println("Enter the edges (u v) for the second graph:");
        for (int i = 0; i < E2; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph2.addEdge(u, v);
        }

        if (graph1.isIsomorphic(graph2)) {
            System.out.println("The two graphs are isomorphic.");
        } else {
            System.out.println("The two graphs are not isomorphic.");
        }

        scanner.close();
    }
}
