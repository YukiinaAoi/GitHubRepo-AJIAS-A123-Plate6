import java.util.*;

public class Problem4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();

        int[] degree = new int[V];

        System.out.println("Enter the edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            degree[u]++;
            degree[v]++;
        }

        System.out.println("Degree of each vertex:");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + ": " + degree[i]);
        }

        scanner.close();
    }
}

