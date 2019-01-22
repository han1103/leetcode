package lc;

import java.util.ArrayList;
import java.util.List;

public class BuildTree {
	public TreeNode buildTreeRec(List<Integer> preorderList, List<Integer> inorderList) {
		Integer rootValue = preorderList.remove(0);
		TreeNode root = new TreeNode(rootValue);
		if (preorderList.size() != 0) {
			int index = inorderList.indexOf(rootValue);
			if (index==-1)
				throw new RuntimeException("Impossible");
			if (index != 0)
				root.left = buildTreeRec(preorderList, inorderList.subList(0, index));
			if (index != inorderList.size() - 1)
				root.right = buildTreeRec(preorderList, inorderList.subList(index + 1, inorderList.size()));
		}

		return root;
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length == 0)
			return null;

		List<Integer> preorderList = new ArrayList<>();
		for (int preI : preorder)
			preorderList.add(preI);
		List<Integer> inorderList = new ArrayList<>();
		for (int inI : inorder)
			inorderList.add(inI);

		return buildTreeRec(preorderList, inorderList);
	}
	
	public static void main(String[] args) {
		TreeNode root = new BuildTree().buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
		
		System.out.println("Don");
	}
}
