class Solution {
    
class Node {
    int first;
    int second;
    int third; 
    Node(int _first, int _second, int _third) {
        this.first = _first; 
        this.second = _second; 
        this.third = _third; 
    }
}
    public int[][] updateMatrix(int[][] grid) {
         int n = grid.length; 
	    int m = grid[0].length; 
	    // visited and distance matrix
	    int vis[][] = new int[n][m]; 
	    int dist[][] = new int[n][m]; 
	    // <coordinates, steps>
	    Queue<Node> q = new LinkedList<Node>();
	    // traverse the matrix
	    for(int i = 0;i<n;i++) {
	        for(int j = 0;j<m;j++) {
	        // start BFS if cell contains 0
	            if(grid[i][j] == 0) {
	                q.add(new Node(i, j, 0)); 
	                vis[i][j] = 1; 
	            }
	            else {
	                // mark unvisted 
	                vis[i][j] = 0; 
	            }
	        }
	    }
	    
	    
	    
	    int delrow[] = {-1, 0, +1, 0}; 
	    int delcol[] = {0, +1, 0, -1}; 
	    
	    
	    // n x m x 4 
	    // traverse till queue becomes empty
	    while(!q.isEmpty()) {
	        int row = q.peek().first; 
	        int col = q.peek().second; 
	        int steps = q.peek().third; 
	        q.remove(); 
	        dist[row][col] = steps; 
	        // for all 4 neighbours
	        for(int i = 0;i<4;i++) {
	            int nrow = row + delrow[i]; 
	            int ncol = col + delcol[i]; 
	            // check for valid unvisited cell
	            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
	            && vis[nrow][ncol] == 0)  {
	                    vis[nrow][ncol] = 1; 
    	            q.add(new Node(nrow, ncol, steps+1));  
	            } 
	            }
	        }
	    
	    // return distance matrix
	    return dist; 
    }
}