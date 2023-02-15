/**
 * 
 * <p>Title: State</p>
 * <p>Description: This class models the state of the Water Jugs Problem.
 * It uses x, y to track the number of gallons of water in the first jug and second jug respectively.
 * It provides a method which can update the x, y values of a state and a method to check if two state are equal.
 * </p>
 * 
 * @author Ting Zhang
 * For assignment 1 of AI in Spring 2023
 * 2/2/2023
 */

public class State {
	private int x;
	private int y;
	
	public State(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void update(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Object object) {
		boolean result = false;
		if(object == null || object.getClass() != getClass())
			result = false;
		else {
			State state = (State) object;
			if(this.x == state.getX() && this.y == state.getY())
				result = true;
		}
		
		return result;
				
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
