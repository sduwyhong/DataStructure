package graph.test;

import graph.BFS;
import graph.BFS.Node;
import graph.DFS;

import java.util.Iterator;
import java.util.Stack;

public class BFSTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BFS bfs = new BFS();
		BFS.Node node_1 = bfs.new Node();
		BFS.Node node_2 = bfs.new Node();
		BFS.Node node_3 = bfs.new Node();
		BFS.Node node_4 = bfs.new Node();
		BFS.Node node_5 = bfs.new Node();
		BFS.Node node_6 = bfs.new Node();
		
		node_1.setIdentifier(1);
		node_1.getMapping().put(node_2, 7);
		node_1.getMapping().put(node_3, 9);
		node_1.getMapping().put(node_6, 14);
		
		node_2.setIdentifier(2);
		node_2.getMapping().put(node_1, 7);
		node_2.getMapping().put(node_3, 10);
		node_2.getMapping().put(node_4, 15);
		
		node_3.setIdentifier(3);
		node_3.getMapping().put(node_1,7);
		node_3.getMapping().put(node_2,10);
		node_3.getMapping().put(node_4,11);
		node_3.getMapping().put(node_6,2);
		
		node_4.setIdentifier(4);
		node_4.getMapping().put(node_3, 11);
		node_4.getMapping().put(node_2, 15);
		node_4.getMapping().put(node_5, 6);
		
		node_5.setIdentifier(5);
		node_5.getMapping().put(node_4, 6);
		node_5.getMapping().put(node_6, 9);
		
		node_6.setIdentifier(6);
		node_6.getMapping().put(node_5, 9);
		node_6.getMapping().put(node_1, 14);
		
		Stack<Node> path = BFS.searchByBFS(node_2, node_6);
		System.out.println("-------The BFS path--------");
		for (Iterator<Node> iterator = path.iterator(); iterator.hasNext();) {
			Node node = (Node) iterator.next();
			if (iterator.hasNext()) {
				System.out.print(node.getIdentifier()+"-->");
			}else{
				System.out.print(node.getIdentifier());
			}
		}
	}

}
