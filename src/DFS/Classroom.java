package DFS;

import java.util.ArrayList;

public class Classroom {
    // Inner static class to represent an edge in the graph
    static class Edge {
        int src;  // Source vertex
        int dest; // Destination vertex

        // Constructor to initialize an edge
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Method to create a graph with a given number of vertices
    public static void createGraph(ArrayList<Edge>[] graph) {
        // Initialize each index in the graph array with an empty ArrayList of edges
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        // Adding edges to the graph
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }

    // Method to perform DFS on the graph starting from the given vertex
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis) {
        System.out.print(curr + " "); // Print the current vertex
        vis[curr] = true; // Mark the current vertex as visited

        // Recursively visit all adjacent vertices
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static void main(String[] args) {
        int V = 7; // Number of vertices
        /*
          Graph representation:
           1----3
          /     | \
         0      |  5 --6
          \     | /
           2----4
        */
        // Corrected array initialization for an array of ArrayLists
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        boolean[] vis = new boolean[V]; // Array to keep track of visited vertices
        // Perform DFS starting from vertex 0
        dfs(graph, 0, vis);
        System.out.println(); // Print a newline after DFS traversal
    }
}
