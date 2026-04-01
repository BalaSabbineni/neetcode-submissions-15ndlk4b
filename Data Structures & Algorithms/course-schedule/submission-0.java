class Solution {
    // we need to find the cycle is there or not.
    // If yes, return flase;
    // Return flase if below is the case 
    // "For getting a job you need experience , and for getting an experience you need a job"
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // edge case
        if(numCourses ==0) return true;


        /*
        we need to find any cycle is there or not
        We need to use BFS and topological sort

        we have prereq's like  [[0,1],[1,2]]
        To complete, 1 course which is 2nd element in 1st array, 
        we need to finish 0

        In 2nd array, to take course 2, need to finish 1.

        which is possible.

        We need to a array or map of course and respective prereq
        I mean, map<CourseInt, PreReqIntCount> = [[1,1], [2,1]]  
        for course 1 has only one prereq, smae for course 2.

        And we need to decrease this count after polling element from queue

        */

        // FIRST, we need a adjancet list from given input for graph
        List<List<Integer>> graph = new ArrayList<>();
        // AND array for tacking prereq's of node or course
        int[] inDegree = new int[numCourses];
        
        // add empty nodes to graph 
        for(int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // populate map with prereq's [[0,1],[1,2]]
        for(int[] preReq : prerequisites) {
            // here 1st iteration value of preReq is [0,1]
            // add course 1's dependent to 1st index grpah
            graph.get(preReq[1]).add(preReq[0]);

            // Increment dependent count in inDegree for tracking
            inDegree[preReq[0]]++;
        }

        // Now, we will do BFS
        Queue<Integer> q = new LinkedList<>();

        // first we need to find which course doesn't have dependecy
        for(int i=0; i<numCourses; i++) {
            if(inDegree[i] == 0) {
                // this zero means, there are no dependencies for that course
                q.offer(i);
            }
        }

        // npw we just need to do standard BFS
        int count =0;
        while(!q.isEmpty()) {
            int curr = q.poll();
            count++;
            // get curr element node from graph and reduce dependent
            for(int next : graph.get(curr)) {
                inDegree[next]--;
                // if there are no depends for next course add to queue
                if(inDegree[next] ==0) q.add(next);
            }
        }
        // if we are able to iterate all nodes, then no cycle and true
        return count == numCourses;
    }
}
