package search;

import java.util.Stack;

public class DepthFirstFrontier implements Frontier {
	private Stack<Node> lifoStack = new Stack<Node>();
	private int maxFrontierCounter = 0;
	
	public void addNode(Node node) {
		lifoStack.add(node);
		if (lifoStack.size() > maxFrontierCounter) {
			maxFrontierCounter = lifoStack.size();
		}
	}
	
	public void clearContents() {
		lifoStack.clear();
	}
	public boolean isEmpty() {
		return lifoStack.isEmpty();
	}
	public Node removeNode() {
		return lifoStack.pop();
	}
	
	public int getMaxFrontierCounter() {
		return maxFrontierCounter;
	}
}
