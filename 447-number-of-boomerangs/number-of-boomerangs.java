class Solution{
    public int numberOfBoomerangs(int[][] points) {
        int res = 0; // Initialize the result variable to count boomerangs
        Map<Integer, Integer> map = new HashMap<>(); // Create a map to store distances and their frequencies
        for(int i=0; i<points.length; i++) { // Iterate through each point in the array
            for(int j=0; j<points.length; j++) { // For each point, iterate through all other points
                if(i == j) // Skip if the points are the same
                    continue;
                
                int d = getDistance(points[i], points[j]); // Calculate the distance between the current point and the other point
                map.put(d, map.getOrDefault(d, 0) + 1); // Update the map with the distance and its frequency
            }
            
            for(int val : map.values()) { // Iterate through the frequencies of distances
                res += val * (val-1); // For each frequency, calculate the number of possible boomerangs and add to the result
            }            
            map.clear(); // Clear the map for the next iteration
        }
        
        return res; // Return the total count of boomerangs
    }


// Helper method to calculate the distance between two points
    private int getDistance(int[] a, int[] b) {
        int dx = a[0] - b[0]; // Calculate the difference in x coordinates
        int dy = a[1] - b[1]; // Calculate the difference in y coordinates
        
        return dx*dx + dy*dy; // Return the square of the Euclidean distance between the points
    }

}