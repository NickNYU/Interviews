package hard;

import tools.AssortedMethod;
import tools.TreeNode;

public class TreeNodeSerialization {
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public static String serialize(TreeNode root) {
        // write your code here
        if(root == null)    return "#";
        StringBuffer sb = new StringBuffer();
        sb.append(root.val);
        sb.append(" ");
        sb.append(serialize(root.left)+" ");
        sb.append(serialize(root.right)+" ");
        return sb.toString();
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public static TreeNode deserialize(String data) {
        // write your code here
        String[] strs = data.split(" ");
        return helper(strs);
    }
    
    private static int index = 0;
    public static TreeNode helper(String[] strs) {
        TreeNode root = null;
        if(!strs[index].equals("#")) {
            int val = Integer.parseInt(strs[index++]);
            root = new TreeNode (val);
        }
        if(root != null) {
            root.left = helper(strs);
            root.right = helper(strs);
        }
        return root;
    }
    
    public static void main(String[] args) {
    	String[] arr = {"1","#","2"};
    	TreeNode root = AssortedMethod.createTreeWithString(arr);
    	System.out.println(root.toString());
    	String serilization = serialize(root);
    	System.out.println(serilization);
    	System.out.println(deserialize(serilization).toString());
    }
}
