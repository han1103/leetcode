package lc;

public class ValidBST {
	public static boolean isValidAndMinMax(TreeNode root, Integer min, Integer max) {
		if (root.left == null && root.right == null) {
			min=root.val;
			max=root.val;
			return true;
		}
		if (root==null) {
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			return true;
		}
		Integer minLeft = Integer.MIN_VALUE;
		Integer maxLeft = Integer.MAX_VALUE;
		Integer minRight = Integer.MIN_VALUE;
		Integer maxRight = Integer.MAX_VALUE;
		boolean validLeftTree = isValidAndMinMax(root.left, minLeft, maxLeft);
		if (!validLeftTree)
			return false;
		else if (root.val < maxLeft)
			return false;		
		else {
			boolean validRightTree = isValidAndMinMax(root.right, minRight, maxRight);
			if (!validRightTree)
				return false;
			else if (root.val > maxRight)
				return false;					
		}
				
		min = minLeft;
		max = maxRight;		
		return true;
	}

    public static boolean isValidBST(TreeNode root) {
    	Integer min = Integer.MIN_VALUE;
		Integer max = Integer.MAX_VALUE;
		return isValidAndMinMax(root, min, max);
		
    }
}
