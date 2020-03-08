package search;

public class AStarFunction implements NodeFunction {

    public final NodeFunction heuristic;

    public AStarFunction(NodeFunction heuristicFunction){   
        this.heuristic = heuristicFunction;
    }

    public int nodeValue(Node node){
        return node.pathCost + this.heuristic.nodeValue(node);
    }
}
