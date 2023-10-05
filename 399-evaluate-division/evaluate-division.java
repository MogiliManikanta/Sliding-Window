class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Step 1: Create a graph and populate it with the given equations and values
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        
        // Step 2: Process each query and calculate the result
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            results[i] = evaluateQuery(queries.get(i).get(0), queries.get(i).get(1), graph, new HashSet<>());
        }
        
        return results;
    }
    
    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double quotient = values[i];
            
            graph.putIfAbsent(dividend, new HashMap<>());
            graph.putIfAbsent(divisor, new HashMap<>());
            
            graph.get(dividend).put(divisor, quotient);
            graph.get(divisor).put(dividend, 1 / quotient);
        }
        
        return graph;
    }
    
    private double evaluateQuery(String dividend, String divisor, Map<String, Map<String, Double>> graph, Set<String> visited) {
        if (!graph.containsKey(dividend) || !graph.containsKey(divisor))
            return -1.0; // Invalid query
        
        if (dividend.equals(divisor))
            return 1.0; // Base case: dividend and divisor are the same
        
        visited.add(dividend);
        Map<String, Double> neighbors = graph.get(dividend);
        
        for (String neighbor : neighbors.keySet()) {
            if (visited.contains(neighbor))
                continue; // Avoid cycles
            
            double result = evaluateQuery(neighbor, divisor, graph, visited);
            if (result != -1.0)
                return neighbors.get(neighbor) * result;
        }
        
        visited.remove(dividend); // Backtrack
        return -1.0; // No path found from dividend to divisor
    }
}