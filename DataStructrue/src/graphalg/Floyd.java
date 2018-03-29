package graphalg;
//美如画的最短路径Floyd算法
public class Floyd {

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
		floyd(graph);
	}
	//共更新N次（每换一次中介节点更新一次）
	private static void floyd(int[][] graph) {
		//矩阵P中的元素p[i][j]，表示顶点i到顶点j的最短路径的下一跳是p[i][j]记录的值所表示的顶点。
		int[][] p  = new int[graph.length][graph[0].length];
		//初始化p，每一行都是0~p[i].length-1
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[i].length; j++) {
				p[i][j] = j;
			}
		}
		//中介节点，自增
		int intermediary = 0;
		//还有节点没做中介则继续循环
		while(intermediary < graph.length) {
			for (int i = 0; i < graph.length; i++) {
				for (int j = 0; j < graph[i].length; j++) {
					//不是节点自身，同时i通过中介节点可达j的充要条件是i到中介和中介到i都可达
					if(i != j && graph[i][intermediary] != INF && graph[intermediary][j] != INF){
						//core comparison
						if(graph[i][j] > graph[i][intermediary] + graph[intermediary][j]) {
							//通过中介路径更短
							//update graph and p
							graph[i][j] = graph[j][i] = graph[i][intermediary] + graph[intermediary][j];
							p[i][j] = p[j][i] = intermediary;
						}
					}
				}
			}
			//换下一个中介节点
			intermediary++;
		}
		printMatrix(graph, p);
		printShortestPaths(graph,p, 3);
	}

	private static void printShortestPaths(int[][] graph,int[][] p, int begin) {
		for (int i = 0; i < p[begin].length; i++) {
			if(i != begin) {
				System.out.printf("%s to %s:"+(char)(begin + 65)+"-->",(char)(begin + 65),(char)(i + 65));
				printShortestPaths(p, begin, i);
				System.out.printf(",cost:%d\n", graph[begin][i]);
			}
		}
	}

	private static void printShortestPaths(int[][] p, int begin, int end) {
		int next = p[begin][end];
		if(next != end) {
			System.out.printf("%s-->",(char)(next + 65));
			printShortestPaths(p, next, end);
		}
		else {
			System.out.printf("%s", (char)(next + 65));
		}
	}

	private static void printMatrix(int[][] graph, int[][] p) {
		int g_length = graph.length * 3;
		System.out.printf("%"+g_length+"s\n","Graph");
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				System.out.printf("%3d ", graph[i][j]);
			}
			System.out.println();
		}
		int p_length = p.length * 3;
		System.out.printf("%"+p_length+"s\n","P matrix");
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[i].length; j++) {
				System.out.printf("%3s ", (char)(p[i][j] + 65));
			}
			System.out.println();
		}
	}

}
