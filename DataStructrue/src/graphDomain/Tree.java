package graphDomain;

import java.util.Map;
import java.util.Set;

public class Tree {

	private TreeNode root;//根节点
	private int minCost;//最小花费
	private String path;//最小花费对应最短路径

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getMinCost() {
		return minCost;
	}

	public void setMinCost(int minCost) {
		this.minCost = minCost;
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public Tree(){
		root = null;
	}

	/**
	 * @param root 当前根节点（起点城市节点）
	 * @param city	起点城市
	 * @param endCity 终点城市
	 * @param path 起始路径名
	 * @param cost 耗费（默认填零）
	 * @return 返回起点城市所在根节点
	 */
	public TreeNode createTree(TreeNode root, City city, City endCity, String path, int cost){
		//到了终点城市
		if(city.getName().equals(endCity.getName())){
			if(cost<=minCost||minCost==0){//如果此条路径花费小于当前最小花费
				//则此花费为最小花费
				this.minCost = cost;
				//当前路径为最短路径
				this.path = path;
			}
			return root;
		}
		if(root==null){
			root = new TreeNode(city.getName());
		}
		Map<City,Integer> map = city.getConnections();
		//map.keySet()获得键值city集合
		Set<City> cities = map.keySet();
		for(City c:cities){
			if(!path.contains(c.getName())){
				//若该城市还未在路径中
				if(minCost!=0){//已经存在一条花费
					if(cost>minCost){//若未到终点花费已经大于当前最小花费，则无需再往下走
						continue;
					}
				}
				TreeNode newNode = new TreeNode(c.getName(),map.get(c));
				path = path+c.getName();
				cost += map.get(c);
				root.getChilds().add(createTree(newNode,c,endCity,path,cost));
				//开始回溯，则需将path减去当前城市名，cost减去当前城市耗费
				path = path.substring(0, path.length()-c.getName().length());
				cost -= map.get(c);
			}else{
				//若此城市已在路径中
				continue;
			}
		}
		return root;
	}
}
