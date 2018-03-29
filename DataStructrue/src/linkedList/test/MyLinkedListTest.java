package linkedList.test;

import linkedList.MyLinkedList;

public class MyLinkedListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		add(10);
//		removeNode(5);
//		removeNodes(4);
//		getNode(3);
//		getNodes(2);
		reverse();
//		insert();
//		clear();
	}

	private static void clear() {
		// TODO Auto-generated method stub
		MyLinkedList linkedList = add(10);
		linkedList.clear();
		linkedList.print();
	}

	private static void insert() {
		// TODO Auto-generated method stub
		MyLinkedList linkedList = add(10);
		linkedList.insert(5, linkedList.new Node(233));
		linkedList.print();
	}

	private static void reverse() {
		// TODO Auto-generated method stub
		add(10).reverse().print();
	}

	private static void getNodes(int value) {
		// TODO Auto-generated method stub
		MyLinkedList linkedList = new MyLinkedList();
		linkedList.add(linkedList.new Node(1));
		linkedList.add(linkedList.new Node(2));
		linkedList.add(linkedList.new Node(1));
		linkedList.add(linkedList.new Node(3));
		linkedList.add(linkedList.new Node(4));
		linkedList.add(linkedList.new Node(2));
		linkedList.add(linkedList.new Node(4));
		linkedList.print();
		System.out.println(linkedList.getNodes(value).size());
		linkedList.print();
	}

	private static void getNode(int index) {
		// TODO Auto-generated method stub
		MyLinkedList list = add(10);
		System.out.println(list.getNode(index).getValue());
		list.print();
	}

	private static void removeNodes(int value) {
		// TODO Auto-generated method stub
		MyLinkedList linkedList = new MyLinkedList();
		linkedList.add(linkedList.new Node(1));
		linkedList.add(linkedList.new Node(2));
		linkedList.add(linkedList.new Node(1));
		linkedList.add(linkedList.new Node(3));
		linkedList.add(linkedList.new Node(4));
		linkedList.add(linkedList.new Node(2));
		linkedList.add(linkedList.new Node(4));
		linkedList.print();
		System.out.println(linkedList.removeNodes(value).size());
		linkedList.print();
	}

	private static void removeNode(int index) {
		// TODO Auto-generated method stub
		MyLinkedList list = add(10);
		list.removeNode(index);
		list.print();
	}

	private static MyLinkedList add(int num) {
		// TODO Auto-generated method stub
		MyLinkedList linkedList = new MyLinkedList();
		for (int i = 0; i < num; i++) {
			linkedList.add(linkedList.new Node(i));
		}
		linkedList.print();
		return linkedList;
	}
	
}
