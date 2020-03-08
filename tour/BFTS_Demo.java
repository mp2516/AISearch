package tour;


import search.AStarFunction;
import search.BestFirstFrontier;
import search.BreadthFirstFrontier;
import search.DepthFirstFrontier;
import search.Frontier;
import search.GoalTest;
import search.GraphSearch;
import search.Node;
import search.NodeFunction;
import search.Search;
import search.TreeSearch;

public class BFTS_Demo {
	public static void main(String[] args) {
		
		Cities romania = SetUpRomania.getRomaniaMapSmall();
		City startCity = romania.getState("Bucharest");
		
		Node rootNode = new Node (null, null, new TourState(startCity));
		
		GoalTest goalTest = new TourGoalTest(romania.getAllCities(), startCity);
		//NodeFunction heuristicFunction = new RomaniaTourHeuristicFunction();
		//NodeFunction nodeFunction = new AStarFunction(heuristicFunction);
		
		Frontier frontier = null;
		Search search = null;
		
		// initialise frontier
		if (args[0].toString().equals("Depth")){
			frontier = new DepthFirstFrontier();
		}
		else if (args[0].toString().equals("Breadth")){
			frontier = new BreadthFirstFrontier();
		}
		//else if (args[0].toString().equals("Best")){
		//	frontier = new BestFirstFrontier(nodeFunction);
		//} 
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
		new TourPrinting().printSolution(solution);
		
		int maxFrontierSize = frontier.getMaxFrontierCounter();
		int totalNumNodes = search.numNodes();

		System.out.println(args[0].toString() + " First");
		System.out.println(args[1].toString() + " Search");
		System.out.println("Expanded Nodes: " + totalNumNodes);
		System.out.println("Max Generated on Frontier: " + maxFrontierSize);
	}
}
