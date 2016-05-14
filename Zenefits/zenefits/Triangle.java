package zenefits;

public class Triangle {

	public static int numOfTriangle (int[][] adj) {
		if(adj == null || adj.length < 3)        return 0;

		return countTriangles(adj);                
       }

	public static int countTriangles(int[][] adj) {
		int num = 0; 
        for(int i = 0; i < adj.length - 2; ++i) {
        	for(int j = i + 1; j < adj.length - 1; ++j) {
        		if(adj[i][j] == 1) {
	        		for(int k = j + 1; k < adj.length; ++k) {
	        			if(adj[i][j] == 1 && adj[j][k] == 1 && adj[k][i] == 1) {
	        				++num;
	        			}
	        		}
        		}
        	}
        }

        return num;
	}
	
	public static void main(String[] args) {
		int[][] adj = {
				{1, 0, 1, 1}, 
				{1, 1, 0, 1}, 
				{0, 0, 0, 0}, 
				{0, 0, 0, 0}
		};
		
		System.out.println(numOfTriangle(adj));
	}

}
