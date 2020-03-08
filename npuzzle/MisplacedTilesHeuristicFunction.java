package npuzzle;

import search.Node;
import search.NodeFunction;

public class MisplacedTilesHeuristicFunction implements NodeFunction {

    public int nodeValue(Node node){

        int incorrect_tiles = 0;

        Tiles node_state = (Tiles)node.state;
        int[] tiles = node_state.tiles;
        for(int t = 0; t < tiles.length; t++) {
            if ((tiles[t] != t + 1) && (tiles[t] != 0)){
                incorrect_tiles += 1;
            }
        }
        return incorrect_tiles;
    }

}