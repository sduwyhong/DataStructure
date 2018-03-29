package graph.test;

import graph.Dijkstra;
import graph.Dijkstra.Node;

import java.util.Iterator;
import java.util.LinkedList;

public class DijkstraTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dijkstra dijkstra = new Dijkstra();
		Dijkstra.Node node_1 = dijkstra.new Node();
		Dijkstra.Node node_2 = dijkstra.new Node();
		Dijkstra.Node node_3 = dijkstra.new Node();
		Dijkstra.Node node_4 = dijkstra.new Node();
		Dijkstra.Node node_5 = dijkstra.new Node();
		Dijkstra.Node node_6 = dijkstra.new Node();
		
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
		
		LinkedList<Node> optimalPath = Dijkstra.getOptimalPath(node_1, node_5);
		System.out.println("-------The optimal path--------");
		for (Iterator<Node> iterator = optimalPath.iterator(); iterator.hasNext();) {
			Node node = (Node) iterator.next();
			if (iterator.hasNext()) {
				System.out.print(node.getIdentifier()+"-->");
			}else{
				System.out.print(node.getIdentifier());
			}
		}
	}

}
