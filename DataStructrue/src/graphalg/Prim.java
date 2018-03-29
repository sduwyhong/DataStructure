package graphalg;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
//最小生成树Prim算法
public class Prim {

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
		prim(graph);
	}

	private static void prim(int[][] graph) {
		Map<GNode, GNode> edges = new LinkedHashMap<GNode, GNode>();
		prim(graph, edges, 0);
		Kruskal.printResult(edges);
	}

	private static void prim(int[][] graph, Map<GNode, GNode> edges, int index) {
		GNode node = new GNode(index);
		edges.put(node, null);
		while(!Kruskal.containsAll(edges, graph.length)) {
			//取当前行最小值
			int min = 0;
			int _j = 0;
			for (int j = 0; j < graph[index].length; j++) {
				//跳过自己
				if(j != index) {
					if(min == 0) {
						min = graph[index][j];
						_j = j;
						continue;
					}
					if(graph[index][j] < min) {
						min = graph[index][j];
						_j = j;
					}
				}
			}
			//			System.out.printf("min:%d, node:%d\n", min, _j);
			//当前行所有节点都已访问，结束循环
			if(min == INF) break;
			//屏蔽访问过的节点
			graph[index][_j] = graph[_j][index] = INF;
			//若到_j的值为当前行最小，判断j是否已经在集合中
			if(!exists(edges, _j)) {
				//键重复会覆盖值，若存在以该node为key的entry的value不为空，需要新建key对象
				if(edges.get(node) != null) {
					//					System.out.printf("以%s为key的entry已经存在！\n", (char)(index + 65));
					edges.put(new GNode(index), new GNode(_j));
				}
				else edges.put(node, new GNode(_j));
				System.out.printf("put{%s,%s}\n", (char)(index + 65), (char)(_j + 65));
				//以_j开始进行搜索
				prim(graph, edges, _j);
			}
		}
	}

	private static boolean exists(Map<GNode, GNode> edges, int _j) {
		Set<GNode> _nodes = edges.keySet();
		for (GNode gNode : _nodes) {
			if(gNode.value == _j) {
				//				System.out.printf("%d exists!\n", _j);
				return true;
			}
			GNode _node = edges.get(gNode);
			if(_node != null && _node.value == _j) {
				//				System.out.printf("%d exists!\n", _j);
				return true;
			}
		}
		//		System.out.printf("%d not exists!\n", _j);
		return false;
	}

}
