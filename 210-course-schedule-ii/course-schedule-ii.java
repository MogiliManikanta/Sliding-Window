class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Form a graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) { // Use 'numCourses' instead of 'n'
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) { // Use 'prerequisites.length' instead of 'm'
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

        if (ind == numCourses) {
            return topo;
        }
        
        // If not all courses can be finished, return an empty array
        return new int[0];
    }
}
