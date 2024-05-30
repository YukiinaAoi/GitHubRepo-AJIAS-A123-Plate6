import java.util.*;

public class Problem7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();

        // List to store edges and their multiplicity
        List<int[]> edges = new ArrayList<>();

        System.out.println("Enter the edges (u v) and the number of times each edge appears:");
        for (int i = 0; i < E; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int multiplicity = scanner.nextInt();
            for (int j = 0; j < multiplicity; j++) {
                edges.add(new int[]{u, v});
            }
        }

        // Total number of edges considering multiplicity
        int totalEdges = edges.size();

        // Initialize the incidence matrix
        int[][] incidenceMatrix = new int[V][totalEdges];

        // Fill the incidence matrix
        for (int j = 0; j < totalEdges; j++) {
            int u = edges.get(j)[0];
            int v = edges.get(j)[1];
            incidenceMatrix[u][j] = 1;
            if (u != v) { // No need to mark twice for loops
                incidenceMatrix[v][j] = 1;
            }
        }

        // Output the incidence matrix
        System.out.println("Incidence Matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < totalEdges; j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}

