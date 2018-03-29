package graphDomain;


import java.util.HashMap;
import java.util.Map;

public class City {
	
	private String name;
	
	public City(String name) {
		super();
		this.name = name;
	}

	private Map<City,Integer> connections = new HashMap<City,Integer>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<City, Integer> getConnections() {
		return connections;
	}
	

}
