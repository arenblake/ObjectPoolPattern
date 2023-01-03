package com.fdmgroup.ObjectPool;

import java.util.ArrayList;
import java.util.List;

public class Main {
	

	public static void main(String[] args) {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		connectionPool.setMaxConnections(2);
		
		Connection userConnection1 = connectionPool.connect("Jim");
		Connection userConnection2 = connectionPool.connect("Alice");
		
		// Too many connections
//		Connection userConnection3 = connectionPool.connect("Bob");
		
		connectionPool.disconnect(userConnection2);
		
		// Stale State
		userConnection1.setAvailable(true);
		
		System.out.println("Available Connections: " + connectionPool.getConnections());
		

	}

}
