package treeDemo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

import treeDomain.BinaryTree;


public class binaryTreeDemo2 {
	public static void main(String[] args){
		int[] values = {1,2,3,4,5,6,7,8,9,10};
		BinaryTree btree = new BinaryTree();
		btree.setRoot(btree.createBTree(btree.getRoot(), values, 0));
		System.out.println("preorderTraversal");
		btree.preorderTraversal(btree.getRoot());
		System.out.println();
		System.out.println("inorderTraversal");
		btree.inorderTraversal(btree.getRoot());
		System.out.println();
		System.out.println("postorderTraversal");
		btree.postorderTraversal(btree.getRoot());
		System.out.println();
		System.out.println("height");
		System.out.println(BinaryTree.getHeight(btree));
		System.out.println("searchByValue");
		System.out.println(btree.searchByValue(btree.getRoot(), 5, new ArrayList<BinaryTree.TreeNode>()));
		
	}
}
