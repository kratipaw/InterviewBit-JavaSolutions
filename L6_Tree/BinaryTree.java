package L6_Tree;

public class BinaryTree {

   Node root;

   public BinaryTree() {
   }

   public BinaryTree(int data) {
	   root = new Node(data);
   }

   public Node getRoot() {
	return root;
   }
   
   public void setRoot(Node root) {
	this.root = root;
   }
  
}