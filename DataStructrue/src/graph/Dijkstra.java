package graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author wyhong
 *
 */
public class Dijkstra {

	public class Node{
		/**
		 * 节点的标识符
		 */
		private Integer identifier;
		/**
		 * 该节点是否被访问过
		 */
		private boolean visited = false;
		/**
		 * 该节点与其他节点的映射关系
		 */
		private Map<Node,Integer> mapping = new HashMap<Node,Integer>();
		
		public Integer getIdentifier() {
			return identifier;
		}
		public void setIdentifier(Integer identifier) {
			this.identifier = identifier;
		}
		public boolean isVisited() {
			return visited;
		}
		public void setVisited(boolean visited) {
			this.visited = visited;
		}
		public Map<Node, Integer> getMapping() {
			return mapping;
		}
	}
	
	/**
	 * Getting optimal path by Dijkstra algorithm
	 * @param src
	 * @param dest
	 * @return
	 */
	public static LinkedList<Node> getOptimalPath(Node src, Node dest){
		return dijkstra(src, dest, 0, 0, new LinkedList<Node>());
	}
	
	/**
	 * Dijkstra algorithm
	 * @param src 起始节点
	 * @param dest 目标节点
	 * @param adjacentDist 起始节点与目标节点相邻时的距离
	 * @param optimalDist 最短路径权值之和
	 * @param optimalPath 最短路径
	 * @return
	 */
	private static LinkedList<Node> dijkstra(Node src, Node dest, int adjacentDist, int optimalDist, LinkedList<Node> optimalPath){
		if(optimalPath.size()==0){
			optimalPath.add(src);
		}
		//当前节点与其他节点的映射关系
		Map<Node,Integer> mapping = src.getMapping();
		//当前节点与其相邻节点的最小距离
		int partialMinDist = 0;
		//当前预选的下一最优节点
		Node partialOptimalNode = null;
		Iterator<Entry<Node, Integer>> entryIterator = mapping.entrySet().iterator();
		while (entryIterator.hasNext()) {
			Entry<Node, Integer> entry = (Entry<Node, Integer>) entryIterator.next();
			Node nextNode = entry.getKey();
			//判断该相邻节点是否被访问过
			if (nextNode.isVisited()) continue;
			int dist = entry.getValue(); 
			//终点与起点相邻，但未必路径最短
			if(nextNode.getIdentifier() == dest.getIdentifier() && optimalPath.size() == 1) adjacentDist = dist;
			if (partialMinDist != 0) {
				boolean currentIsOptimal = partialMinDist > dist ? false : true;
				if(!currentIsOptimal){
					partialMinDist = dist;
					partialOptimalNode = nextNode;
				}
			}else{
				partialMinDist = dist;
				partialOptimalNode = nextNode;
			}
		}
		//设置当前节点已被访问
		src.setVisited(true);
		//加入链表
		optimalPath.add(partialOptimalNode);
		optimalDist += partialMinDist;
		if(partialOptimalNode.getIdentifier()!=dest.getIdentifier()){
			//若未到终点时当前最优路径长度已大于终点与起点相邻的距离，则最短路径为起点--->终点
			if(adjacentDist != 0 && optimalDist > adjacentDist) {
				src = optimalPath.removeFirst();
				optimalPath.clear();
				optimalPath.add(src);
				optimalPath.add(dest);
				optimalDist = adjacentDist;
				return optimalPath;
			}
			//否则以当前节点递归
			return dijkstra(partialOptimalNode, dest, adjacentDist, optimalDist, optimalPath);
		}else{
			return optimalPath;
		}
	}
}
