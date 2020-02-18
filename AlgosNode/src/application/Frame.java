package application;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.swing.JComponent;
import javax.swing.JFrame;

import application.PointsConnection.Connection;

public class Frame extends JFrame{
	
	public Frame(Nodes nodes, Point start, Point end) {
		setSize(600, 600);
		setResizable(false);
		setTitle("Nodes");
		setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
		setVisible(true);
		getContentPane().add(new Graph(nodes, start, end));
	}

}

class Graph extends JComponent{
	
	Nodes nodes;
	Point start, end;
	
	public Graph(Nodes nodes, Point start, Point end) {
		this.nodes = nodes;
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void paint(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		Nodes.Node current = nodes.head;
		
		drawLanes(g2d);
		
		//g2d.setPaint(Color.RED);
		//g2d.draw(new Line2D.Double(start, end));
		
		g2d.setPaint(Color.BLACK);
		while(current != null) {
			
			g2d.draw(new Rectangle2D.Double(current.point.x, current.point.y, 50, 50));
			
			if(current == nodes.head)
				g2d.drawString("Start", nodes.head.point.x, nodes.head.point.y-5);
			if(current == nodes.tail)
				g2d.drawString("End", current.point.x, current.point.y-5);
			
			current = current.next;
		}
	}
	
	public void drawLanes(Graphics2D g2d) {
		
		Nodes.Node head = nodes.head; //point 1
		
		//all points
		Point p1 = new Point(head.point.x+25, head.point.y+25);
		Point p2 = new Point(head.next.point.x+25, head.next.point.y+25);
		Point p3 = new Point(head.next.next.point.x+25, head.next.next.point.y+25);
		Point p4 = new Point(head.next.next.next.point.x+25, head.next.next.next.point.y+25);
		Point p5 = new Point(head.next.next.next.next.point.x+25, head.next.next.next.next.point.y+25);
		Point p6 = new Point(head.next.next.next.next.next.point.x+25, head.next.next.next.next.next.point.y+25);
		
		//list of connection of specific nodes
		List<Point> p1Cons = connections(p1);
		List<Point> p2Cons = connections(p2);
		List<Point> p3Cons = connections(p3);
		List<Point> p4Cons = connections(p4);
		
		//1 to 2
		//connection of 1 to 2 point
		//g2d.draw(new Line2D.Double(p1.x, p1.y, p2.x, p2.y));
		p1Cons.add(p2);
		
		//1 to 3
		//g2d.draw(new Line2D.Double(p1.x, p1.y, p3.x, p3.y));
		p1Cons.add(p3);
		
		//1 to 5
		//g2d.draw(new Line2D.Double(p1.x, p1.y, p5.x, p5.y));
		p1Cons.add(p5);
		
		//2 to 3
		//g2d.draw(new Line2D.Double(p2.x, p2.y, p3.x, p3.y));
		p2Cons.add(p3);
		
		//3 to 4
		//g2d.draw(new Line2D.Double(p3.x, p3.y, p4.x, p4.y));
		p3Cons.add(p4);
		
		//4 to 5
		//g2d.draw(new Line2D.Double(p4.x, p4.y, p5.x, p5.y));
		p4Cons.add(p5);
		
		//4 to 6
		//g2d.draw(new Line2D.Double(p4.x, p4.y, p6.x, p6.y));
		p4Cons.add(p6);
		
		drawConnections(p4, p4Cons, g2d);
		
		
	}
	
	public void findPath() {
		
		Queue<Point> pointsQueue = new LinkedList<Point>();
		
	}
	
	public void drawConnections(Point root, List<Point> subRoots, Graphics2D g2d) {
		
		NearestPoint np = new NearestPoint(subRoots, root);
		
		for(int i=0;i<subRoots.size();i++) {
			g2d.draw(new Line2D.Double(root, subRoots.get(i)));
		}
		
		g2d.setPaint(Color.RED);
		g2d.draw(new Line2D.Double(root, np.getNearestConnection()));
	}
	
	public List<Point> connections(Point root) {
		
		List<Point> connections = new ArrayList<Point>();
		return connections;
	}
	
}


//if(current.next != null)
//	g2d.draw(new Line2D.Double(current.point.x, current.point.y, current.next.point.x, current.next.point.y));

