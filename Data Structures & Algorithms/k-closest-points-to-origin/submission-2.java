class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // concentrate more, it's a easy one
        /*
        we need to find near poitns to (0,0)
        so, basically we cal calculate the distance between points and
        need to return lower value points

        To find distance, we have formula in question.
        */

        // need a result with k closest points
        // why 2 is, because we have only two cordinates i.e, x and y.
        int[][] result = new int[k][2];

        // we need to use, priority queue 
        // why beacuse we need to sort based on distance
        // we need a PQ with every point, so need int array
        // we need a comparator that calculate distance between 
        // origin (0,0) & (xi, yi)

        /* about formula, sqrt((x1 - x2)^2 + (y1 - y2)^2)
        we don't need to calculate sqroot, just x^2 + y^2 is enough
        */
        PriorityQueue<int[]> pq = new 
        PriorityQueue<>(Comparator.comparingInt(this::euclideanDistance));

           // now add points to pq
           for (int[] p: points) {
            // add to pq, it sorts based on our comparatore logic
            pq.offer(p);
           }

           // now get kth nearest values using loop

           for(int i =0; i<k;i++) {
            result[i] = pq.poll();
           }
           return result;

    }

    private int euclideanDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
