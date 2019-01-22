package medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
	List<Integer> spiralOrderRec(int[][] matrix, int startR, int endR, int startC, int endC) {
		List<Integer> retList = new ArrayList<>();
		if(startR==endR)
			for(int i=startC; i<=endC; i++)
				retList.add(matrix[startR][i]);
		else if(startC==endC) 
			for(int i=startR; i<=endR; i++)
				retList.add(matrix[i][startC]);
		else {
			for(int i=startC; i<=endC; i++)
				retList.add(matrix[startR][i]);
			for(int i=startR+1; i<=endR; i++)
				retList.add(matrix[i][endC]);
			for(int i=endC-1; i>=startC; i--)
				retList.add(matrix[endR][i]);
			for(int i=endR-1; i>startR; i--)
				retList.add(matrix[i][startC]);
			
			if(startR<endR-1 && startC<endC-1)
				retList.addAll(spiralOrderRec(matrix, startR+1, endR-1, startC+1, endC-1));
		}
		
		return retList;
	}
	
	public List<Integer> spiralOrder(int[][] matrix) {
		if(matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0)
			return new ArrayList<>();
		
		return spiralOrderRec(matrix, 0, matrix.length-1, 0, matrix[0].length-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new SpiralOrder().spiralOrder(new int[][]
				{
/*			{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}*/
			{ 1, 2, 3 },
			{ 4, 5, 6 },
			{ 7, 8, 9 }
				/*{1, 2, 3, 4},
				  {5, 6, 7, 8},
				  {9,10,11,12}*/
				}
				);

		for(int num : list)
			System.out.print(num+",");
	}

}
