package search;

import java.util.Queue;
import java.util.PriorityQueue;

public class BestFirstFrontier implements Frontier {

    protected NodeFunction nodeFunction;

    public BestFirstFrontier(NodeFunction nodeFunction){
        this.nodeFunction = nodeFunction;
    }

    public Queue<Node> priorityQueue = new PriorityQueue<Node>(new NodeComparator());
    public int maxFrontierCounter = 0;

    public void addNode(Node node){
        int nodeValue = this.nodeFunction.nodeValue(node);
        node.setValue(nodeValue);
        priorityQueue.add(node);
        if (priorityQueue.size() > maxFrontierCounter){
            maxFrontierCounter = priorityQueue.size();
        }
    }

    public void clearContents(){
        priorityQueue.clear();
    }

    public boolean isEmpty() {
        if (priorityQueue.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    public Node removeNode(){
        return priorityQueue.poll();
    }

    public int getMaxFrontierCounter(){
        return maxFrontierCounter;
    }
}
