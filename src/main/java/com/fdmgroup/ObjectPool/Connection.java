package com.fdmgroup.ObjectPool;

public class Connection {
	private String user;
	private boolean isAvailable;
	
	
	
	public Connection(String user, boolean isAvailable) {
		super();
		this.user = user;
		this.isAvailable = isAvailable;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "Connection [user=" + user + ", isAvailable=" + isAvailable + "]";
	}
	
	
}
