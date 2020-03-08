package npuzzle;

import search.BreadthFirstFrontier;
import search.AStarFunction;
import search.NodeFunction;
import search.DepthFirstFrontier;
import search.BestFirstFrontier;
import search.GraphSearch;
import search.TreeSearch;
import search.Frontier;
import search.GoalTest;
import search.Node;
import search.Search;

public class Run {
	
	public static void main(String[] args) {	
		
		Tiles initialConfiguration = new Tiles(new int[][] {
			{ 7, 4, 2 },
			{ 8, 1, 3 },
			{ 5, 0, 6 }
		});
		
		Node rootNode = new Node(null, null, initialConfiguration);
		
		Frontier frontier = null;
		Search search = null;
		
		NodeFunction heuristicFunction = new MisplacedTilesHeuristicFunction();
		NodeFunction nodeFunction = new AStarFunction(heuristicFunction);
		GoalTest goalTest = new TilesGoalTest();
		
		
		// initialise frontier
		if (args[0].toString().equals("Depth")){
			frontier = new DepthFirstFrontier();
		}
		else if (args[0].toString().equals("Breadth")){
			frontier = new BreadthFirstFrontier();
		}
		else if (args[0].toString().equals("Best")){
			frontier = new BestFirstFrontier(nodeFunction);
		} 
		else {
			throw new IllegalArgumentException("invalid frontier type");
		}

		// initialise search
		if (args[1].toString().equals("Tree")){
			search = new TreeSearch(frontier);
		}
		else if (args[1].toString().equals("Graph")){
			search = new GraphSearch(frontier);
		} else {
			throw new IllegalArgumentException("invalid search type");
		}
		
		Node solution = search.findSolution(rootNode, goalTest);
		new NPuzzlePrinting().printSolution(solution);
		
		int maxFrontierSize = frontier.getMaxFrontierCounter();
		int totalNumNodes = search.numNodes();

		System.out.println(args[0].toString() + " First");
		System.out.println(args[1].toString() + " Search");
		System.out.println("Expanded Nodes: " + totalNumNodes);
		System.out.println("Max Generated on Frontier: " + maxFrontierSize);
	}
}

/*
Depth First
Graph Search
Expanded Nodes: 34266
Max Generated on Frontier: 14480

Depth First
Tree Search
Code timeout...

Breadth First
Graph Search
Expanded Nodes: 4359
Max Generated on Frontier: 1592

Breadth First
Tree Search
Expanded Nodes: 2298273
Max Generated on Frontier: 1473871

Best First
Tree Search
Expanded Nodes: 963
Max Generated on Frontier: 613

Best First
Graph Search
Expanded Nodes: 189
Max Generated on Frontier: 82
 */
