package lc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.w3c.dom.Node;

public class MaxDepth {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		root.right.left.left = new TreeNode(21);
		
		System.out.println(maxDepth(root));
		System.out.println(maxDepthIterative(root));
	}
	
    public static int maxDepth(TreeNode root) {
        if ( root==null)
        	return 0;
       return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
    
    static class Pair {
    	public Pair(TreeNode node, int depth) {
			super();
			this.node = node;
			this.depth = depth;
		}
		TreeNode node;
    	int depth;
    }
    
    public static int maxDepthIterative(TreeNode root) {
    	Queue<Pair> queue = new LinkedList<>();
    	if (root!=null)
    		queue.add(new Pair(root, 1));
    	int currentDepth = 0;
    	
    	while(!queue.isEmpty()) {
    		Pair pair = queue.poll();
    		currentDepth = Math.max(currentDepth, pair.depth);
    		if ( pair.node.left != null) 
    			queue.add(new Pair(pair.node.left, pair.depth+1));
    		if ( pair.node.right != null) 
    			queue.add(new Pair(pair.node.right, pair.depth+1));
    	}
    	
    	return currentDepth;
    }
}
