package application;

import java.awt.Point;

public class MainApp {

	public static void main(String[] args) {
		
		Nodes nodes = new Nodes();
		
		nodes.addNode(new Point(300, 45));
		nodes.addNode(new Point(400, 234));
		nodes.addNode(new Point(200, 233));
		nodes.addNode(new Point(100, 276));
		nodes.addNode(new Point(34, 66));
		nodes.addNode(new Point(50, 450));
		
		Point start = nodes.head.next.next.point;
		
		NearestPoint np = new NearestPoint(nodes, start);
		
		new Frame(nodes, start, new Point(np.getNearestPoint().x, np.getNearestPoint().y));

	} 
}
