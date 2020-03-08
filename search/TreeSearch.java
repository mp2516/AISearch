package search;

public class TreeSearch implements Search {
	
	protected Frontier frontier;
	protected int numNodes = 0;
	
	public TreeSearch(Frontier frontier) {
		this.frontier = frontier;
	}
	
	public Node findSolution(Node rootNode, GoalTest goalTest){
		
		this.frontier.addNode(rootNode);
		
		while (!this.frontier.isEmpty()) {
			
			Node node = this.frontier.removeNode();
			
			if (goalTest.isGoal(node.state)) {
				System.out.println("Expanded Nodes: " + numNodes);
				return node;
			} else {
				for (Action action : node.state.getApplicableActions()) {
					State newState = node.state.getActionResult(action);
					this.frontier.addNode(new Node(node, action, newState));
					this.numNodes += 1;
				}
				if (this.numNodes > 10000000){
                    throw new RuntimeException("Code timeout...");
                }
			}
		}
		return null;
	}
	
	public int numNodes(){
        return this.numNodes;
    }
}
