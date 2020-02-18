package application;

import java.awt.Point;

public class PointsConnection {

	private Point p1, p2;
	
	public PointsConnection() {}
	
	public PointsConnection(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public Connection getConnectedPoints() {
		Connection con = new Connection(p1, p2);
		return con;
	}
	
	public double getDistance() {
		return Math.sqrt(Math.pow(p2.x-p1.x, 2) + Math.pow(p2.y-p1.y, 2));
	}
	
	public class Connection {
		
		Point p1, p2;
		
		public Connection(Point p1, Point p2) {
			this.p1 = p1;
			this.p2 = p2;
		}
	}
}








