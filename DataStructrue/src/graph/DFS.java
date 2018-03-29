package graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

/**
 * Depth first search
 * @author Administrator
 *
 */
public class DFS {
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
	
	public static Stack<Node> searchByDFS(Node src, Node target) {
		return dfs(src, target, false, new Stack<Node>());
	}
	
	/**
	 * 深度优先搜索算法
	 * 从起始节点开始，判断相邻的第一个未被访问的节点，若不是目标节点，
	 * 且该节点还有未被访问的节点，则该节点入栈并递归。
	 * 局部递归结束条件：
	 * 1、若没有下一个未被访问的相邻节点，则该节点出栈
	 * 2、搜索到目标节点，该节点入栈，结束递归
	 * @param src 起始节点
	 * @param target 目标节点
	 * @param path 路径栈
	 * @return 路径栈
	 */
	public static Stack<Node> dfs(Node src, Node target, boolean isFound, Stack<Node> path){
		//未找到目标节点，起始时判断可提高性能
		if(!isFound){
			//当前节点入栈
			path.add(src);
			//遍历相邻节点
			Map<Node, Integer> mapping = src.getMapping();
			Iterator<Entry<Node, Integer>> entryIterator = mapping.entrySet().iterator();
			while (entryIterator.hasNext()) {
				//未找到目标节点
				Entry<Node, Integer> entry = (Entry<Node, Integer>) entryIterator.next();
				Node nextNode = entry.getKey();
				//判断下一节点是否在路径中
				if(!path.contains(nextNode)){
					//判断是否为目标节点
					if(nextNode.getIdentifier() == target.getIdentifier()) {
						isFound = true;
						path.add(nextNode);
						break;
					}
					//不是目标节点，且下一节点仍有相邻节点，则以nextNode作为下一递归的src
					if(nextNode.getMapping().size() != 0) {
						Stack<Node> temp = dfs(nextNode, target, isFound, path);
						if(temp == null) continue;
						return temp;
					}
				}
			}
			//没有下一个未被访问的相邻节点且未找到目标节点，当前节点出栈，回溯
			if(!isFound) {
				path.remove(src);
				return null;
			}
		}
		return path;
	}
}
