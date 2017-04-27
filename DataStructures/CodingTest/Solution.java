package CodingTest;

public class Solution {
	
	Solution() {}
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    public static int minDepth(TreeNode root) {
    	if (root == null) return 0;
    	TreeNode current = root;
    	System.out.println(current.val);
    	if ((current.left == null) && (current.right == null)) return 1;
    	int l = minDepth(current.left);
    	int r = minDepth(current.right);
    	if(l == 0) return r+1;
    	if(r == 0) return l+1;
    	if (r < l) {
    		return r+1;
    	} else {
    		return l+1;
    	}
    }
    
    public static void main(String...strings) {
    	TreeNode n1 = new TreeNode(20);
    	TreeNode n2 = new TreeNode(10);
    	n1.left = n2;
    	TreeNode n3 = new TreeNode(30);
    	n2.right = n3;
    	System.out.println(minDepth(n1));
    }
}