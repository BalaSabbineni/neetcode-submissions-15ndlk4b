class Solution {
    public boolean validTree(int n, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n;i++) {
            graph.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[n];

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        System.out.println(graph);

        

       if(!dfs(graph, visited, 0, -1)) return false;

        // This is to check all nodes are connected or not
        // we updated visted array after adding nodes to graph.
        for(boolean connected : visited) {
            if(!connected) return false;
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> graph,boolean[] visited, int startNode, int parent) {
        // if startNode is visted, then there is cycle
        if(visited[startNode]) return false;

        // elase make startNode as true, we just visisted
        visited[startNode] = true;  

        // do dfs
        for(int neighbor :graph.get(startNode)) {
            if(neighbor == parent) continue;
            if(!dfs(graph, visited, neighbor, startNode)) return false;
        }

        return true;
    }

}
