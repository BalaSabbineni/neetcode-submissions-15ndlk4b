class Solution {
    public boolean validTree(int n, int[][] edges) {
         if (edges.length != n - 1) return false;
        int len = n;
        int[] parent = new int[len];

        for(int i=0; i<len; i++) {
            parent[i] = i;  
        }
         System.out.println("parent before: "+Arrays.toString(parent));
         

        for(int[] edge: edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            int parent1 = find(parent, node1);
            int parent2 = find(parent, node2);
            
            if(parent1 == parent2) {
                
                return false;
            }

            parent[parent2] = parent1;
             
        }
        
        long countt = Arrays.stream(parent).distinct().count(); 

        return true;

    }

    private int find(int[] parent, int node) {
        while(node != parent[node]) {

            parent[node] = parent[parent[node]];
            node =  parent[node];
        }

        return node;
    }
}
