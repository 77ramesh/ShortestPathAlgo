package application;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class NearestPoint {

	private Point startPoint, nearestPoint;
	private Nodes nodes;

	public NearestPoint() {}
	
	public NearestPoint(Nodes nodes, Point point) {
		this.nodes = nodes;
		this.startPoint = point;
		
	}
	
	public Point getNearestPoint() {	
		findNearestPoint();
		return nearestPoint;
	}
	
	private void findNearestPoint() {
		
		//the first node will be head
		Nodes.Node node = nodes.head;
		//first point will be targeting to heads point
		nearestPoint = node.next.point;
		
		double closestDist = dist(startPoint.x, nearestPoint.x, startPoint.y, nearestPoint.y);
		
		while(node != null) {
			
			Point p = node.point;
			double dist = dist(startPoint.x, p.x, startPoint.y, p.y);
			
			/*
			 * Note: the first node targets head
			 * if the distance between head.next and start point is less than
			 * the head and the start point, that will be the next small
			 * distance available in the nodes list
			 * */
			if(dist < closestDist && dist != 0.0) {
				closestDist = dist;
				nearestPoint = node.point;
			}
			
			node = node.next;
		}
	}
	
	/*
	 * recursion to loop through
	 * all the nearest points (using node.next).
	 * it will go all the way down
	 * until it reaches the null point or node
	 * that will not be targeting to any
	 * other point or node
	 * */
//	public Queue<Point> pointPath(Nodes.Node node) {
//		
//		Queue<Point> pq = new LinkedList<Point>();
//		
//		
//	}
	
	//d = (x2 - x1 )^2 + (y2 - y1)^2 under root
	private double dist(double x1, double x2, double y1, double y2) {
		return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
	}

	public void setStartPoint(Point point) {
		this.startPoint = point;
	}

	public void setNodes(Nodes nodes) {
		this.nodes = nodes;
	}
	
}
