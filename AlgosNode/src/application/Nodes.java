package application;

import java.awt.Point;

public class Nodes {
	
	class Node {
		
		Point point;
		boolean visited;
		Node next;
		
		public Node(Point point){
			this.point = point;
			next = null;
		}
		
		public Node(Point point, boolean visited) {
			this.point = point;
			next = null;
			this.visited = visited;
		}
		
		public void setVisitState(boolean visited) {
			this.visited = visited;
		}
		
		public boolean getVisitState() {
			return visited;
		}
	}
	
	public Node head;
	public Node tail;
	
	public void addNode(Point point) {
		
		Node newNode = new Node(point);
		
		if(head == null) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	public int size() {    
        int count = 0;     
        Node current = head;    
            
        while(current != null) {       
            count++;    
            current = current.next;    
        }    
        return count;    
    }  
}
