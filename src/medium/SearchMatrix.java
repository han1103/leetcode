package medium;

public class SearchMatrix {

	class Coordinate {
		public Coordinate(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		int i;
		int j;
	};
	
	Coordinate findCoordinate(int index, int numCols) {
		return new Coordinate(index/numCols, index%numCols);
	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0)
			return false;
		
		int numCols = matrix[0].length;
		if(matrix[0][0] > target || matrix[matrix.length-1][numCols-1]<target)
			return false;
						
		int start = 0;
		int end = matrix.length*matrix[0].length-1;		
		while(end>start+1) {
			int middle = (start+end)/2;
			Coordinate cor = findCoordinate(middle, numCols);
			if(matrix[cor.i][cor.j]==target)
				return true;
			else if (matrix[cor.i][cor.j]>target)
				end = middle;
			else
				start = middle;			
		}
		
		//start==end or start+1==end
		Coordinate cor = findCoordinate(start, numCols);
		if(matrix[cor.i][cor.j]==target)
			return true;
		else {
			cor = findCoordinate(end, numCols);
			if(matrix[cor.i][cor.j]==target)
				return true;
			else
				return false;
		}
			
 	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] matrix = {
				{1,   3,  5,  7},
				  {10, 11, 16, 20},
				  {23, 30, 34, 50}		
		};
		
		System.out.println(new SearchMatrix().searchMatrix(matrix, 23));

	}
}
