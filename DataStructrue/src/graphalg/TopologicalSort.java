package graphalg;

import java.util.LinkedList;
import java.util.Queue;
//拓扑排序，确定流程执行顺序
public class TopologicalSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[][] graph = {
//				{0,0,0,0,0,0,1},
//				{1,0,0,1,0,0,0},
//				{0,0,0,0,0,1,1},
//				{0,0,0,0,1,1,0},
//				{0,0,0,0,0,0,0},
//				{0,0,0,0,0,0,0},
//				{0,0,0,0,0,0,0}
//		};
		int[][] graph = {
				{0,1,1,0},
				{0,0,0,1},
				{0,0,0,0},
				{0,0,1,0}
		};
		topologicalSort(graph);
	}

	private static void topologicalSort(int[][] graph) {
		Queue<Integer> queue = new LinkedList<Integer>();
		//所有列不全为0时
		while(queue.size() < graph.length) {
			//查找列全为0对应的节点
			for (int i = 0; i < graph[0].length; i++) {
				for (int j = 0; j < graph.length; j++) {
					if(graph[j][i] != 0) break;
					if(j == graph[i].length - 1){
						//去队列检查该节点是否已存在，不存在则入队
						if(!queue.contains(i)){
							queue.add(i);
						}
					}
				}
			}
			//列全为0的节点对应的行置0
			for (Integer i : queue) {
				for (int k = 0; k < graph[0].length; k++) {
					if(graph[i][k] != 0) graph[i][k] = 0;
				}
			}
		}
		//所有列全为0，打印队列
		for (Integer integer : queue) {
			System.out.printf("%s-->",(char)(integer + 65));
		}
	}

}
