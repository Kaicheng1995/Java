/**
* 1. Undirected Graph Implemetaion
* 2. DFS Implementation
        s-t paths: Find a path from s to every reachable vertex
        Runtime: O(V+E), Space: theta(V)
* 3. BFS Implementation
        s-t paths: Find a shortest path from s to every reachable vertex
        Runtime: O(V+E), Space: theta(V)
*/


public class Graph {

    /********* Undirected Graph Implementation *********/

    private final int V; // V vertexs, V can not be changed
    private List<Integer>[] adj; // an array of lists

    // create a graph with V vertex
    public Graph(int V) {
        this.V = V;
        adj = (List<Integer>[]) new ArrayList<>[V]; // weird...
        for (int i = 0; i < V; i++) {
            adj[V] = new ArrayList<Integer>();  // initialize each arraylist
        }
    }
    // add edge between two vertex
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);   // undirected graph
    }
    // get an arraylist of all neighbors that connects v
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }


    /********* DFS *********
    * 1. Create a graph object
    * 2. Pass the graph to a graph-processing method, or constructor in a client class 
    * 3. Query the class for information
    */
    public class DFS {
        //just like the screenshots of the lecture
        private boolean[] marked;
        private int[] edgeTo;
        private int s;  // starting vertice

        public DFS(Graph G, int s) {
            marked = new boolean[V];
            edgeTo = new int[V];
            s = s;
            dfs(G,s);
        }
        
        // find the paths from G, starting from vertice v
        private void dfs(Graph G, int v) {
            marked[v] = true;
            for (int w : G.adj[v]) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    dfs(G, w);
                }
            }
        }

        // check if there's a path from s to v
        public boolean hasPathTo(int v) {
            return marked[v];
        }

        // get the path from s to v
        public Iterable<Integer> pathTo(int v) {
            if (!hasPathTo(v)) return null;
            List<Integer> path = new ArrayList<>();
            for (int x = v; x != s; x = edgeTo[x]) {
                path.add(x);
            }
            path.add(s);
            Collections.reverse(path);
            return path;
        }
    }


    /********* BFS *********
    * 1. Create a graph object
    * 2. Pass the graph to a graph-processing method, or constructor in a client class 
    * 3. Query the class for information
    */
    public class BFS {
        private boolean[] marked;
        private int[] edgeTo;
        private int s;

        public BFS(Graph G, int s) {
            marked = new boolean[V];
            edgeTo = new int[V];
            s = s;
            bfs(G,s);
        }

        // find the [shortest] paths from G, starting from vertice v
        private void bfs(Graph G, int s) {
            Queue<Integer> fringe = new Queue<>();

            // add s to the last, set up starting vertex
            fringe.enqueue(s);
            marked[s] = true;

            while(!fringe.isEmpty()) {
                // for freshly dequeued vertex v, for each neighbor that is unmarked:
                // 1. Enqueue that neighbor to the fringe
                // 2. Mark it
                // 3. Set its edgeTo to v
                int v = fringe.dequeue();
                for (int w : G.adj(v)) {
                    if (!marked[w]) {
                        fringe.enqueue(w);
                        marked[w] = true;
                        edgeTo[w] = v;
                    }
                }
            }
        }
    }
}