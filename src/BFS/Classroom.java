package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Classroom {
    // Inner static class to represent an edge in the graph
    static class Edge {
        int src; // Source vertex
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
        graph[1].add(new Edge(1, 3)); // Corrected to add edge to graph[1] instead of graph[0]

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

    // Method to perform BFS on the graph starting from vertex 0
    public static void bfs(ArrayList<Edge>[] graph, int V) {
        Queue<Integer> q = new LinkedList<>(); // Queue to keep track of vertices to visit
        boolean vis[] = new boolean[V]; // Array to keep track of visited vertices
        q.add(0); // Start BFS from vertex 0

        // Continue until all vertices in the queue are processed
        while (!q.isEmpty()) {
            int curr = q.remove(); // Remove the current vertex from the queue
            if (!vis[curr]) { // If the current vertex has not been visited
                System.out.println(curr + " "); // Print the current vertex
                vis[curr] = true; // Mark the current vertex as visited

                // Add all adjacent vertices to the queue
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
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

        // Perform BFS starting from vertex 0
        bfs(graph, V);
    }
}
