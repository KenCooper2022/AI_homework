/**
 * 
 * <p>Title: Node</p>
 * <p>Description: This class models the nodes in the Water Jugs Problem.
 * It uses a State object (x, y) to track the number of gallons of water in the first jug and second jug respectively.
 * It provides a method which can generate all successors nodes of one state.
 * </p>
 * 
 * @author Ting Zhang
 * For assignment 1 of AI in Spring 2023
 * 2/2/2023
 */


import java.util.ArrayList;

public class Node {
	public final int CAPACITY_X = 4;
	public final int CAPACITY_Y = 3;
	
	private int x;
	private int y;
	private State state;
	private Node parent;
	
	/**
	 * constructor method
	 * @param x - water volume in first jug
	 * @param y - water volume in second jug
	 */
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
		this.parent = null;
	}
	public Node(State state, Node parent) {
		this.state = state;
		this.parent = parent;
	}
	
	/**
	 * 
	 * @return the current water volume in first jug
	 */
/*	public int getX() {
		return x;
	} */
	
	/**
	 * 
	 * @return the current water volume in second jug
	 */
/*	public int getY() {
		return y;
	} */
	
	public State getState() {
		return state;
	}
	/**
	 * 
	 * @return the parent state
	 */
	public Node getParent() {
		return parent;
	}
	
	/**
	 * set the parent state of the current node
	 * @param parent
	 */
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	/**
	 * 
	 * @return the set of successors of current node
	 */
	public ArrayList<Node> expand(){
		ArrayList<Node> children = new ArrayList<Node>();
		Node child;
		State newState;
		
		//fill the first jug
		if(state.getX() < CAPACITY_X) {
			newState= new State(CAPACITY_X, state.getY());
			child = new Node(newState, this);
			children.add(child);
		}
		//fill the second jug
		if(state.getY() < CAPACITY_Y) {
			newState= new State(state.getX(), CAPACITY_Y);
			child = new Node(newState, this);
			children.add(child);
		}
		if(state.getX() > 0){
			//empty the first jug
			newState= new State(0, state.getY());
			child = new Node(newState, this);
			children.add(child);
			
			//pour water from first jug to second jug
			if(state.getY() < CAPACITY_Y) {
				int yNew = Math.min(state.getX()+state.getY(), CAPACITY_Y);
				int xNew = state.getX() - (yNew - state.getY());
				newState = new State(xNew, yNew);
				child = new Node(newState, this);
				children.add(child);
			}
				
		}
		if(state.getY() > 0){
			//empty second jug
			newState= new State(state.getX(), 0);
			child = new Node(newState, this);
			children.add(child);
			
			//pour water from second jug to first jug
			if(state.getX() < CAPACITY_X) {
				int xNew = Math.min(state.getX()+state.getY(), CAPACITY_X);
				int yNew = state.getY() - (xNew - state.getX());
				newState = new State(xNew, yNew);
				child = new Node(newState, this);
				children.add(child);
			}
		}
			
		return children;
	}
	
	/**
	 * Express the state in a string
	 */
	public String toString() {
		return state.toString();
	} 
}
