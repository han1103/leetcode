package lc;

public class DiameterOfBinaryTree {
	int depth;
	int diameter=0;
	int dia = 0;
	
	int findDepth(TreeNode root) {
		if(root==null)
			return 0;
		int l = findDepth(root.left);
		int r = findDepth(root.right);
		dia = Math.max(dia, l+r);
		
		return Math.max(l, r)+1;
	}
		
	void depthOfTreeRec(TreeNode root, int prevDepth) {
		if(root==null) {
			depth = Math.max(prevDepth, depth);
			return;
		}
		prevDepth++;
		depthOfTreeRec(root.left, prevDepth);
		depthOfTreeRec(root.right, prevDepth);
		
	}
	int depthOfTree(TreeNode root) {
		depth = 0;
		depthOfTreeRec(root, 0);
		return depth;
	}
	
	void diameterRec(TreeNode root) {
		if(root==null)
			return;
		int depthOfLeft = depthOfTree(root.left);
		int depthOfRight = depthOfTree(root.right);
		diameter = Math.max(diameter, depthOfRight+depthOfLeft);
		diameterRec(root.left);
		diameterRec(root.right);
	}
	
	public int diameterOfBinaryTree(TreeNode root) {
/*		diameterRec(root);
		return diameter;
*/
		findDepth(root);
		return dia;
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		root.left.right.right = new TreeNode(6);
		root.left.right.right.right = new TreeNode(7);
		
		root.left.left.left = new TreeNode(8);
		
		root.left.left.left.left = new TreeNode(9);
		
		//System.out.println(new DiameterOfBinaryTree().depthOfTree(root.left.left));
		//System.out.println(new DiameterOfBinaryTree().depthOfTree(root.left.right));
		DiameterOfBinaryTree tree = new DiameterOfBinaryTree();
		System.out.println(tree.diameterOfBinaryTree(root));
		System.out.println("");
	}

}
