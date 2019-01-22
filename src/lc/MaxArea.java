package lc;

public class MaxArea {

	int[] height;
	
	int maxAreaRecCool(int i) {
		if(i==0)
			return 0;
		if(i==1)
			return Math.min(height[1], height[0]);
		int preArea = maxAreaRecCool(i-1);
		
		int highest = 0;
		for(int j=i-1; j>=0; j--) {
			highest = Math.max(highest, height[j]);
			if (highest > height[i]) {
				return Math.max(preArea, height[i]*(i-j));
			}			
		}
				
		return Math.max(preArea, highest*i);
	}
	
	int maxAreaRec(int i) {
		if(i==0)
			return 0;
		if(i==1)
			return Math.abs(height[1]-height[0]);
		int area = maxAreaRec(i-1);
	
		for(int j=0; j<i; j++) {
			area = Math.max(area, Math.min(height[i], height[j])*(i-j));
		}
		
		return area;
	}
	
	public int maxArea(int[] height) {
		if(height==null || height.length<2)
			return 0;
		
		this.height = height;
		
		return maxAreaRec(height.length-1);
	}
	
	public static void main(String[] args) {
		System.out.println(new MaxArea().maxArea(new int[] {1,8,6,2,5,4,8,3,7}));

	}

}
