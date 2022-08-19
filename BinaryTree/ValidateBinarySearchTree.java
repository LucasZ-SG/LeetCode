package BinaryTree;
public class ValidateBinarySearchTree {

    public Integer prev = null;
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        try {
            traverse(root);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void traverse(TreeNode root) throws Exception {
        if(root.left != null){
            traverse(root.left);
        }
        if(prev == null){
            prev = root.val;
        }else{
            if(root.val < prev){
                throw new Exception();
            }
            prev = root.val;
        }

        if(root.right != null){
            traverse(root.right);
        }
    }
}
