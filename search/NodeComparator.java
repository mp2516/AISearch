package search;

import java.util.Comparator;

class NodeComparator implements Comparator<Node>{
	
	public int compare(Node n1, Node n2) { 
        return n1.value - n2.value;
    }

}
