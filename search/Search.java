package search;

public interface Search {
	public Node findSolution(Node rootNode, GoalTest goalTest);
	public int numNodes();
}
