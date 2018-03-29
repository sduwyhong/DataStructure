package graphDomain;

public class graphDemo1 {

	/**
	 * 用树解决城市间最短路径问题
	 * @param args
	 */
	public static void main(String[] args) {
		
		CityMap cm = new CityMap();
		//创建城市实例并命名
		City c1 = new City("汉");
		City c2 = new City("乌");
		City c3 = new City("渝");
		City c4 = new City("京");
		City c5 = new City("沪");
		City c6 = new City("圳");
		//建立城市之间的连接
		c1.getConnections().put(c3, 7);
		c1.getConnections().put(c6, 9);
		c1.getConnections().put(c5, 3);
		c1.getConnections().put(c4, 10);
		
		c2.getConnections().put(c3, 18);
		c2.getConnections().put(c4, 26);
		
		c3.getConnections().put(c2, 18);
		c3.getConnections().put(c1, 7);
		
		c4.getConnections().put(c2, 26);
		c4.getConnections().put(c1, 10);
		c4.getConnections().put(c5, 5);
		
		c5.getConnections().put(c1, 3);
		c5.getConnections().put(c4, 5);
		
		c6.getConnections().put(c1, 9);
		//在地图中添加城市信息
		cm.getCities().add(c1);
		cm.getCities().add(c2);
		cm.getCities().add(c3);
		cm.getCities().add(c4);
		cm.getCities().add(c5);
		cm.getCities().add(c6);
		
		Tree tree = new Tree();
		tree.setRoot(tree.createTree(tree.getRoot(), c1, c4, c1.getName(),0));
		System.out.println("最短路径："+tree.getPath());
		System.out.println("最短路径："+tree.getMinCost());
	}

}
