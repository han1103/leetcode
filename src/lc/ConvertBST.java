package lc;

public class ConvertBST {
	int sum = 0;
	void convertBSTRec(TreeNode root) {
		if(root==null)
			return;
		convertBSTRec(root.right);
		root.val+=sum;
		sum=root.val;
		convertBSTRec(root.left);		
	}
	
	public TreeNode convertBST(TreeNode root) {
		convertBSTRec(root);
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
