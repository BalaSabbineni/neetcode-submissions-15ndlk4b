class Solution {
    // we need to use disjoint union find approach
    // this has two properties find and union
    // find: checks edge presents in which group
    // union: merge to common group
    // if there is cycle to edge, that added as seprate group, 
    // other wise all edges in same group

    public int[] findRedundantConnection(int[][] edges) {

        // First, we need to initialize array named parent, 
        //that parent[i] repesents parent of node i
        int[] parent = new int[edges.length +1];

        // intialize each node with it's parent
        // this means, node 0 parent 0, node 1 is parent 1 etc.
        for(int i=0; i< edges.length + 1; i++) {
            parent[i] = i; // Initially, each node is it's own parent
        }

        // iterate over edges to find redundant one

        for(int[] e: edges) {
            int node1 = e[0];
            int node2 = e[1];

            // Now we need to use our algorithm
            // find the parnets(roots) of node1 and node 2
            // And check roots are different or same.
            // if different merge it by making root2 parent as root1
            int root1 = find(parent, node1);
            int root2 = find(parent, node2);

            // if roots are same, then it forms cycle
            if(root1 == root2) {
                return e;
            } 
            // or update root2 by merge
            parent[root2] = root1;

        }

        return null;
        
    }

    private int find(int[] parent, int node) {
        /*
        KEY: This is heart of solution
        we need to check coming node is not a parent node
        */
        // understood this clearly, otherwise no use.
        while(node != parent[node]) {
            // iterate to find the parent and update
            parent[node] = parent[parent[node]];
            node = parent[node];
        }
        return node;

    }
}
