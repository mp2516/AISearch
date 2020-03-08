package search;

import java.util.HashSet;
import java.util.Set;

public class GraphSearch implements Search {
	
	protected Frontier frontier;
	protected int numNodes = 0;
	
	public GraphSearch(Frontier frontier) {
		this.frontier = frontier;
	}
	
	public Node findSolution(Node rootNode, GoalTest goalTest) {
		
		Set<State> visitedNodeStates = new HashSet<>();
		this.frontier.addNode(rootNode);
		
		while(!this.frontier.isEmpty()) {
			
			Node node = this.frontier.removeNode();
			
			if (goalTest.isGoal(node.state)) {
				return node;
			} else {
				for (Action action : node.state.getApplicableActions()) {
					State newState = node.state.getActionResult(action);
					if (visitedNodeStates.add(newState)) {
						// int maxDepth = 0;
						Node newNode = new Node(node, action, newState);
						this.frontier.addNode(newNode);
						this.numNodes += 1;
					}
					if (this.numNodes > 10000000){
	                    throw new RuntimeException("Code timeout...");
	                }
				}
			}
		}
		return null;
	}
	
	public int numNodes(){
        return this.numNodes;
    }
}
