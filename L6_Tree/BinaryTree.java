public class BinaryTree {

	TreeNode root;

   public BinaryTree() {
   }

   public BinaryTree(int data) {
	   root = new TreeNode(data);
   }

   public TreeNode getRoot() {
	return root;
   }
   
   public void setRoot(TreeNode root) {
	this.root = root;
   }
  
}