package search;

public interface Frontier {
	public void addNode(Node node);
	public void clearContents();
	public boolean isEmpty();
	public Node removeNode();
	public int getMaxFrontierCounter();
}

