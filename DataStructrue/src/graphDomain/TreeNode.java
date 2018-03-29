package graphDomain;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
	
	private String name;//节点名（城市名）
	private int cost;//花费
	private List<TreeNode> childs;//子节点
	public TreeNode(String name){
		this.name = name;
		childs = new ArrayList<TreeNode>();
	}
	public TreeNode(String name, int cost){
		this.name = name;
		this.cost = cost;
		childs = new ArrayList<TreeNode>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public List<TreeNode> getChilds() {
		return childs;
	}
	
}
