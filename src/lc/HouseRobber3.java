package lc;

public class HouseRobber3 {

	public int robWithParent(TreeNode root, boolean havingParent) {
		if (root==null)
			return 0;
		if (havingParent) {
			return robWithParent(root.left, false) + robWithParent(root.right, false); 
		}
		else {
			return Math.max(root.val+ robWithParent(root.left, true) + robWithParent(root.right, true), robWithParent(root.left, false) + robWithParent(root.right, false));
		}
	}

	public int[] robWithParentDFS(TreeNode root) {
		int[] res = new int[2];
		
		if (root==null)
			return res;
		
		int[] left = robWithParentDFS(root.left);
		int[] right = robWithParentDFS(root.right);
		
		res[0] = left[1] + right[1];
		res[1] = Math.max(root.val + left[0] + right[0], res[0]);
		
		return res;
	}

	public int rob(TreeNode root) {
		//return robWithParent(root, false);
		return Math.max(robWithSelf(root, false), robWithSelf(root, true));
	}

	int robWithSelf(TreeNode root, boolean robSelf) {
		if(root==null)
			return 0;
		if(robSelf)
			return root.val+robWithSelf(root.left, false)+robWithSelf(root.right, false);
		else
			return Math.max(robWithSelf(root.left, true), robWithSelf(root.left, false))+
					Math.max(robWithSelf(root.right, true), robWithSelf(root.right, false));
	}

	int[] robWithSelfDFS(TreeNode root) {
		int[] res = new int[2];
		
		if(root==null)
			return res;
		int[] left = robWithSelfDFS(root.left);
		int[] right = robWithSelfDFS(root.right);
		
		res[0]=root.val + left[1] + right[1];
		res[1]=Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		
		return res;
	}
	
	int robWithoutSelf(TreeNode root, boolean robWithoutSelf) {
		if(root==null)
			return 0;
		if(robWithoutSelf)
			return robWithoutSelf(root.left, false)+robWithoutSelf(root.right, false);
		else
			return Math.max(root.val+robWithoutSelf(root.left, true)+robWithoutSelf(root.right, true), 
					robWithoutSelf(root.left, false)+robWithoutSelf(root.right, false));
	}
	
    int[] robDFS(TreeNode node){
        int [] res = new int[2];
        if(node==null) return res;
        int [] l = robDFS(node.left);
        int [] r = robDFS(node.right);
        res[0] = l[1] + r[1];
        res[1] = Math.max(res[0], l[0] + r[0] + node.val);
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}