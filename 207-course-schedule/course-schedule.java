class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        // Initialize the adjacency list with empty lists
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Build the adjacency list based on prerequisites
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int indegree[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int topo[] = new int[numCourses];
        int ind = 0;
        
        // Perform topological sort
        while (!q.isEmpty()) {
            int node = q.poll(); // Use poll() to remove and retrieve the element

            topo[ind++] = node;

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        // Check if all courses can be finished
        if (ind == numCourses) {
            return true;
        }
        
        return false; // Return false if not all courses can be finished
    }
}
