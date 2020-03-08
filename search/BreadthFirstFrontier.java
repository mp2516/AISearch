package search;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstFrontier implements Frontier {
	private Queue<Node> fifoQueue = new LinkedList<Node>();
	private int maxFrontierCounter = 0;
	
	public void addNode(Node node) {
		fifoQueue.add(node);
		if (fifoQueue.size() > maxFrontierCounter) {
			maxFrontierCounter = fifoQueue.size();
		}
	}
	
	public void clearContents() {
		fifoQueue.clear();
	}
	
	public boolean isEmpty() {
		return fifoQueue.isEmpty();
	}
	
	public Node removeNode() {
		return fifoQueue.remove();
	}
	
	public int getMaxFrontierCounter() {
		return maxFrontierCounter;
	}
}
