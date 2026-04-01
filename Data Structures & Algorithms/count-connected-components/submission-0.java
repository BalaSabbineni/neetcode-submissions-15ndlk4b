class Solution {
    public int countComponents(int n, int[][] edges) {
        int result = n;

        int[] parent = new int[n+1];

        for(int i =0; i<n+1; i++) {
            parent[i] = i;
        }

        for(int[] edge : edges) {
            int parent1 = find(parent, edge[0]);
            int parent2 = find(parent, edge[1]);

            if(parent1 != parent2) {
                System.out.println("n: "+ n);
                parent[parent2] = parent1;
                result--;
            }
            

        }
        return result;
    }

    private int find(int[] parent, int node) {
        while(node != parent[node]) {
            parent[node] = parent[parent[node]];
            node =  parent[node];
        }
        return node;
    }
}
