package lc;

import java.util.ArrayList;
import java.util.List;

public class SearchMatrix {
	public boolean searchMatrixMine(int[][] matrix, int target) {
		List<Integer> containingRows = new ArrayList<>();
		List<Integer> containingCols = new ArrayList<>();
		
		int numOfRows = matrix.length;
		int numOfCols = matrix[0].length;
		
		for(int i=0; i<numOfRows; i++)
			if (matrix[i][0] <= target && matrix[i][numOfCols-1] >= target)
				containingRows.add(i);
		
		for(int j=0; j<numOfCols; j++)
			if (matrix[0][j] <= target && matrix[numOfRows-1][j] >= target)
				containingCols.add(j);
			
		boolean iteratingRow = true;
		if (containingRows.size() > containingCols.size())
			iteratingRow = false;
		
		if(iteratingRow) {
			for(int i:containingRows) {
				int start = 0, end = containingCols.size()-1;
								
				while(start<end) {
					int mid = (start+end)/2;
					if(matrix[i][containingCols.get(mid)]==target)
						return true;
					else if(matrix[i][containingCols.get(mid)]>target) {
						end = mid;
					}
					else {
						start = mid+1;
					}											
				}
				if (matrix[i][containingCols.get(start)]==target)
					return true;
			}
		}
		else {
			for(int j:containingCols) {
				int start = 0, end = containingRows.size()-1;
								
				while(start<end) {
					int mid = (start+end)/2;
					if(matrix[containingRows.get(mid)][j]==target)
						return true;
					else if(matrix[containingRows.get(mid)][j]>target) {
						end = mid;
					}
					else {
						start = mid+1;
					}											
				}
				if (matrix[containingRows.get(start)][j]==target)
					return true;
			}
		}
		
		
		
		return false;
	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix==null || matrix.length==0 || matrix[0].length==0)
			return false;
		
		return searchMatrixMine(matrix, target); 
	}
	
	public static void main(String[] args) {
		System.out.println(new SearchMatrix().searchMatrix(new int[][] {
				 {1,   4,  7, 11, 15},
				 {2,   5,  8, 12, 19},
				 {3,   6,  9, 16, 22},
				 {10, 13, 14, 17, 24},
				 {18, 21, 23, 26, 30}
		},
				21));
	}
}
