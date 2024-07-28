package GraphWeight;

import java.util.ArrayList;

public class Classroom {
    // Inner static class to represent an edge in the graph
    static class Edge {
        int src;  // Source vertex
        int dest; // Destination vertex
        int wt;   // Weight of the edge

        // Constructor to initialize an edge
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // Method to create a graph with a given number of vertices
    public static void createGraph(ArrayList<Edge>[] graph) {
        // Initialize each index in the graph array with an empty ArrayList of edges
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        // Adding edges to the graph with weights
        graph[0].add(new Edge(0, 2, 2));

        graph[1].add(new Edge(1, 2, 10));
        graph[1].add(new Edge(1, 3, 0));

        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, -1));

        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 2, -1));
    }

    public static void main(String[] args) {
        int V = 4; // Number of vertices
        // Corrected array initialization for an array of ArrayLists
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        // Loop through the edges of vertex 1 and print their destination vertices and weights
        for (int i = 0; i < graph[1].size(); i++) {
            Edge e = graph[1].get(i); // Get the i-th edge of vertex 1
            System.out.println(e.dest + " , " + e.wt); // Print the destination vertex and weight of the edge
        }
    }
}
