package treeDomain;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

	private TreeNode root;//根节点
	//	public static List<TreeNode> treeNodes = new ArrayList<TreeNode>();//节点
	//	private int height;//高度

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}
	private class TreeNode{

		private int value;
		private TreeNode leftChild;
		private TreeNode rightChild;
		public TreeNode(int value) {
			super();
			this.value = value;
			this.leftChild = null;
			this.rightChild = null;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public TreeNode getLeftChild() {
			return leftChild;
		}
		public void setLeftChild(TreeNode leftChild) {
			this.leftChild = leftChild;
		}
		public TreeNode getRightChild() {
			return rightChild;
		}
		public void setRightChild(TreeNode rightChild) {
			this.rightChild = rightChild;
		}
	}

	public void createBSTree(TreeNode root, int value, BinarySearchTree btree){
		if(root==null){
			root = new TreeNode(value);
			btree.setRoot(root);
		}else{
			if(value<root.value){

				if(root.leftChild==null){
					root.leftChild = new TreeNode(value);
				}else{
					createBSTree(root.leftChild,value, btree);
				}
			}else{
				if(root.rightChild==null){
					root.rightChild = new TreeNode(value);
				}else{
					createBSTree(root.rightChild,value, btree);
				}
			}
		}
	}



	public void levelOrderTraversal(BinarySearchTree btree){

	}

	public void preorderTraversal(TreeNode root){
		if(root!=null){
			System.out.print(root.value);
			preorderTraversal(root.leftChild);
			preorderTraversal(root.rightChild);
		}

	}
	public void inorderTraversal(TreeNode root){
		if(root!=null){
			inorderTraversal(root.leftChild);
			System.out.print(root.value);
			inorderTraversal(root.rightChild);
		}
	}
	public void postorderTraversal(TreeNode root){
		if(root!=null){
			postorderTraversal(root.leftChild);
			postorderTraversal(root.rightChild);
			System.out.print(root.value);
		}
	}
}
