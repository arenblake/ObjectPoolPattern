package com.fdmgroup.ObjectPool;

import java.util.ArrayList;
import java.util.List;

public class Main {
	

	public static void main(String[] args) {
		List<Connection> connections = new ArrayList<Connection>();
		ConnectionPool connectionPool = new ConnectionPool(connections, 2);
		
		Connection userConnection1 = connectionPool.connect("Jim");
		Connection userConnection2 = connectionPool.connect("Alice");
		Connection userConnection3 = connectionPool.connect("Bob");
		
		connectionPool.disconnect(userConnection2);
		
		System.out.println(connectionPool.getConnections());
		

	}

}
