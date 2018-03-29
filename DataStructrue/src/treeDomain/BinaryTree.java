package treeDomain;

import java.util.List;


public class BinaryTree {

	private TreeNode root;
	private int size;
	public BinaryTree() {
		this.root = null;
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	//内部类
	public class TreeNode{

		private int value;
		private TreeNode leftChild;
		private TreeNode rightChild;
		private TreeNode parent;
		public TreeNode(TreeNode parent){
			this.parent = parent;
		};
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
	//思想：每个节点的任务是为自己赋值然后创建左右孩子
	//每次方法调用的返回值为参数中的root经过处理后的节点
	public TreeNode createBTree(TreeNode root, int[] values, int i){
		//递归结束条件
		if(i>values.length-1){
			return null;
		}
		root = new TreeNode(values[i]);
		this.setSize(this.getSize()+1);
		root.setLeftChild(createBTree(new TreeNode(root),values,2*i+1));
		root.setRightChild(createBTree(new TreeNode(root),values,2*i+2));
		return root;
	}
	//前序遍历
	public void preorderTraversal(TreeNode root){
		if(root!=null){
			System.out.print(root.getValue());
			preorderTraversal(root.getLeftChild());
			preorderTraversal(root.getRightChild());
		}
	}
	//中序遍历
	public void inorderTraversal(TreeNode root){
		if(root!=null){
			inorderTraversal(root.getLeftChild());
			System.out.print(root.getValue());
			inorderTraversal(root.getRightChild());
		}
	}
	//后序遍历
	public void postorderTraversal(TreeNode root){
		if(root!=null){
			postorderTraversal(root.getLeftChild());
			postorderTraversal(root.getRightChild());
			System.out.print(root.getValue());
		}
	}
	//按节点值查找节点
	public List<TreeNode> searchByValue(TreeNode root, int value, List<BinaryTree.TreeNode> nodes){
		if(root!=null){
			if(root.getValue()==value){
				nodes.add(root);
			}
			searchByValue(root.getLeftChild(),value,nodes);
			searchByValue(root.getRightChild(),value,nodes);
		}
		return nodes;
	}
	//计算树的高度
	public static int getHeight(BinaryTree btree){
		int size = btree.getSize();
		for(int i=1;;i++){
			if(size<=Math.pow(2,i)-1){
				return i;
			}
		}
	}
}
