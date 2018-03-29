package graphalg;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
//最小生成树Krustal算法
public class Kruskal {

	final static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int[][] graph = {
				{0  ,12 ,INF,INF,INF,16 ,14 },
				{12 ,0  ,10 ,INF,INF,7  ,INF},
				{INF,10 ,0  ,3  ,5  ,6  ,INF},
				{INF,INF,3  ,0  ,4  ,INF,INF},
				{INF,INF,5  ,4  ,0  ,2  ,8  },
				{16 ,7  ,6  ,INF,2  ,0  ,9  },
				{14 ,INF,INF,INF,8  ,9  ,0  }
		};
//		long start = System.currentTimeMillis();
		kruskal(graph);
//		System.out.printf("cost:%dms",System.currentTimeMillis() - start);
	}
	//Kruskal最小生成树算法（3步）
	private static void kruskal(int[][] graph) {
		//键不重复，若put重复的键，原key对应的value被覆写
		Map<GNode, GNode> edges = new LinkedHashMap<GNode, GNode>();
		//临界条件：包含所有节点
		while(!containsAll(edges, graph.length)){
			//当前图未被访问的最小边
			int min = 0;
			//最小边的一端
			int _i = 0;
			//最小边的另一端
			int _j = 0;
			for (int i = 0; i < graph.length; i++) {
				//只用遍历上三角矩阵
				for (int j = i + 1; j < graph[i].length; j++) {
					if(min == 0) {
						min = graph[i][j];
						_i = i;
						_j = j;
						continue;
					}
					if(graph[i][j] < min){
						min = graph[i][j];
						_i = i;
						_j = j;
					}
				}
			}
			//			System.out.printf("%d->%d,min:%d\n", _i, _j, min);
			//是否构成回路
			if(!isLoop(edges, _i, _j)) {
				edges.put(new GNode(_i), new GNode(_j));
				System.out.printf("put:{%d,%d}\n",_i,_j);
			}
			//屏蔽处理过的边
			graph[_i][_j] = graph[_j][_i] = INF;
		}

		printResult(edges);

	}
	//是否包含所有节点
	public static boolean containsAll(Map<GNode, GNode> edges, int nNode) {
		Set<Integer> nodes = new HashSet<Integer>();
		Set<GNode> _nodes = edges.keySet();
		for (GNode node : _nodes) {
			if(!nodes.contains(node)) nodes.add(node.value);
			GNode _node = edges.get(node);
			if(_node != null) {
				if(!nodes.contains(_node.value)) nodes.add(_node.value);
			}
		}
		if(nodes.size() == nNode) return true;
		return false;
	}
	//新边加入后是否构成环路
	public static boolean isLoop(Map<GNode, GNode> edges, int i, int j) {
		Set<Integer> nodes = new HashSet<Integer>();
		int nEdge = 0;
		nEdge = edges.size()+1;
		Set<GNode> _nodes = edges.keySet();
		for (GNode node : _nodes) {
			if(!nodes.contains(node)) nodes.add(node.value);
			int value = edges.get(node).value;
			if(!nodes.contains(value)) nodes.add(value);
		}
		if(!nodes.contains(i)) nodes.add(i);
		if(!nodes.contains(j)) nodes.add(j);
		if(nodes.size() <= nEdge) {
			return true;
		}
		//				System.out.printf("节点数:%d，边数:%d\n",nodes.size(),nEdge);
		//				System.out.printf("不构成环路:{%s,%s}\n",(char)(i + 65),(char)(j + 65));
		return false;
	}
	public static void printResult(Map<GNode, GNode> edges) {
		Set<GNode> edgeSet = edges.keySet();
		for (GNode node : edgeSet) {
			if(edges.get(node) != null) System.out.printf("{%s,%s} ", (char)(node.value + 65), (char)(edges.get(node).value + 65));
		}
	}
}
//节点的数据结构，用于在Map中生成逻辑上值相同的不同键
class GNode{
	public int value;
	public GNode(int value){
		this.value = value;
	}
}