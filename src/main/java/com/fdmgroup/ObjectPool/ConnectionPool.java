package com.fdmgroup.ObjectPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class ConnectionPool {
	private List<Connection> connections = new ArrayList<Connection>();
	private int maxConnections;
	
	private static ConnectionPool INSTANCE = new ConnectionPool();
	
	private ConnectionPool() {}
	
	public static ConnectionPool getInstance() {
		return INSTANCE;
	}

	public List<Connection> getConnections() {
		return connections;
	}

	public void setConnections(List<Connection> connections) {
		this.connections = connections;
	}

	public int getMaxConnections() {
		return maxConnections;
	}

	public void setMaxConnections(int maxConnections) {
		this.maxConnections = maxConnections;
	}

	public Connection connect(String user) {
		// search for available object
		Optional<Connection> availableConnection = connections.stream()
				.filter(e -> e.isAvailable()).findFirst();

		if (availableConnection.isPresent()) {
			// configure connection
			availableConnection.get().setUser(user);
			availableConnection.get().setAvailable(false);
			
			// return connection
			return availableConnection.get();
			
		} else if (connections.size() < maxConnections) {
			// Create a connection if not at max
			Connection newConnection = new Connection(user, false);
			connections.add(newConnection);
			
			// return connection
			return newConnection;
		} else {
			// if no connections are available, 
			// and the maximum amount of connections has been reached,
			// return null
			
			System.out.println("No Connections Available!");
			return null;
		}
	}

	public void disconnect(Connection connection) {
		// Reset and release object
		connection.setUser(null);
		connection.setAvailable(true);
	}

}
