package application;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

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
		
		//drawLanes(g2d);
		
		g2d.setPaint(Color.RED);
		g2d.draw(new Line2D.Double(start, end));
		
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
		
		//1 to 2
		g2d.draw(new Line2D.Double(head.point.x+25, head.point.y+25, head.next.point.x+25, head.next.point.y+25));
		//1 to 3
		g2d.draw(new Line2D.Double(head.point.x+25, head.point.y+25, head.next.next.point.x+25, head.next.next.point.y+25));
		//1 to 5
		g2d.draw(new Line2D.Double(head.point.x+25, head.point.y+25, head.next.next.next.next.point.x+25, head.next.next.next.next.point.y+25));
		//2 to 3
		g2d.draw(new Line2D.Double(head.next.point.x+25, head.next.point.y+25, head.next.next.point.x+25, head.next.next.point.y+25));
		//3 to 4
		g2d.draw(new Line2D.Double(head.next.next.point.x+25, head.next.next.point.y+25, head.next.next.next.point.x+25, head.next.next.next.point.y+25));
		//4 5o 5
		g2d.draw(new Line2D.Double(head.next.next.next.point.x+25, head.next.next.next.point.y+25, head.next.next.next.next.point.x+25, head.next.next.next.next.point.y+25));
		//4 to 6
		g2d.draw(new Line2D.Double(head.next.next.next.point.x+25, head.next.next.next.point.y+25, head.next.next.next.next.next.point.x+25, head.next.next.next.next.next.point.y+25));
	}
	
	public void drawConnection(Point p1, Point p2) {
		PointsConnection con1To2 = new PointsConnection(p1, p2);
		System.out.println(con1To2.getDistance());
	}
	
}


//if(current.next != null)
//	g2d.draw(new Line2D.Double(current.point.x, current.point.y, current.next.point.x, current.next.point.y));

