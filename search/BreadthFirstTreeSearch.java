package search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstTreeSearch {
	public static Node findSolution(State initialConfiguration, GoalTest goalTest) {
		// Used to define generic data types <Node>
		Queue<Node> fifoQueue = new LinkedList<Node>();
		fifoQueue.add(new Node(null, null, initialConfiguration));
		// create an instance of the class
		while (!fifoQueue.isEmpty()) {
			// !boolean means the logical opposite, so .isNotEmpty()
			// declaring a variable node from the list
			Node node = fifoQueue.remove();
			if (goalTest.isGoal(node.state))
				return node;
			else {
				for (Action action : node.state.getApplicableActions()) {
					State newState = node.state.getActionResult(action);
					fifoQueue.add(new Node(node, action, newState));
				}
			}
		}
		return null;
	}
}
