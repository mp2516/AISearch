package search;

public class Node {
	// final declaration of variable parent, action and state means that they cannot be changed.
	public final Node parent;
	public final Action action;
	public final State state;
	public int value;
	public int pathCost;
	
	public Node(Node parent, Action action, State state) {
		this.parent = parent;
		this.action = action;
		this.state = state;
		if (parent == null){
			this.pathCost = 0;
		}
		else {
			int actionCost = action.cost();
			this.pathCost = parent.pathCost + actionCost;
		}
	}

	public void setValue(int value){
		this.value = value;
	}
}
