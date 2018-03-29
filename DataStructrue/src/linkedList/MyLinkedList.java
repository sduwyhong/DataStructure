package linkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import linkedList.exception.IllegalIndexException;

/**
 * @author wyhong
 *
 */
public class MyLinkedList {

	/**
	 * the size of the linked list
	 */
	private int size;
	/**
	 * a pointer which records the current node while manipulating the linked list 
	 */
	private Node pointer;
	/**
	 *  the first node of the linked list
	 */
	private Node head;
	/**
	 * the last node of the linked list
	 */
	private Node tail;

	public int size() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public class Node{

		public Node(int _value) {
			super();
			this.next = null;
			this.value = _value;
		}
		public Node() {
			// TODO Auto-generated constructor stub
		}
		/**
		 * the next node of this node
		 */
		private Node next;
		/**
		 * the value of the node 
		 */
		private int value;

		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
	}

	/**
	 * add a new node to the linked list
	 * @param newNode the node to be added
	 */
	public void add(Node newNode) {
		if (this.size() == 0) {
			head = newNode;
			tail = newNode;
		}else {
			tail.setNext(newNode); 
			tail = newNode;
		}
		this.setSize(this.size() + 1);
	}

	public List<Node> removeNodes(int value) {
		return _remove(value, new ArrayList<Node>());
	}


	/**
	 * remove nodes by a specified
	 * @param value nodes whose values equal to the parameter are to remove
	 * @param targets a container stores the removed nodes
	 * @return removed nodes
	 */
	public List<Node> _remove(int value, List<Node> targets) {
		if (this.size() == 1) {
			if(head.getValue() == value) {
				targets.add(head);
				head = tail = null;
				this.setSize(0);
			}else {
				return null;
			}
		}else {
			if (head.getValue() != value) {
				pointer = head;
				while (pointer.getNext() != null && pointer.getNext().getValue() != value) {
					pointer = pointer.getNext();
				}
				if (pointer.getNext() == null) {
					if (targets.size() == 0) {
						System.out.println("the target node doesn't exist!");
					}
				}else {
					targets.add(pointer.getNext());
					if (tail == pointer.getNext()) {
						tail = pointer;
						pointer.setNext(null);
						return targets;
					}
					pointer.setNext(pointer.getNext().getNext());
					_remove(value, targets);
				}
			}else {
				targets.add(head);
				head = head.getNext();
				_remove(value, targets);
			}
		}
		return targets;
	}

	/**
	 * remove a node by a specified index
	 * @param index remove the node according to the specified index, note that the index begin with 1
	 * @return the node to be removed if it exists
	 */
	public Node removeNode(int index) {
		if (index < 1 || index > this.size()) {
			try {
				throw new IllegalIndexException("the index's out of boundary");
			} catch (IllegalIndexException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				return null;
			}
		}
		Node tempNode = null;
		if (index == 1) {
			tempNode = head; 
			if (this.size() == 1){
				tail = null;
			}
			head = head.getNext();
			this.setSize(this.size() - 1);
		}else if (index == this.size()) {
			pointer = head;
			while (pointer.getNext() != tail) {
				pointer = pointer.getNext();
			}
			pointer.setNext(null);
			tempNode = tail;
			tail = pointer;
		}else {
			int pointerIndex = 1;
			pointer = head;
			while (pointerIndex < index - 1) {
				pointer = pointer.getNext();
				pointerIndex++;
			}
			tempNode = pointer.getNext();
			pointer.setNext(pointer.getNext().getNext());
		}
		return tempNode;
	}

	/**
	 * get a node by a specified index
	 * @param index get node by this index
	 * @return target node
	 */
	public Node getNode(int index) {
		if (index < 1 || index > this.size()) {
			try {
				throw new IllegalIndexException("Exception: the index's out of boundary!");
			} catch (IllegalIndexException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				return null;
			}
		}
		if (index == 1) {
			return head;
		}else if (index == this.size()) {
			return tail;
		}else {
			int pointerIndex = 1;
			pointer = head;
			while (pointerIndex < index) {
				pointer = pointer.getNext();
				pointerIndex++;
			}
			return pointer;
		}
	}

	/**
	 * get nodes by a value
	 * @param value get nodes by this value
	 * @return target nodes that hold the value
	 */
	public List<Node> getNodes(int value) {
		return _getNodes(value, new ArrayList<Node>(), null);
	}

	public List<Node> _getNodes(int value, List<Node> targets, Node _pointer) {
		if (_pointer == null) {
			_pointer = head;
		}
		if (this.size() == 1) {
			if(head.getValue() == value) {
				targets.add(head);
			}
		}else {
			if (_pointer.getValue() != value) {
				while (_pointer.getNext() != null && _pointer.getValue() != value) {
					_pointer = _pointer.getNext();
				}
				if (_pointer.getNext() == null && _pointer.getValue() != value) {
					if (targets.size() == 0) {
						System.out.println("Target node doesn't exist!");
					}
				}else {
					targets.add(_pointer);
					if (_pointer.getNext() != null ) {
						_getNodes(value, targets, _pointer.getNext());
					}
				}
			}else {
				targets.add(head);
				_getNodes(value, targets, head.getNext());
			}
		}
		return targets;
	}

	/**
	 * reverse a linkedlist and return a new one
	 * @return a new LinkedList that is already reversed
	 */
	public MyLinkedList reverse() {
		if (this.isEmpty()) {
			System.out.println("the empty linked list leads to a failure of reversion");
			return this;
		}
		Stack<Node> stack = new Stack<Node>();
		pointer = head;
		while (pointer != null) {
			stack.push(pointer);
			pointer = pointer.getNext();
		}
		MyLinkedList temp = new MyLinkedList();
		while (stack.size() > 0) {
			Node node = stack.pop();
			//Original mappings have to be reset 
			node.setNext(null);
			temp.add(node);
		}
		return temp;
	}

	/**
	 * insert a node into the linkedlist
	 * @param index insert into this index which starts from 1
	 * @param node node to be inserted
	 * @return
	 */
	public boolean insert(int index, Node node) {
		if (index < 1 || index > this.size()) {
			try {
				throw new IllegalIndexException("Exception: the index's out of boundary!");
			} catch (IllegalIndexException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				return false;
			}
		}
		if (index == 1) {
			node.setNext(head.getNext()); 
			head = node;
		}else if (index == this.size()) {
			tail.setNext(node);
			tail = node;
		}else {
			int pointerIndex = 1;
			pointer = head;
			while (pointerIndex < index - 1) {
				pointer = pointer.getNext();
				pointerIndex++;
			}
			node.setNext(pointer.getNext());
			pointer.setNext(node);
		}
		return true;
	}

	/**
	 * print a linkedlist formattedly
	 */
	public void print() {
		if (this.isEmpty()) {
			System.out.println("The linked list is empty!");
		}else if (this.size() == 1) {
			System.out.println(head.getValue());
		}else {
			pointer = head;
			while (pointer != null) {
				if (pointer != tail) System.out.print(pointer.getValue()+"-->");
				else System.out.println(pointer.getValue());
				pointer = pointer.getNext();
			}
		}
	}
	
	/**
	 * get the first node of a linkedlist
	 * @return the first node of a linkedlist
	 */
	public Node getFirst() {
		return getNode(1);
	}
	
	/**
	 * get the last node of a linkedlist
	 * @return the last node of a linkedlist
	 */
	public Node getLast() {
		return getNode(this.size());
	}
	
	/**
	 * remove the first node of a linkedlist
	 * @return the first node of a linkedlist, which is already removed
	 */
	public Node removeFirst() {
		return removeNode(0);
	}
	
	/**
	 * remove the last node of a linkedlist
	 * @return the last node of a linkedlist, which is already removed
	 */
	public Node removeLast() {
		return removeNode(this.size());
	}
	
	/**
	 * clear the linkedlist
	 */
	public void clear() {
		head = tail = null;
		this.setSize(0);
	}
	
	/**
	 * To check if a linkedlist have any nodes
	 * @return
	 */
	private boolean isEmpty() {
		// TODO Auto-generated method stub
		if (this.size() == 0) {
			return true;
		}
		return false;
	}
}
