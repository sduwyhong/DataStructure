package graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

public class BFS {
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
	public static Stack<Node> searchByBFS(Node src, Node target) {
		// TODO Auto-generated method stub
		return bfs(src, target, false, new Stack<Node>());
	}
	/**
	 * 广度优先搜索
	 * 遍历起点的所有相邻节点，若无目标节点，选择一个节点为起点继续递归搜索
	 * 若已无未被访问过的相邻节点，则结束本次递归，该节点出栈
	 * @param src 起点
	 * @param target 目标节点
	 * @param isFound 是否已搜索到
	 * @param path 记录路径
	 * @return 路径栈
	 */
	public static Stack<Node> bfs(Node src, Node target, boolean isFound, Stack<Node> path) {
		if(!isFound) {
			path.add(src);
			Map<Node, Integer> mapping = src.getMapping();
			Iterator<Entry<Node, Integer>> entryIterator = mapping.entrySet().iterator();
			while (entryIterator.hasNext()) {
				Map.Entry<Node, Integer> entry = (Map.Entry<Node, Integer>) entryIterator.next();
				Node nextNode = entry.getKey();
				if (nextNode.getIdentifier() == target.getIdentifier()) {
					isFound = true;
					path.add(nextNode);
					return path;
				}
			}
			//在src的相邻节点中未找到target，则选择一个相邻节点作为src开始递归
			entryIterator = mapping.entrySet().iterator();
			while (entryIterator.hasNext()) {
				Map.Entry<Node, Integer> entry = (Map.Entry<Node, Integer>) entryIterator.next();
				Node nextNode = entry.getKey();
				if(!path.contains(nextNode) && nextNode.getMapping().size() != 0) {
					Stack<Node> temp = bfs(nextNode, target, isFound, path);
					if(temp == null) {
						continue;
					}
					return temp;
				}
			}
			if(!isFound) {
				path.remove(src);
				return null;
			}
		}
		return path;
	}
}
