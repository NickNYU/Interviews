package zenefits;

public class FixedKTree {
	
	public static boolean isExist(TreeNode root, int k) {
		BSTReverseInorderIterator reverseIterator = new BSTReverseInorderIterator(root);
		BSTInorderIterator iterator = new BSTInorderIterator(root);
		
		int left = iterator.next().val, right = reverseIterator.next().val;
		
		while(reverseIterator.hasNext() && iterator.hasNext()) {
			int total = left + right;
			
			if(total < k) {
				left = iterator.next().val;
			} else if(total > k) {
				right = reverseIterator.next().val;
			} else {
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(15);
        TreeNode n2 = new TreeNode(10);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(8);
        TreeNode n5 = new TreeNode(12);
        TreeNode n6 = new TreeNode(16);
        TreeNode n7 = new TreeNode(25);
        n1.left = n2;	n1.right = n3;
        n2.left = n4;	n2.right = n5;
        n3.left = n6;	n3.right = n7;
        
        for(int i = 18; i <= 45; i++)
        	System.out.println(i +"  "+ isExist(n1, i));
	}
}
