package lc;

public class MinPathSum {

	int[][] grid;
	int numOfRows;
	int numOfCols;
	int min = Integer.MAX_VALUE;
	
	void minPathSumRec(int i, int j, int sumSoFar) {
		sumSoFar+=grid[i][j];
		if(sumSoFar >= min)
			return;
		if(i==numOfRows-1 && j==numOfCols-1) {
			min = Math.min(min, sumSoFar);
			return;
		}
		if(i==numOfRows-1) {
			for(int k=j+1; k<numOfCols; k++) {
				sumSoFar+=grid[i][k];
				if(sumSoFar >= min)
					return;
			}
			min = Math.min(min, sumSoFar);
			return;			
		}
		if(j==numOfCols-1) {
			for(int k=i+1; k<numOfRows; k++) {
				sumSoFar+=grid[k][j];
				if(sumSoFar >= min)
					return;
			}
			min = Math.min(min, sumSoFar);
			return;			
		}
		
		if(i<numOfRows-1)
			minPathSumRec(i+1, j, sumSoFar);
		if(j<numOfCols-1)
			minPathSumRec(i, j+1, sumSoFar);
		
	}
	
	public int minPathSum(int[][] grid) {
		this.grid = grid;
		numOfRows = grid.length;
		numOfCols = grid[0].length;
		
		minPathSumRec(0,0,0);
		
		return min;
	}

	public int minPathSumItr(int[][] grid) {
		numOfRows = grid.length;
		numOfCols = grid[0].length;
		
		for(int i=0; i<numOfRows; i++)
			for(int j=0; j<numOfCols; j++) {
				if(i==0 && j==0) {					
				}
				else if(i==0) {
					grid[i][j]+=grid[i][j-1];
				}
				else if(j==0) {
					grid[i][j]+=grid[i-1][j];
				}
				else {
					grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
				}
			}
				
		return grid[numOfRows-1][numOfCols-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new MinPathSum().minPathSumItr(new int[][]
				{
			{1,3,1},
			{1,5,1},
			{4,2,1}
				}
				));

	}

}
